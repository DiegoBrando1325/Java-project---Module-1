import java.io.*;

public class FileManager {

    public static StringBuilder readFile(String filePath) throws InvalidFileException {
        if (Validator.doFileExist(filePath)){
            StringBuilder content = new StringBuilder();

            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                String linea;
                while ((linea = reader.readLine()) != null) {
                    content.append(linea).append("\n");
                }
            } catch (IOException e) {
                System.err.println("Error leyendo el archivo: " + e.getMessage());
            }
            return content;
        } else {
            throw new InvalidFileException();
        }
    }

    public static void writeFile(StringBuilder content, String fileName) {
        File folder = new File("output");
        if (!folder.exists()) {
            folder.mkdirs();
        }
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(String.format("output/"+ fileName +".txt")))){
            writer.write(content.toString());
        } catch (IOException e) {
            System.err.println("Error escribiendo en el archivo: " + e.getMessage());
        }
    }

    public static class InvalidFileException extends Exception {
        public InvalidFileException() {
            super("Introduce un filepath válido.");
        }
    }

}
