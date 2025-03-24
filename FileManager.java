import java.io.*;

public class FileManager {
    private int j = 0;
    public StringBuilder readFile(String filePath) throws InvalidFileException {
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

    public void writeFile(StringBuilder content) {
        File folder = new File("output");
        if (!folder.exists()) {
            folder.mkdirs();
        }
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(String.format("output/TextoEncriptado%d.txt", j)))){
            writer.write(content.toString());
        } catch (IOException e) {
            System.err.println("Error escribiendo en el archivo: " + e.getMessage());
        }
        j++;
    }

    public class InvalidFileException extends Exception {
        public InvalidFileException() {
            super("Introduce un filepath válido.");
        }
    }

}
