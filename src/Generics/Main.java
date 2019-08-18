/*
    Robert Higgins
	Professor Gardner
	Programming II
	2018-01-28

    Assignment: Generics and Interfaces
    Sort the students in a gradebook by last NAME or by highest GRADE.
    Write a generic method that returns the maximum and minimum element in a 2D string array (gradebook, NAME, SCORE).
    Test the program using an array of random integers and again using an array of random names.
 */
package Generics;

class GenericSort {
    public static <E extends Comparable<E>> void sort(E[] list) {
        E currentMin;
        int currentMinIndex;
        for (int i = 0; i < list.length - 1; i++) {
            /* Find the minimum in the list[i+1..list.length-2] */
            currentMin = list[i];
            currentMinIndex = i;
            for (int j = i + 1; j < list.length; j++) {
                if (currentMin.compareTo(list[j]) > 0) {
                    currentMin = list[j];
                    currentMinIndex = j;
                }
            }
            /* Swap list[i] with list[currentMinIndex] if necessary */
            if (currentMinIndex != i) {
                list[currentMinIndex] = list[i];
                list[i] = currentMin;
            }
        }
    }

    public static void printList(Object[] list) {
        for (Object aList : list) {
            System.out.print(aList + " | ");
        }
        System.out.println();
    }
}

public class Main {
    public static void main(String[] __args) {
        final String[] names = {"Gularte, Nydia", "Sayegh, Jovita", "Balch, Julianne", "Headley, Dorinda",
                "Haralson, Jasper", "Stansel, Latoyia", "Markert, Patrica", "Armagost, Ron", "Knittel, Dario", "Nery, Renita"};
        final Integer[] grades = {80, 92, 85, 80, 77, 68, 98, 89, 92, 76};

        /* Display the sorted arrays */
        GenericSort.sort(names);
        System.out.print("Sorted Names: ");
        GenericSort.printList(names);

        GenericSort.sort(grades);
        System.out.print("\nSorted Grades: ");
        GenericSort.printList(grades);
    }
}