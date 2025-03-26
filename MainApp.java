public class MainApp {

    public void encrypt(){
    }

    public void decrypt(){
    }

    public void brutForce(){
    }

    public void analEst(){
    }

    public static void main(String[] args) throws FileManager.InvalidFileException, Validator.InvalidKeyException {
        System.out.println("Antes del encryptado");
        CaesarCipher.setKey(3);
        System.out.println("Antes del encryptado");
        CaesarCipher.encrypt("D:\\Drivers\\IntelliJ\\Projects\\PF-Mod1-DiegoMercado\\Prueba.txt");
        System.out.println("Después del encryptado");
        CaesarCipher.decrypt("D:\\Drivers\\IntelliJ\\Projects\\PF-Mod1-DiegoMercado\\output\\MensajeEncriptado.txt");
        System.out.println("Después del desencriptado");
        System.out.println(CaesarCipher.getKey());
        Predict.decryptByBrutForce("D:\\Drivers\\IntelliJ\\Projects\\PF-Mod1-DiegoMercado\\output\\MensajeEncriptado.txt");
        System.out.println("Después de brut force");
        //Validator.reiniciarDiccionario();
    }
}

