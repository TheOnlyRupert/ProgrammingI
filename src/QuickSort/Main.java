/*
    Robert Higgins
    Professor Gardner
    Programming II
    2018-04-23

    Assignment: QuickSort
    Create an array of 5000 randomly generated integers. Use the Quick sort algorithm to sort the elements of the array
    Analyze the efficiency of the program. Specify the best and worst time needed to sort the elements using Quick sort
*/
package QuickSort;

import java.util.Random;

public class Main {
    private static int[] numbers;
    private static long counter = 0;

    public static void main(String[] __array) {
        final int LOOP_COUNTER = 100;

        for (int i = 0; i < LOOP_COUNTER; i++) {
            Main main = new Main();
            main.init();
        }

        System.out.println("QuickSort average lines of code: " + (counter / LOOP_COUNTER));
    }

    private void init() {
        Random random = new Random();
        numbers = new int[5000];

        /* Populate array */
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(8999999) + 1000000;
        }

        /* QuickSort array */
        quickSort(0, numbers.length - 1);

        /* Display sorted array */
        for (int i : numbers) {
            System.out.println(i);
        }
    }

    private void quickSort(int __low, int __high) {
        int i = __low, i2 = __high, pivot = numbers[__high];
        counter = counter + 3;

        while (i <= i2) {
            while (numbers[i] < pivot) {
                i++;
                counter++;
            }
            counter++;

            while (numbers[i2] > pivot) {
                i2--;
                counter++;
            }
            counter++;

            if (i <= i2) {
                int temp = numbers[i];
                numbers[i] = numbers[i2];
                numbers[i2] = temp;
                i++;
                i2--;
                counter = counter + 5;
            }
            counter++;
        }
        counter++;

        if (__low < i2) {
            quickSort(__low, i2);
            counter++;
        }
        counter++;

        if (i < __high) {
            quickSort(i, __high);
            counter++;
        }
        counter++;
    }
}