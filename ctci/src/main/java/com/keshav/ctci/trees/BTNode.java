package com.keshav.ctci.trees;

/*
    Binary Tree node implimentation.
    Node contains left,right, val.
    Interface:
        - insert : just setters and insert funcs. Work on different kind of input.
        - traversals: inorder, preorder, post order.  
*/
public class BTNode {
    private int val;
    private BTNode left;
    private BTNode right;

    public BTNode(int val) {
        this.val = val;
    }
   
    /*
     *  In order traversal
     *  Left Root right. 
     */
    public void inTraverse() {
        if(left != null)
            left.inTraverse();
        System.out.println(val + ",");
        if(right != null)
            right.inTraverse();
    }
    /*
     *  Pre order traversal
     *  Root Left right. 
     */
    public void preTraverse() {
        System.out.println(val + ",");
        if(left != null)
            left.preTraverse();
        if(right != null)
            right.preTraverse();
    }

    /*
     *  Post order traversal
     *  Left right root
     */
    public void postTraverse() {
        if(left != null)
            left.postTraverse();
        if(right != null)
            right.postTraverse();
        System.out.println(val + ",");
    }

    public void insertLeft(int val) {
        if (left == null)
            this.left = new BTNode(val);
    }


    public void insertRight(int val) {
        if (right == null)
            this.right = new BTNode(val);
    }

    public void setLeft(BTNode n) {
        if (left == null)
            left = n;
    }

    public void setRight(BTNode n) {
        if (right == null)
            right = n;
    }

    @Override
    public String toString() {
        return "BTNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

    public static void main(String args[]) {
        BTNode node = new BTNode(3);
        node.insertLeft(5);
        node.insertRight(1);
        System.out.println(node);
    }

}
