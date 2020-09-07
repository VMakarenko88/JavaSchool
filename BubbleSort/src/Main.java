import java.util.Scanner;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        // Сначала получим от пользователя кол-во элементов в массиве
        Scanner in = new Scanner(System.in);
        System.out.print("Input the size of array: ");
        int size = in.nextInt();

        //Затем случайным образом заполним массив
        int[] ar = new int[size];
        Random rand = new Random();
        for (int i = 0; i < size; i++ )
        {
            ar[i] =  rand.nextInt(100);
        }

        // Выведем то, что получилось
        System.out.println("Initial array:");
        for (int i = 0; i < size; i++ )
        {
            System.out.print(ar[i] + " ");
        }
        System.out.println();

        // И, наконец, отсортируем его методом bubble c выводом итогового массива
        System.out.println("Result array:");
        int k;
        for (int i = 0; i < size; i++ )
        {
            for (int j = size - 1; j > i; j--)
            {
                if (ar[j] < ar[i])
                {
                    k = ar[j];
                    ar[j] = ar[i];
                    ar[i] = k;
                }
            }
            System.out.print(ar[i] + " ");
        }

    }

}

