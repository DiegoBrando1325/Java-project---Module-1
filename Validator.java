import java.io.*;

public class Validator {

    public void isValidKey(){
    }

    public static boolean doFileExist(String filePath){
        File file = new File(filePath);
        return file.exists() && file.isFile();
    }
}
