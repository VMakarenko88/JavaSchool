
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
        //HashSet<String> hs = new HashSet<String>();
    /*    Comparator<String> MyComp = new Comparator<String>()
        {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() > o2.length())
                {
                    return -1;
                }
                else if (o1.length() > o2.length())
                {
                    return 1;

                }
                else return 0;//o1.compareTo(o2);


            }


        };*/

        Comparator<String> comp = Comparator.comparing(s -> s.length());
        comp = comp.thenComparing(s -> s);
        try {
            File file = new File("C:\\txt4analyze.txt");
            //создаем объект FileReader для объекта File
            FileReader fr = new FileReader(file);
            //создаем BufferedReader с существующего FileReader для построчного считывания
            BufferedReader reader = new BufferedReader(fr);
            // считаем сначала первую строку
            String line = reader.readLine();
            TreeSet tr = new TreeSet(comp);
            while (line != null) {
                String[] ar = line.toLowerCase().split(" ");
                ArrayList<String> rs = new ArrayList<String>(Arrays.asList(ar));
                tr.addAll(rs);
                System.out.println(line);
                // считываем остальные строки в цикле
                line = reader.readLine();
            }
             System.out.println("Sorted Array :" + tr);
            System.out.println("Distinct words :" + tr.size());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
