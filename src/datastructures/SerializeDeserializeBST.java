package datastructures;

import sun.reflect.generics.tree.Tree;
import utils.BinarySearchTree;
import utils.TreeNode;

import java.util.*;

/**
 * Created by sasanka on 1/26/17.
 */

// Given a BST, write a program to serialize it to string and also deserialize it.
public class SerializeDeserializeBST {

    public static void main(String args[]) {

        BinarySearchTree bst = new BinarySearchTree(10);
        SerializeDeserializeBST sd = new SerializeDeserializeBST();

        bst.add(3);
        bst.add(7);
        bst.add(2);
        bst.add(9);
        bst.add(11);
        bst.add(14);

        String serialized = sd.serializeTree(bst.getRoot());
        System.out.println("Serialized tree: " + serialized);

        // Deserializing here
        TreeNode root = sd.deSerializeTree(serialized);
        // Re-serializing here
        String reSerialized = sd.serializeTree(root);
        System.out.println("Serialized tree after deserialization and serialization: " + reSerialized);
    }

    public TreeNode deSerializeTree(String serialized) {
        List<String> deSerialized = Arrays.asList(serialized.split(","));

        return deSerializeTree(deSerialized.listIterator());
    }


    private TreeNode deSerializeTree(ListIterator<String> iterator) {
        TreeNode node = getTreeNode(iterator.next());
        if (node == null) {
            return null;
        }

        node.setLeft(deSerializeTree(iterator));
        node.setRight(deSerializeTree(iterator));

        return node;
    }


    private TreeNode getTreeNode(String value) {

        if (Objects.equals(value, "#")) {
            return null;
        }

        return new TreeNode(Integer.parseInt(value), null, null, null);
    }


    public String serializeTree(TreeNode root) {
        List<String> result = new ArrayList<>();
        preOrderWithStubs(root, result);

        return String.join(",", result);
    }


    private void preOrderWithStubs(TreeNode node, List<String> result) {
        if (node == null) {
            result.add("#");
            return;
        }

        result.add(String.valueOf(node.getValue()));
        preOrderWithStubs(node.getLeft(), result);
        preOrderWithStubs(node.getRight(), result);
    }
}