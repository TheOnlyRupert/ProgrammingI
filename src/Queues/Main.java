/*
    Robert Higgins
    Professor Gardner
    Programming II
    2018-03-04

    Assignment: Queues
    Use the linked list created in Assignment 3.1 Create a queue class which must include a method to insert elements
    into the queue, remove elements from the queue, look at the first and last element of the queue (without removing
    elements), and search for an element.

    Choose a random integer (1 to 5) to determine the minutes at which a customer arrives.
    When a customer arrives, choose a random integer (1 to 5) to determine the number of minutes that the customer must
    remain in the checkout line. Repeat the two steps for a 12 hour (720 minute) simulation.
    Run the simulation again with a random integer of 1 and 3 to compare the number of customers in the checkout line
    against the original 12 hour simulation.
 */
package Queues;

import LinkedLists.MyLinkedList;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Queue<String> queue = new Queue<>();
        Random random = new Random();
        int total = 0, customerID = 0;

        while (total < 720) {
            random.nextInt(5);
            queue.enqueue("Customer" + customerID);
            customerID++;
            total = total + random.nextInt(5);

            random.nextInt(5);
        }
    }
}

class Queue<E> {
    private MyLinkedList<E> list = new MyLinkedList<>();

    public void enqueue(E e) {
        list.insertEnd(e);
    }

    public void dequeue() {
        list.deleteEnd();
    }

    public void inspectQueue() {

    }

    public void searchQueue() {

    }

    public int getSize() {
        return list.getSize();
    }

    @Override
    public String toString() {
        return "Queue: " + list.toString();
    }
}