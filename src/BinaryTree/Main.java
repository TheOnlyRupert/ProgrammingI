/*
    Robert Higgins
    Professor Gardner
    Programming II
    2018-03-11

    Assignment: Binary Tree
    Create a binary search tree from an array of the following names: Daniel, George, Adam, Peter, Michael, Jones, Tom,
    Allison, James, and Brian. Perform a pre-order, in-order and post-order traversal on the binary tree and print the
    names in the order of the traversal. Remove Peter and Brian from the tree and perform the traversal again.
 */
package BinaryTree;

public class Main {
    public static void main(String[] __args) {
        String[] names = {"Daniel", "George", "Adam", "Peter", "Michael", "Jones", "Tom", "Allison", "James", "Brian"};
        BST<String> bst = new BST<>();

        /* Insert names into tree */
        for (String name : names) {
            bst.insert(name);
        }

        // In-order */
        System.out.println("Inorder (sorted):");
        bst.inorder();

        /* Pre-order */
        System.out.println("\n\nPre-order:");
        bst.preorder();

        /* Post-order */
        System.out.println("\n\nPost-order:");
        bst.postorder();

        /* Delete names */
        System.out.println("\n\nDeleting Peter and Brian from list:");
        bst.delete("Peter");
        bst.delete("Brian");
        bst.inorder();
    }
}

class TreeNode<E> {
    TreeNode<E> left, right;
    E element;

    public TreeNode(E e) {
        element = e;
    }
}

