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

    /*Chapter 04 Q3*/
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


    /* Chapter 04 Q4  
       * Usage: node.banaced()
    */
    public boolean balanced() {
        return isBalanced(this);
    }

    private static boolean isBalanced(BTNode root) {
        if (root == null) return true;

        if(isBalanced(root.getLeft()) && isBalanced(root.getRight())) {
            if(Math.abs(height(root.getLeft()) - height(root.getRight())) <= 1) {
                return true;
            }
        }
        return false;
    }

    private static int height(BTNode root) {
        if (root == null) return 0;

        return Math.max(height(root.getLeft()), height(root.getRight())) + 1;
    }

    /*
      * Chapter 04 Q5
    */
    public boolean isBST() {
        return checkBST(this, null, null);
    }

    private static boolean checkBST(BTNode root, Integer min, Integer max) {
        if (root ==null) return true;

        if (min!=null && root.getVal() <= min) {
            return false;
        }

        if (max!=null && root.getVal() > max) {
            return false;
        }
        // Branch left
        return checkBST(root.getLeft(), min, root.getVal()) &&
        checkBST(root.getRight(), root.getVal(), max);
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
        BTNode node = new BTNode(30);
//        node.insertLeft(5);
        node.insertRight(111);
        BTNode leftSubTree = new BTNode(23);
        leftSubTree.insertLeft(12);
        leftSubTree.insertRight(27);
        node.setLeft(leftSubTree);
//        System.out.println(tr);
        System.out.println(node);
        System.out.println(node.getDepthLists());
        System.out.println(node.balanced());
        System.out.println(node.isBST());
    }

}
