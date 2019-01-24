package com.keshav.ctci.trees;

/*
    BST implimentation.
    Node contains left,right, val.
    Interface:
        - insert()
        - remove() ??? Not for now
        - traversals: inorder, preorder, post order.  
*/
public class BST {    
    private BSTNode root;

    public BST() {
    }

    public void insert(int val) {
        if (root ==null) {
            root = new BSTNode(val);
            return;
        }
        root.insert(val);
    }

    public void preTraverse() {
        if(root == null){
            System.out.println("::Empty tree::");
        }
        root.preTraverse();
    }
    
    public void inTraverse() {
        if(root == null){
            System.out.println("::Empty tree::");
        }
        root.inTraverse();
    }
    
    public void postTraverse() {
        if(root == null){
            System.out.println("::Empty tree::");
        }
        root.postTraverse();
    }


    public static void main(String args[]) {
        BST tr = new BST();
        tr.insert(10);                    // 10 becomes root
        tr.insert(4);
        tr.insert(13);
        tr.insert(-100);
        tr.insert(12);
        tr.preTraverse();
        tr.inTraverse();
        tr.postTraverse();
    }


}
