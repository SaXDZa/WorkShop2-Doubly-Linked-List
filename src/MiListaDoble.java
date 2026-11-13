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
        
        return false;
    }

    @Override
    public boolean set(DoubleNode node, Object object) {
        return false;
    }

    @Override
    public boolean remove(DoubleNode node) {
        return false;
    }

    @Override
    public boolean contains(Object object) {
        return false;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public Object[] toArray(Object[] object) {
        return new Object[0];
    }

    @Override
    public MiListaDoble subList(DoubleNode from, DoubleNode to) {
        return null;
    }

    @Override
    public MiListaDoble sortList() {
        return null;
    }
}
