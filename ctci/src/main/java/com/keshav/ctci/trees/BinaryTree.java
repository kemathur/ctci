package com.keshav.ctci.trees;

/*
    Binary Tree implimentation.
    Node contains left,right, val.
    Interface:
        - insert : Need to explicitly call insert left and right of root. So this is prob not needed?
        - traversals: inorder, preorder, post order.
*/
public class BinaryTree {
    private BTNode root;

    public BinaryTree(int val) {
        root = new BTNode(val);
    }

    public void insertLeft(int val) {
        root.insertLeft(val);
    }


    public void insertRight(int val) {
        root.insertRight(val);
    }

    public void setLeft(BTNode n) {
        root.setLeft(n);
    }

    public void setRight(BTNode n) {
        root.setRight(n);
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

    @Override
    public String toString() {
        return "BinaryTree{" +
                "root=" + root +
                '}';
    }

    public static void main(String args[]) {
        BinaryTree tr = new BinaryTree(10);
        tr.insertRight(13);
        BTNode leftSubTree = new BTNode(4);
        leftSubTree.insertLeft(12);
        leftSubTree.insertRight(-100);
        tr.setLeft(leftSubTree);
        System.out.println(tr);
//        tr.preTraverse();
//        tr.inTraverse();
//        tr.postTraverse();
    }


}
