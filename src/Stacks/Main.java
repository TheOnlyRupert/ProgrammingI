/*
    Robert Higgins
    Professor Gardner
    Programming II
    2018-02-22

    Assignment: Stacks
    The Fibonacci numbers form a sequence where each number is the sum of the previous two numbers.
    Starting from 0 and 1, the first eight Fibonacci numbers are built in the following list using the equation
    F n = F n-1 + F n-2   ->  0, 0   0, 1    1, 1    1, 2    2, 3    3, 5    5, 8    and   8, 13

    Using MyLinkedList, create a stack class and a test program to display the first 50 Fibonacci numbers in
    descending order. Use a stack to store these numbers. Once 50 numbers have been computed, print the numbers in a
    descending order. Use recursion to find this series of Fibonacci numbers.
 */
package Stacks;

import BinaryTree.BST;
import LinkedLists.MyLinkedList;

class Main {
    public static final boolean useBST = true;
    public static long counter;
    public static BST<Long> bst = new BST<>();
    public static BST<Long> bst2 = new BST<>();

    public static void main(String[] args) {
        GenericStack<Long> genericStack = new GenericStack<>();
        final int fibLength = 20;

        System.out.println("Recursive:");
        counter = 0;
        Fib_Rec fib_rec = new Fib_Rec();
        for (int i = 0; i <= fibLength; i++) {
            genericStack.push(fib_rec.fib(i));
        }
        if (useBST) {
            System.out.println("Recursive lines (bst):     " + bst.getSize());
        }
        System.out.println("Recursive lines (counter): " + counter);

        System.out.println("\n\nNon-Recursive:");
        counter = 0;
        Fib_NonRec fib_nonRec = new Fib_NonRec();
        fib_nonRec.fib(fibLength);
        if (useBST) {
            System.out.println("Non-Recursive lines (bst):     " + bst2.getSize());
        }
        System.out.println("Non-Recursive lines (counter): " + counter);
    }
}

class Fib_Rec {
    public long fib(int __num) {
        if (__num == 0) {
            Main.counter++;
            if (Main.useBST) {
                Main.bst.insert(Main.counter);
            }
            return 0;
        } else if (__num == 1 || __num == 2) {
            Main.counter++;
            if (Main.useBST) {
                Main.bst.insert(Main.counter);
            }
            return 1;
        } else {
            Main.counter++;
            if (Main.useBST) {
                Main.bst.insert(Main.counter);
            }
            return fib(__num - 1) + fib(__num - 2);
        }
    }
}

class Fib_NonRec {
    public void fib(int __num) {
        GenericStack<Long> genericStack = new GenericStack<>();
        long n1 = 1, n2 = 1, temp;

        genericStack.push(0L);
        genericStack.push(n1);
        genericStack.push(n2);

        /* Counter stuff */
        if (Main.useBST) {
            for (int i = 0; i < 6; i++) {
                Main.bst2.insert(Main.counter + i);
            }
        }
        Main.counter += 5;

        for (int i = 2; i < __num; i++) {
            temp = n1;
            n1 = n2;
            n2 += temp;
            genericStack.push(n2);

            /* Counter stuff */
            if (Main.useBST) {
                for (int i2 = 0; i2 < 4; i2++) {
                    Main.bst2.insert(Main.counter + i2);
                }
            }
            Main.counter += 4;
        }
    }
}

class GenericStack <E> {
    private MyLinkedList<E> stack = new MyLinkedList<>();
    private int top = 0;

    public int size() {
        return top;
    }

    public void push(E item) {
        top++;
        stack.insertEnd(item);
        System.out.println("Added: \"" + item + "\" to the stack");
    }

    public void pop() {
        top--;
        stack.deleteEnd();
        System.out.println("Deleted last item from the stack");
    }

    public boolean isEmpty() {
        return stack.getSize() == 0;
    }
}