
import java.util.*;

public class Main {

    public static void main(String[] args) {

        ArrayList<Car> lst = new ArrayList<Car>();
        lst.add(new Car("Lada", "Sedan"));
        lst.add(new Car("Ford", "Hatchback"));
        lst.add(new Car("Mercedes", "Sedan"));
        lst.add(new Car("Mercedes", "Coupe"));
        lst.add(new Car("Peugeot", "Hatchback"));
        lst.add(new Car("Lada", "Hatchback"));

        HashMap<String, ArrayList<String>> hs= new  HashMap<String, ArrayList<String>>();
        for (Car cr : lst
        ) {
            if (hs.keySet().contains(cr.type))
            {
                hs.get(cr.type).add(cr.model);
            }
            else
            {
                ArrayList<String> nlst= new ArrayList<String>();
                nlst.add(cr.model);
                hs.put(cr.type, nlst);
            }
        }
        System.out.println(hs);

    }
}

class Car
{
    public String model;
    public String type;
    public Car(String m, String tp)
    {
        this.model = m;
        this.type = tp;
    }
}

