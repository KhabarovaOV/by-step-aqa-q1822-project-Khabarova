import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CreatedCollection {

    List<String> readBase = new ArrayList<>();

    public List readFile() {
        String line;
        try {
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(System.getProperty("user.dir") + "\\src\\sources\\resources\\DataBase.txt"));
                while ((line = bufferedReader.readLine()) != null) {
                    readBase.add(line);
                }
            } catch (FileNotFoundException e) {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(System.getProperty("user.dir") + "\\Project\\src\\sources\\resources\\DataBase.txt"));
                while ((line = bufferedReader.readLine()) != null) {
                    readBase.add(line);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException em) {
            em.printStackTrace();
        }
        return readBase;
    }
}