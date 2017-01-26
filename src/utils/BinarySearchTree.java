package trees;

import sun.reflect.generics.tree.Tree;
import utils.TreeNode;

/**
 * Created by sasanka on 1/25/17.
 */
public class BinarySearchTree {

    private TreeNode root;

    public BinarySearchTree(int value){
        this.root = new TreeNode(value, null, null, null);
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
            recursiveAddNode(newValue, targetNode);
        }
    }


    private String preOrderTree(TreeNode n, String result){
        if(n == null){
            return "";
        }

        result = result + " " + n.toString();
        preOrderTree(n.getLeft(), result);
        preOrderTree(n.getRight(), result);

        return result;
    }
}
