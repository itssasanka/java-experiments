package utils;

/**
 * Created by sasanka on 1/25/17.
 */
public class TreeNode{
    private int value;
    private TreeNode parent;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(int value, TreeNode parent, TreeNode left, TreeNode right){
        this.value = value;
        this.parent = parent;
        this.left = left;
        this.right = right;
    }


    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public int getValue() {
        return value;
    }

    public TreeNode getParent() {
        return parent;
    }

    public void setParent(TreeNode parent) {
        this.parent = parent;
    }
}
