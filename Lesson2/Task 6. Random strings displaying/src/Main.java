import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.regex.Pattern;

public class Main //extends  MySortStr
{

    // построчное считывание файла
    public static void main(String[] args) {
    //заведем счетчик для прохода по строкам
        //int i = 0;
        /*boolean q = false;//пройдена ли последняя строка*/
        Scanner in = new Scanner(System.in);
        System.out.print("Input numbers of strings you wish to display with char ',' ");
        String inputs = in.nextLine();
        //Pattern pattern = Pattern.compile("\\D");//поиск совпадений с шаблоном будет производ
        if (!Pattern.matches("\\d{1,}",inputs.replaceAll(",", "").replaceAll(" ", ""))) {
            System.out.println("Input string is incorrect!");
            return;
        }

        String[] ar = inputs.split(",");
        int counter = ar.length;
        //TreeSet<Integer> ints = new TreeSet<Integer>();
        ArrayList<Integer> ints = new ArrayList<Integer>();
 /*      for (int k = 0; k < ar.length; k++)
        {
            ints.add(Integer.parseInt (ar[i].replaceFirst("0", "")));
        }*/
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
            int strlen = rs.size();

            for (int k = 0; k < counter; k++)
            {
                //ints.add(Integer.parseInt (ar[i].replaceFirst("0", "")));
                int numStr = Integer.parseInt (ar[k].replaceFirst("0", "").replaceFirst(" ", ""));
                if(numStr > strlen || numStr <= 0)
                {
                    System.out.println("String number " + numStr + " is incorrect");
                }
                else
                {
                    System.out.println(rs.get(numStr -1));
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}







