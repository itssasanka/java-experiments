package utils;

import sun.reflect.generics.tree.Tree;
import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sasanka on 1/25/17.
 */
public class BinarySearchTree {

    private TreeNode root;

    public BinarySearchTree(int value){
        this.root = new TreeNode(value, null, null, null);
    }

    public TreeNode getRoot() {
        return this.root;
    }


    public void add(int newValue){
        recursiveAddNode(newValue, this.root);
    }

    private void recursiveAddNode(int newValue, TreeNode targetNode) {

        if(newValue <= targetNode.getValue()){
            if(targetNode.getLeft() == null){
                TreeNode newNode = new TreeNode(newValue, targetNode, null, null);
                targetNode.setLeft(newNode);
                return;
            }
            recursiveAddNode(newValue, targetNode.getLeft());
        } else if (newValue > targetNode.getValue()) {
            if(targetNode.getRight() == null){
                TreeNode newNode = new TreeNode(newValue, targetNode, null, null);
                targetNode.setRight(newNode);
                return;
            }
            recursiveAddNode(newValue, targetNode.getRight());
        }
    }


    public List<String> traverseTree(String mode){
        List<String> result = new ArrayList<>();

        switch(mode){
            case "inOrder":
                this.inOrderTree(this.root, result);
                break;
            case "preOrder":
                this.preOrderTree(this.root, result);
                break;
            case "postOrder":
                this.postOrderTree(this.root, result);
                break;
            default:
                throw new IllegalArgumentException("Unknown mode");
        }

        return result;
    }

    private void preOrderTree(TreeNode n, List<String> result){
        if(n == null){
            return;
        }

        result.add(String.valueOf(n.getValue()));
        preOrderTree(n.getLeft(), result);
        preOrderTree(n.getRight(), result);
    }

    private void postOrderTree(TreeNode n, List<String> result){
        if(n == null){
            return;
        }

        postOrderTree(n.getLeft(), result);
        postOrderTree(n.getRight(), result);
        result.add(String.valueOf(n.getValue()));
    }

    private void inOrderTree(TreeNode n, List<String> result){
        if(n == null){
            return;
        }

        inOrderTree(n.getLeft(), result);
        result.add(String.valueOf(n.getValue()));
        inOrderTree(n.getRight(), result);
    }
}
