package com.mycompany.csc229_bst_example;
/**
 *
 * @author MoaathAlrajab
 */
import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
    public BstNode root;

    public boolean isEmpty() {
        return (this.root == null);
    }

    public void insert(Integer data) {

        System.out.print("[input: " + data + "]");
        if (root == null) {
            this.root = new BstNode(data);
            System.out.println(" -> inserted: " + data);
            return;
        }
        insertNode(this.root, data);
        System.out.print(" -> inserted: " + data);
        System.out.println();
    }

    private BstNode insertNode(BstNode root, Integer data) {

        BstNode tmpNode = null;
        System.out.print(" ->" + root.getData());
        if (root.getData() >= data) {
            System.out.print(" [L]");
            if (root.getLeft() == null) {
                root.setLeft(new BstNode(data));
                return root.getLeft();
            } else {
                tmpNode = root.getLeft();
            }
        } else {
            System.out.print(" [R]");
            if (root.getRight() == null) {
                root.setRight(new BstNode(data));
                return root.getRight();
            } else {
                tmpNode = root.getRight();
            }
        }
        return insertNode(tmpNode, data);
    }

    // ToDo 1: complete InOrder Traversal
    public void inOrderTraversal() {
        System.out.print("inOrder Traversal: ");
        doInOrder(this.root);
        System.out.println();
    }

    private void doInOrder(BstNode root) {
        if(root == null) return;
        doInOrder((root.getLeft()));
        System.out.print(root.getData() + " ");
        doInOrder(root.getRight());
    }

    // ToDo 2: complete the pre-order travesal .
    public void preOrderTraversal() {
        doPreOrder(this.root);

    }

    // ToDo 3: Find the height of a tree
    public Integer findHeight() {


    }


    //ToDo 4: complete getDepth of a node
    public int getDepth(BstNode node) {

    }
    
   public void print() {
       System.out.println("\n==== BST Print ===== \n");
        print("", root, false);
    }

    // ToDo 5: complete the print of the BST
    private void print(String prefix, BstNode node, boolean isLeft){
        if(node == null) return;
        print(prefix + (isLeft ? "|   " : "    "), node.getRight(), false);
        System.out.print(prefix + (isLeft ? "\\--":"/--"));
        System.out.println(node.getData());
        print(prefix + (isLeft ? "|   " : "    "), node.getLeft(), true);

    }
}
