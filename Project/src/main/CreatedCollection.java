import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CreatedCollection {

    List<String> readBase = new ArrayList<>();

    public List readFile() {
        String line;
        try {
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(System.getProperty("user.dir") + "\\src\\main\\resources\\DataBase.txt"));
                while ((line = bufferedReader.readLine()) != null) {
                    readBase.add(line);
                }
            } catch (FileNotFoundException e) {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(System.getProperty("user.dir") + "\\Project\\src\\main\\resources\\DataBase.txt"));
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

    public List writeFile() {
        BufferedWriter bufferedWriter = null;
        try {
            try {
                bufferedWriter = new BufferedWriter(new FileWriter(System.getProperty("user.dir") + "\\src\\main\\resources\\DataBase.txt"));
            } catch (FileNotFoundException e) {
                bufferedWriter = new BufferedWriter(new FileWriter(System.getProperty("user.dir") + "\\Project\\src\\main\\resources\\DataBase.txt"));
            }
            for (String str1 : readBase
            ) {
                bufferedWriter.write(str1);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedWriter.flush();
            } catch (IOException e) {
                System.out.println(e);
            }
        }
        return readBase;
    }

}