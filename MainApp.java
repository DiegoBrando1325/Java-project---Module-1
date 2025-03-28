import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        System.out.println("\nBienvenido al programa de Cifrado César");

        do {
            System.out.println("\n--- Menú ---");
            System.out.println("1. Encriptar archivo");
            System.out.println("2. Desencriptar archivo con clave");
            System.out.println("3. Reiniciar diccionario");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Por favor, ingrese un número válido.");
                scanner.next();
            }
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1 -> {
                    System.out.print("Ingrese la ruta del archivo a encriptar: ");
                    String pathEnc = scanner.nextLine();
                    System.out.print("Ingrese la clave (entero): ");
                    int keyEnc = scanner.nextInt();
                    scanner.nextLine();
                    try {
                        CaesarCipher.setKey(keyEnc);
                        CaesarCipher.encrypt(pathEnc);
                    } catch (Exception e) {
                        System.err.println("Error: " + e.getMessage());
                    }
                }
                case 2 -> {
                    System.out.print("Ingrese la ruta del archivo a desencriptar: ");
                    String pathDec = scanner.nextLine();
                    System.out.print("Ingrese la clave (entero): ");
                    int keyDec = scanner.nextInt();
                    scanner.nextLine();
                    try {
                        CaesarCipher.setKey(keyDec);
                        CaesarCipher.decrypt(pathDec);
                    } catch (Exception e) {
                        System.err.println("Error: " + e.getMessage());
                    }
                }
                case 3 -> {
                    Validator.reiniciarDiccionario();
                    System.out.println("Diccionario reiniciado correctamente.");
                }
                case 0 -> System.out.println("Saliendo del programa. ¡Hasta luego!");
                default -> System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 0);

        scanner.close();
    }
}
