package com.keshav.ctci.trees;

/*
    BST implimentation.
    Node contains left,right, val.
    Interface:
        - insert()
        - remove() ?
        - traversals: inorder, preorder, post order.  
*/
public class BSTNode {
    private int val;
    private BSTNode left;
    private BSTNode right;

    public BSTNode(int val) {
        this.val = val;
    }

    public void insert(int v) {
        if (v <= val) {
            if (left == null){
                left = new BSTNode(v);
                return;
            }
            left.insert(v);
        }
        else {
            if (right == null) {
                right = new BSTNode(v);
                return;
            }
            right.insert(v);
        } 
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

    public static void main(String args[]) {
        BSTNode node = new BSTNode(3);
        node.insert(0);
        node.insert(5);
        System.out.println(node);
    }


}
