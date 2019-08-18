/*
    Robert Higgins
    Professor Gardner
    Programming II
    2018-02-22

    Assignment: LinkedLists
    In MyLinkedList class, create methods to add an item to the head, tail, or middle of a linked list,
    remove an item from the head, tail, or middle of a linked list, check the size of the list,
    and search for an element in the list.

    Create a test class to use the newly created MyLinkedList class. Add the following names in to the list:
    James, John, Michael, Peter, Allison, Daniel, George, Simon, Jason, and Mark.
    Program should allow the user to enter a name from the console, and search to see if the name exists in the list.
*/
package LinkedLists;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] __args) {
        MyLinkedList<String> list = new MyLinkedList<>();
        list.insertEnd("James");
        list.insertEnd("John");
        list.insertEnd("Michael");
        list.insertEnd("Peter");
        list.insertEnd("Allison");
        list.insertEnd("Daniel");
        list.insertEnd("George");
        list.insertEnd("Simon");
        list.insertEnd("Jason");
        list.insertEnd("Mark");
        list.displayAll();

        System.out.print("Enter name to locate: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = null;
        try {
            input = reader.readLine();
        } catch (IOException e) {
            /* This should never happen */
            System.err.println("IOException");
        }
        if (list.getIndexOf(input) > -1) {
            System.out.println("\"" + input + "\" is at list location: " + list.getIndexOf(input));
        } else {
            System.out.println("\"" + input + "\" is not a member in list ");
        }
    }
}

