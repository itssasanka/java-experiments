package datastructures;

import utils.BinarySearchTree;

/**
 * Created by sasanka on 1/25/17.
 */
public class BSTImpl {
    public static void main(String args[]) {
        BinarySearchTree bst = new BinarySearchTree(10);

        bst.add(11);
        bst.add(8);
        bst.add(4);
        bst.add(7);
        bst.add(1);
        bst.add(9);

        System.out.println("bst.pre = " + bst.traverseTree("preOrder"));
        System.out.println("bst.post = " + bst.traverseTree("postOrder"));
        System.out.println("bst.in = " + bst.traverseTree("inOrder"));

    }
}
