import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main //extends  MySortStr
{

    // построчное считывание файла
    public static void main(String[] args) {

        try {
            File file = new File("C:\\txt4analyze2.txt");
            //создаем объект FileReader для объекта File
            FileReader fr = new FileReader(file);
            //создаем BufferedReader с существующего FileReader для построчного считывания
            BufferedReader reader = new BufferedReader(fr);
            HashMap<String, Integer> hs= new  HashMap<String, Integer>();
            // считаем сначала первую строку
            String line = reader.readLine();
            while (line != null) {
                String[] ar = line.split(" ");
                //ArrayList<String> rs = new ArrayList<String>(Arrays.asList(ar));
                for (String str: ar)
                {
                    if (hs.keySet().contains(str))
                    {
                        int currentCount = hs.get(str);
                        hs.put(str, ++currentCount);
                    }
                    else
                    {
                        hs.put(str, 1);
                    }

                }
                System.out.println(line);
                // считываем остальные строки в цикле
                line = reader.readLine();
            }
            System.out.println(hs);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



