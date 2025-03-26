import java.util.*;

public class CaesarCipher {
    private static int key;
    private static final List<Character> alfabeto_esp = Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'ñ', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v','w', 'x', 'y', 'z', '«', '»', '\'', ':', '-', '!', '¡', '?', '¿', '.', ',', ';', '"', ' ', '\n');
    private static final List<Character> alfabeto_enc = Arrays.asList('λ', 'ж', 'φ', 'ψ', 'Ѫ', 'Ҩ', 'ץ', 'Ӝ', 'ש', 'Ѿ', 'ҙ', 'ω', 'Ѯ', '҂', 'ҥ', 'ѱ', 'Ϟ', 'ґ', 'ӻ', 'Ҕ', 'Ӻ', 'Ѣ', 'Ѭ', 'Ҙ', 'Ӵ', 'Ӱ', 'Ҏ', 'Ϡ', 'ҕ', 'ф', '҈', '§', '†', '∆', '¤', '№', '≠', '≈', '⌐', '∞', '¤', 'щ');

    private static final Map<Character, Integer> indices = new HashMap<>();
    private static final Map<Character, Integer> indicesEnc = new HashMap<>();

    static {
        if (alfabeto_esp.size() != alfabeto_enc.size()) {
            throw new IllegalStateException("Los alfabetos no tienen el mismo tamaño");
        }

        for (int i = 0; i < alfabeto_esp.size(); i++) {
            indices.put(alfabeto_esp.get(i), i);
        }

        for (int i = 0; i < alfabeto_enc.size(); i++) {
            indicesEnc.put(alfabeto_enc.get(i), i);
        }
    }

    public static void encrypt(String pathFile) throws FileManager.InvalidFileException {
        StringBuilder mensajeEsp = FileManager.readFile(pathFile);
        StringBuilder mensajeEnc = new StringBuilder();

        //Ciclo de encriptación
        for (int i = 0; i < mensajeEsp.length(); i++) {
            char c = Character.toLowerCase(mensajeEsp.charAt(i));
            if (indices.containsKey(c)) {
                int pos = indices.get(c);
                int newPos = (pos + key) % alfabeto_esp.size();
                mensajeEnc.append(alfabeto_enc.get(newPos));
            }
        }
        FileManager.writeFile(mensajeEnc, "MensajeEncriptado");
        System.out.println("Archivo encriptado añadido a la carpeta output");
    }

    public static void decrypt(String pathFile) throws FileManager.InvalidFileException {
        StringBuilder mensajeEnc = FileManager.readFile(pathFile);
        StringBuilder mensajeDes = new StringBuilder();

        //Ciclo de desencriptación
        for (int i = 0; i < mensajeEnc.length(); i++) {
            char c = mensajeEnc.charAt(i);
            if (indicesEnc.containsKey(c)) {
                int pos = indicesEnc.get(c);
                int newPos = (pos - key + alfabeto_enc.size()) % alfabeto_enc.size();
                mensajeDes.append(alfabeto_esp.get(newPos));
            }
        }
        FileManager.writeFile(mensajeDes, "MensajeDesencriptado");
        System.out.println("Archivo desencriptado añadido a la carpeta output");

    }

    public static int getKey(){
        return key;
    }

    public static void setKey(int key) throws Validator.InvalidKeyException{
        if (key>alfabeto_esp.size()) throw new Validator.InvalidKeyException();
        else CaesarCipher.key=key;
    }

}
