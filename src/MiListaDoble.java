import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Objects;

public class MiListaDoble implements ListInterface {
    private DoubleNode head;
    private DoubleNode tail;
    private int size;

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public Object getHead() { //Nos devuelve el dato de la cabeza, o nulo si llega a estar la lista vacia
        return isEmpty() ? null : head.dato;
    }

    @Override
    public Object getTail() {
        return isEmpty() ? null : tail.dato;
    }

    @Override
    public Object get(DoubleNode node) {
        return node == null ? null : node.dato;
    }

    @Override
    public DoubleNode search(Object object) { //Me devuelve el primer nodo, cuyo dato sea igual a object
        DoubleNode actual = head;
        while (actual != null) {
            if (Objects.equals(actual.dato, object)) {
                return actual;
            }
            actual = actual.siguiente;
        }
        return null;
    }

    @Override
    public boolean add(Object object) {
        return insertTail(object);
    }

    @Override
    public boolean insert(DoubleNode node, Object object) { //Me inserta un nodo nuevoo con Object despues de node.
        if (node == null || isEmpty()) {
            return false;
        }
        if (node == tail) {
            return insertTail(object);
        }
        DoubleNode nuevo = new DoubleNode(object);
        DoubleNode sig = node.siguiente;
        nuevo.anterior = node;
        nuevo.siguiente = sig;
        node.siguiente = nuevo;
        sig.anterior = nuevo;
        size++;
        return true;
    }

    @Override
    public boolean insert(Object objectRef, Object object) {
        DoubleNode ref = search(objectRef);
        if (ref == null) {
            return false;
        }
        return insert(ref, object);
    }

    @Override
    public boolean insertHead(Object object) {
        DoubleNode nuevo = new DoubleNode(object);
        if (isEmpty()) {
            head = nuevo;
            tail = nuevo;
        } else {
            nuevo.siguiente = head;
            head.anterior = nuevo;
            head = nuevo;
        }
        size ++;
        return true;
    }

    @Override
    public boolean insertTail(Object object) {
        DoubleNode nuevo = new DoubleNode(object);
        if (isEmpty()) {
            head = nuevo;
            tail = nuevo;
        } else {
            nuevo.anterior = tail;
            tail.siguiente = nuevo;
            tail = nuevo;
        }
        size++;
        return true;
    }

    @Override
    public boolean set(DoubleNode node, Object object) {
        if (node == null) {
            return false;
        }
        node.dato = object;
        return true;
    }

    @Override
    public boolean remove(DoubleNode node) {
        if (node == null || isEmpty()) {
            return false;
        }

        if (node != head && node.anterior == null) {
            return false;
        }
        if (node != tail && node.siguiente == null) {
            return false;
        }

        if (node == head) {
            head = node.siguiente;
        } else {
            node.anterior.siguiente = node.siguiente;
        }

        if (node == tail) {
            tail = node.anterior;
        } else {
            node.siguiente.anterior = node.anterior;
        }

        node.anterior = null;
        node.siguiente = null;
        size--;
        return true;
    }

    @Override
    public boolean contains(Object object) {
        return search(object) != null;
    }

    @Override
    public Object[] toArray() {
        Object[] arreglo = new Object[size];
        int i = 0;
        DoubleNode actual = head;
        while (actual != null) {
            arreglo[i++] = actual.dato;
            actual = actual.siguiente;
        }
        return arreglo;
    }

    @Override
    public Object[] toArray(Object[] object) {
        Object[] arreglo = object;
        if (arreglo == null) {
            arreglo = new Object[size];
        } else if (arreglo.length < size) {
            arreglo = (Object[])Array.newInstance(arreglo.getClass().getComponentType(),size);
        }
        int i = 0;
        DoubleNode actual = head;
        while (actual != null) {
            arreglo[i++] = actual.dato;
            actual = actual.siguiente;
        }
        if (arreglo.length > size) {
            arreglo[size] = null;
        }
        return arreglo;
    }


    @Override
    public MiListaDoble subList(DoubleNode from, DoubleNode to) {
        if (from == null || to == null) {
            return null;
        }
        MiListaDoble sub = new MiListaDoble();
        DoubleNode actual = from;
        while (actual != null) {
            sub.insertTail(actual.dato);
            if (actual == to) {
                return sub;
            }
            actual = actual.siguiente;
        }
        return null;
    }

    @Override
    public MiListaDoble sortList() {
        Object[] arreglo = toArray();
        Arrays.sort(arreglo, (a, b) -> ((Comparable) a).compareTo(b));
        MiListaDoble ordenada = new MiListaDoble();
        for (Object o : arreglo) {
            ordenada.insertTail(o);
        }
        return ordenada;
    }
}
