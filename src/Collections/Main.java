/*
    Robert Higgins
    Professor Gardner
    Programming II
    2018-04-23

    Assignment: Java Collections Framework
    Create an array list of 10 color words and another of 10 names of objects. There should be one object for each of
    the color words. Next, reads items from the two lists, and stores the 20 items in a linked list.
    Sort and display the linked list in ascending alphabetical order.
*/
package Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> colors = new ArrayList<>();
        ArrayList<String> objects = new ArrayList<>();
        LinkedList<String> list = new LinkedList<>();

        colors.add("yellow");
        colors.add("blue");
        colors.add("red");
        colors.add("green");
        colors.add("white");
        colors.add("brown");
        colors.add("pink");
        colors.add("purple");
        colors.add("black");
        colors.add("orange");

        objects.add("truck");
        objects.add("carrot");
        objects.add("ball");
        objects.add("hat");
        objects.add("train");
        objects.add("book");
        objects.add("yoyo");
        objects.add("dog");
        objects.add("doll");
        objects.add("chair");

        list.addAll(colors);
        list.addAll(objects);

        Collections.sort(list);

        for (String lis : list) {
            System.out.println(lis);
        }
    }
}
