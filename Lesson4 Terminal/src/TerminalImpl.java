
import java.io.*;
import java.util.Date;
import java.util.Scanner;

public class TerminalImpl implements Terminal{

    public int chkAccount(){
        return 0;
    }
    public int moveAccount(){
        return 0;
    }



    public TerminalImpl(){
        TerminalServer termserv = new TerminalServer(){};
        PinValidator pincode = new PinValidator();
        int sum = termserv.getSum();
        System.out.printf("Сумма на Вашем счету: "+ sum + ". Введите 1 для снятия денег, 2 - чтобы положить на счет");
        Scanner in = new Scanner(System.in);
        String inp = "";
        while (inp != "1" && inp != "2" )
            inp = in.next();
        if (inp == "1"){
            System.out.printf("Введите желаемую для снятия сумму");
            int sumtake = in.nextInt();
            termserv.changeSum(-sumtake);
        }
        else{
            System.out.printf("Введите желаемую для снятия сумму");
            int suminput = in.nextInt();
            termserv.changeSum(suminput);

        }
        //System.in()
    }


}

class PinValidator{
    private int pin;
    public int getPin() {
        return pin;
    }

    private void setPin(int pin) {
        this.pin = pin;
    }

    private void readData(){
        try {
            File file = new File("C:\\MyPin.txt");
            //создаем объект FileReader для объекта File
            FileReader fr = new FileReader(file);
            //создаем BufferedReader с существующего FileReader для построчного считывания
            BufferedReader reader = new BufferedReader(fr);
            // считаем сначала первую строку
            String line = reader.readLine();
            if (line != null) {
                this.setPin(Integer.parseInt(line));
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public PinValidator(){
        readData();

        Scanner in = new Scanner(System.in);
        int pin = this.getPin();
        int numtries = 0;
        boolean pinIsCorrect = false;
        while (!pinIsCorrect){
            numtries++;
            if (numtries > 3)
                wait10secs();
            System.out.println("Enter pin");
            String str = in.next();
            if (str.length()!=4){
                System.err.println("Введите ровно 4 символа!");
                continue;
            }
            try
            {
                int inputedPin = Integer.parseInt(str);
                if (inputedPin != pin)
                    //System.out.printf("Your pin is incorrect", inputedPin);
                    System.err.println("Your pin is incorrect. Try one more time ");
                else
                    pinIsCorrect = true;
            }
            catch (NumberFormatException e)
            {
                System.err.println("Введены некорректные символы. Допускаются только цифры!");
                continue;
            }

        }
        in.close();

    }

    private void wait10secs() {
        System.out.printf("Количество попыток ввода пин-кода превысило 3. Подождите 10 секунд!");
        long startWait = System.currentTimeMillis();
        try {
            // допустим, выполнение займет 10 секунд
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            long currTime =  System.currentTimeMillis();
            System.err.println("Подождите 10 секунд! Прошло только " + (startWait - currTime)/1000);
        }

    }
}

class TerminalServer{
    private int sum;

    public int getSum() {
        return sum;
    }

    public void changeSum(int sumchanging){
        if (sumchanging % 100 != 0){
            System.err.println("Введена некорректная сумма. Она Должна быть кратна 100!");
        }
        else if (sum + sumchanging < 0 ){
            System.err.println("Сумма, которую вы хотите снять, не должна превышать остаток.");
        }
        else setSum(sum + sumchanging);

    }

    private void setSum(int sum) {
        this.sum = sum;
    }
    private void readData(){
        try {
            File file = new File("C:\\MyAcc.txt");
            //   InputStream file = this.getClass().getResourceAsStream("MyAcc.txt");
            //    file.
            //создаем объект FileReader для объекта File
            FileReader fr = new FileReader(file);
            //создаем BufferedReader с существующего FileReader для построчного считывания
            BufferedReader reader = new BufferedReader(fr);
            // считаем сначала первую строку
            String line = reader.readLine();

            if (line != null) {
                this.setSum(Integer.parseInt(line));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public TerminalServer()
    {        readData();
    }

}