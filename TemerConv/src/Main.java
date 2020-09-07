import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("write the temperature in Celsius");
        Scanner in = new Scanner(System.in);
        double celsTemp = in.nextDouble();
        if (celsTemp < -273.15 ){

            System.out.println("The temperature must be upper -273.15 in Celsius");
            return;

        }
        ConvToFahr fr = new ConvToFahr(celsTemp);
        System.out.println("The temperature in Fahrenheit " + fr.getVal());
        ConvToKelvin kv = new ConvToKelvin(celsTemp);
        System.out.println("The temperature in Kelvin " + kv.getVal());

    }
}
