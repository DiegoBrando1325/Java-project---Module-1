import java.util.List;

public class Predict {

    public static void decryptByBrutForce(String pathFile) throws FileManager.InvalidFileException {
        for (int i = 1; i<=CaesarCipher.getAlfabetoSize(); i++){
            StringBuilder iteracion = CaesarCipher.decrypt(pathFile, i);
            if (Validator.compararDiccionario(iteracion)) {
                FileManager.writeFile(iteracion, "MensajeDesencriptado_BrutForce");
                System.out.println("Archivo predecido con brut force añadido a la carpeta output");
                break;
            }
        }
    }

    //public void decryptByAnalEst(){}

}
