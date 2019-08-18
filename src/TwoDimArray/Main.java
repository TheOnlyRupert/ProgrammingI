/*
    Robert Higgins
	Professor Gardner
	Programming II
	2018-01-28

    Assignment: Two-Dimensional Arrays
    Create a 4-by-4 matrix with the following values: 1-16.
    Read from the matrix and display the sum of the elements in the matrix.
    Display the sum of each row, each column, and the diagonal elements of the matrix.
 */
package TwoDimArray;

public class Main {
    public static void main(String[] __args) {
        int[][] numbers = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        int[] total = new int[4];

        for (int i = 0; i < numbers.length; i++) {
            total[0] = 0;
            total[1] = 0;
            for (int i2 = 0; i2 < numbers[i].length; i2++) {
                total[0] += numbers[i][i2];
                total[1] += numbers[i2][i];
            }
            total[2] += numbers[i][i];
            total[3] += numbers[i][numbers.length - (i + 1)];

            System.out.println("Sum of row " + i + ":      " + total[0]);
            System.out.println("Sum of column " + i + ":   " + total[1]);
        }
        System.out.println("Sum of diagonal 1: " + total[2]);
        System.out.println("Sum of diagonal 2: " + total[3]);
    }
}