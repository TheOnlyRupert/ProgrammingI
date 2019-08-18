/*
    Robert Higgins
    Professor Gardner
    Programming II
    2018-04-16

    Assignment: BubbleSort
    Use "Bubble Sort" algorithm to sort the numbers. Create an array of 5,000 randomly generated seven-digit integers.
    Use the Bubble sort algorithm to sort the elements of the array. As you did in Assignment 8.1, analyze the
    efficiency of the program. Specify the best and worst case time needed to sort the elements using Bubble sort.
*/
package BubbleSort;

import java.util.Random;

public class Main {
    private static long counter = 0;

    public static void main(String[] args) {
        final int LOOP_COUNTER = 100;

        for (int i = 0; i < LOOP_COUNTER; i++) {
            Main main = new Main();
            main.init();
        }

        System.out.println("BubbleSort average lines of code: " + (counter / LOOP_COUNTER));
    }

    private static void bubbleSort(int[] __array) {
        int n = __array.length, temp;
        counter = counter + 2;

        for (int i = 0; i < n; i++) {
            for (int i2 = 1; i2 < (n - i); i2++) {
                if (__array[i2 - 1] > __array[i2]) {
                    temp = __array[i2 - 1];
                    __array[i2 - 1] = __array[i2];
                    __array[i2] = temp;
                    counter = counter + 3;
                }
                counter++;
            }
            counter++;
        }
        counter++;
    }

    private void init() {
        int[] numbers = new int[5000];
        Random random = new Random();

        /* Populate array */
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(8999999) + 1000000;
        }

        /* Bubble sort array */
        bubbleSort(numbers);

        /* Display sorted array */
        for (int number : numbers) {
            System.out.println(number);
        }
    }
}