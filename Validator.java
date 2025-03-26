import java.io.*;
import java.util.*;

public class Validator {

    public static Set<String> diccionario = new HashSet<>();

    public static boolean doFileExist(String filePath){
        File file = new File(filePath);
        return file.exists() && file.isFile();
    }

    public static class InvalidKeyException extends Exception {
        public InvalidKeyException() {
            super("Introduce un numero de key válido menor a: 42");
        }
    }

    public static boolean compararDiccionario(StringBuilder posibleMensaje) {
        String[] posiblesPalabras = posibleMensaje.toString().toLowerCase().split("\\s+");

        for (String palabra : posiblesPalabras) {
            palabra = palabra.replaceAll("[^a-záéíóúñü]", "");

            if (palabra.length() > 3 && diccionario.contains(palabra)) {
                return true;
            }
        }

        return false;
    }

    public static void registrarPalabras(StringBuilder texto) {
        if (texto == null) return;

        String[] palabras = texto.toString().split("\\s+");

        for (String palabra : palabras) {
            palabra = palabra.toLowerCase();
            if (palabra.length() > 3) {
                diccionario.add(palabra);
            }
        }
    }

    public static void reiniciarDiccionario() {
        diccionario.clear();
    }

}