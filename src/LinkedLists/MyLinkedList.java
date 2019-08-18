/*
    Robert Higgins
    Professor Gardner
    Programming II
    2018-02-22

    Subclass of assignment: LinkedLists
*/
package LinkedLists;

public class MyLinkedList<E> {
    private Node headNode;
    private int size = 0;

    /**
     * Add a new element at the end of this list
     */
    public void insertEnd(E __data) {
        Node node = new Node();
        node.data = __data;
        node.next = null;

        if (headNode == null) {
            headNode = node;
        } else {
            Node nodeNext = headNode;
            while (nodeNext.next != null) {
                nodeNext = nodeNext.next;
            }
            nodeNext.next = node;
        }
    }

    /**
     * Add a new element at the start of this list
     */
    public void insertStart(E e) {
        Node node = new Node();
        node.data = e;
        node.next = headNode;
        headNode = node;
    }

    /**
     * Add a new element at the specified index in this list (__index -1 will be adding to middle)
     */
    public void insertAt(E e, int __index) {
        Node node = new Node();
        node.data = e;
        node.next = null;

        /* Fix for inserting at start of list */
        if (__index == 0) {
            insertStart(e);
        } else {
            Node nodeNext = headNode;

            /* Inserting at middle of list (__index -1)*/
            if (__index == -1) {
                __index = getMiddleIndex();
            }

            nodeNext = headNode;

            for (int i = 0; i < __index - 1; i++) {
                nodeNext = nodeNext.next;
            }
            node.next = nodeNext.next;
            nodeNext.next = node;
        }
    }

    /**
     * Clear everything from the list
     */
    public void clear() {

    }

    public boolean isEmpty() {
        return getSize() == 0;
    }

    /**
     * Remove the element at the end of the list.
     */
    public void deleteEnd() {
        System.out.println("DELETED: " + headNode.data);
        headNode = headNode.next;
    }

    /**
     * Remove the element at the start of the list.
     */
    public void deleteStart() {
        Node nodeNext = headNode, nodeNext2;

        for (int i = 0; i < getSize() - 1; i++) {
            nodeNext = nodeNext.next;
        }
        nodeNext2 = nodeNext.next;
        nodeNext.next = nodeNext2.next;
        System.out.println("DELETED: " + nodeNext2.data);
    }

    /**
     * Remove the element at the specified position in this list.
     * Shift any subsequent elements to the left.
     * Return the element that was removed from the list.
     * __index -1 will be deleted from middle
     */
    public void deleteAt(int __index) {
        Node nodeNext = headNode, nodeNext2;

        /* Inserting at middle of list (__index -1)*/
        if (__index == -1) {
            __index = getMiddleIndex();
        }

        for (int i = 0; i < __index - 1; i++) {
            nodeNext = nodeNext.next;
        }
        nodeNext2 = nodeNext.next;
        nodeNext.next = nodeNext2.next;
        System.out.println("DELETED: " + nodeNext2.data);
    }

    public int getSize() {
        int index = 0;
        Node node = new Node();
        node.next = null;
        Node nodeNext = headNode;

        while (nodeNext.next != null) {
            nodeNext = nodeNext.next;
            index++;
        }
        return index;
    }

    public int getMiddleIndex() {
        return getSize() / 2;
    }

    public int getIndexOf(E __data) {
        int index = 0;
        Node nodeNext = headNode;

        while (nodeNext != null) {
            if (nodeNext.data.equals(__data)) {
                return index;
            }
            index++;
            nodeNext = nodeNext.next;
        }
        return -1;
    }

    public void displayAll() {
        Node node = headNode;
        while (node.next != null) {
            System.out.println(node.data);
            node = node.next;
        }
        /* Show last data */
        System.out.println(node.data);
    }
}