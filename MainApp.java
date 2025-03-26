public class MainApp {

    public void encrypt(){
    }

    public void decrypt(){
    }

    public void brutForce(){
    }

    public void analEst(){
    }

    public static void main(String[] args) throws FileManager.InvalidFileException {
        System.out.println("Antes del encryptado");
        CaesarCipher.encrypt("D:\\Drivers\\IntelliJ\\Projects\\PF-Mod1-DiegoMercado\\Prueba.txt");
        System.out.println("Después del encryptado");
        CaesarCipher.decrypt("D:\\Drivers\\IntelliJ\\Projects\\PF-Mod1-DiegoMercado\\output\\TextoProcesado1.txt");
        System.out.println("Después del desencriptado");
    }
}
