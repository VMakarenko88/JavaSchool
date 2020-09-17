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
        //заведем счетчик для прохода по строкам



        try {
            //i++;
            File file = new File("C:\\txt4analyze3.txt");
            //создаем объект FileReader для объекта File
            FileReader fr = new FileReader(file);
            //создаем BufferedReader с существующего FileReader для построчного считывания
            BufferedReader reader = new BufferedReader(fr);

            ArrayList<String> rs = new ArrayList<String>();
            // считаем сначала первую строку
            String line = reader.readLine();
            while (line != null) {
                //String[] ar = line.split(" ");
                //ArrayList<String> rs = new ArrayList<String>(Arrays.asList(ar));


                rs.add(line);//System.out.println(line);
                // считываем остальные строки в цикле
                line = reader.readLine();
            }
            //int strlen = rs.size();
            //RevList<String>
            RevList<String> myList = new RevList<String>(rs);

            Iterator<String> myIter = myList.iterator();
            while (myIter.hasNext())
            {
                System.out.println(myIter.next());
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}







