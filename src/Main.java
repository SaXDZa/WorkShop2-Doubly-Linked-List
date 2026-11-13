import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MiListaDoble lista = new MiListaDoble();
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n===== MENÚ LISTA DOBLE =====");
            System.out.println("1. Agregar al final (add)");
            System.out.println("2. Insertar en la cabeza");
            // ...una línea por cada operación que quieras probar
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Dato: ");
                    lista.add(sc.nextInt());
                    break;
                case 2:
                    System.out.print("Dato: ");
                    lista.insertHead(sc.nextInt());
                    break;
                // ...un case por cada operación
                case 0:
                    System.out.println("Adiós");
                    break;
                default:
                    System.out.println("Opción no válida");
            }
            System.out.println("Lista: " + lista);
        } while (opcion != 0);
    }
}
