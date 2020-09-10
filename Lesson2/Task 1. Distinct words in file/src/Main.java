import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {

    // построчное считывание файла
    public static void main(String[] args) {
        HashSet<String> hs = new HashSet<String>();
        try {
            File file = new File("C:\\txt4analyze.txt");
            //создаем объект FileReader для объекта File
            FileReader fr = new FileReader(file);
            //создаем BufferedReader с существующего FileReader для построчного считывания
            BufferedReader reader = new BufferedReader(fr);
            // считаем сначала первую строку
            String line = reader.readLine();
            while (line != null) {
                // ArrayList<String> rs = new  ArrayList<String>();//line.split(" ");
                String[] ar = line.split(" ");
                ArrayList<String> rs = new ArrayList<String>(Arrays.asList(ar));
                hs.addAll(rs);

                System.out.println(line);
                // считываем остальные строки в цикле
                line = reader.readLine();
            }
            System.out.println("Distinct words :" + hs.size());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
