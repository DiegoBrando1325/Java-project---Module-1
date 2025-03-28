import java.io.*;
import java.util.*;

public class Validator {

    private static final Set<String> diccionario = new HashSet<>();
    private static final String PATH_DICCIONARIO = "diccionario.txt";

    static {
        cargarDiccionarioDesdeArchivo(PATH_DICCIONARIO);
    }

    public static boolean doFileExist(String filePath) {
        File file = new File(filePath);
        return file.exists() && file.isFile();
    }

    public static class InvalidKeyException extends Exception {
        public InvalidKeyException() {
            super("Introduce un número de key válido menor a: 42");
        }
    }

    public static int contarCoincidenciasDiccionario(StringBuilder posibleMensaje) {
        String[] posiblesPalabras = posibleMensaje.toString().toLowerCase().split("\\s+");
        int coincidencias = 0;

        for (String palabra : posiblesPalabras) {
            palabra = palabra.replaceAll("[^a-zñáéíóúü]", "");

            if (palabra.length() > 3 && diccionario.contains(palabra)) {
                coincidencias++;
            }
        }

        return coincidencias;
    }

    public static boolean compararDiccionario(StringBuilder posibleMensaje) {
        return contarCoincidenciasDiccionario(posibleMensaje) >= 2;
    }

    public static void registrarPalabras(StringBuilder texto) {
        if (texto == null) return;

        String[] palabras = texto.toString().split("\\s+");
        boolean huboPalabraNueva = false;

        for (String palabra : palabras) {
            palabra = palabra.toLowerCase().replaceAll("[^a-zñáéíóúü]", "");
            if (palabra.length() > 3 && diccionario.add(palabra)) {
                huboPalabraNueva = true;
            }
        }

        if (huboPalabraNueva) {
            guardarDiccionario();
        }
    }

    public static void reiniciarDiccionario() {
        diccionario.clear();
        guardarDiccionario();
    }

    public static void cargarDiccionarioDesdeArchivo(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                linea = linea.trim().toLowerCase();
                if (linea.length() > 3) {
                    diccionario.add(linea);
                }
            }
        } catch (IOException e) {
            System.err.println("No se pudo cargar el diccionario: " + e.getMessage());
        }
    }

    private static void guardarDiccionario() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(PATH_DICCIONARIO))) {
            for (String palabra : diccionario) {
                writer.write(palabra);
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error al guardar el diccionario: " + e.getMessage());
        }
    }

    public static Set<String> getDiccionario() {
        return diccionario;
    }
}
