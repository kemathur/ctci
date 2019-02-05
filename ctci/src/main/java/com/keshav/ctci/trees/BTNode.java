package com.keshav.ctci.trees;

import java.util.ArrayList;
import java.util.List;

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

    public List<List<BTNode>> getDepthLists() {
        List<List<BTNode>> lists = new ArrayList<>();
        return getLists(lists);
    }


    private List<List<BTNode>> getLists(List<List<BTNode>> lists) {
        List<BTNode> list = new ArrayList();
        if (lists.size() == 0) {
            list.add(this);
            lists.add(list);
            return getLists(lists);
        }
        int depth = lists.size();
        List<BTNode> last = lists.get(depth - 1);
        for (BTNode node : last) {
            if (node.getLeft() != null)
                list.add(node.getLeft());
            if (node.getRight() != null)
                list.add(node.getRight());
        }
        if (list.size() == 0)
            return lists;
        lists.add(list);
        return getLists(lists);
    }

    public int getVal() {
        return val;
    }

    public BTNode getLeft() {
        return left;
    }

    public BTNode getRight() {
        return right;
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
//        node.insertLeft(5);
        node.insertRight(1);
        BTNode leftSubTree = new BTNode(4);
        leftSubTree.insertLeft(12);
        leftSubTree.insertRight(-100);
        node.setLeft(leftSubTree);
//        System.out.println(tr);
        System.out.println(node);
        System.out.println(node.getDepthLists());
    }

}
