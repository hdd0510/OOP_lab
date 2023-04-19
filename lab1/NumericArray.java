package OOP_lab.lab1;

import java.util.Scanner;
import java.util.Arrays;

public class NumericArray {
    public static int sum(int[] array) {
        int sum = 0;
        for (int i : array) {
            sum += i;
        }
        return sum;
    }

    public static double average(int[] array) {
        double res = (double) NumericArray.sum(array) / array.length;
        return res;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] array1 = new int[n];
        for (int i = 0; i < n; i++) {
            array1[i] = input.nextInt();
        }
        input.close();
        System.out.println("Original array: " + Arrays.toString(array1));
        Arrays.sort(array1);
        System.out.println("After sorted, Array is: " + Arrays.toString(array1));
        System.out.println("Sum of array is: " + NumericArray.sum(array1));
        System.out.println("Average of array is: " + NumericArray.average(array1));
    }
}
