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
    private BSTNode parent;          // Coz of question 6

    public BSTNode(int val) {
        this.val = val;
    }

    public BSTNode(int val, BSTNode parent) {
        this.val = val;
        this.parent = parent;
    }

    public void insert(int v) {
        if (v <= val) {
            if (left == null){
                left = new BSTNode(v, this);
                return;
            }
            left.insert(v);
        }
        else {
            if (right == null) {
                right = new BSTNode(v, this);
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


    public BSTNode leftMostChild() {
        if (this.getLeft() == null) {
            return this;
        }

        return this.getLeft().leftMostChild();
    }

    /*
      * Chapter 04 Q6
      * In order successor of a node.
    */
    public BSTNode inOrderSuccessor() {
        BSTNode root = this;
        if (root == null) return null;

        if (root.getRight() != null) {
            return root.getRight().leftMostChild();
        }
        
        /*
          * Given no right we have two cases:
          * 1) On the left. So can return root.
          * 2) On the right. Need to find next unexplored root.
        */
        if (root.getParent().getLeft() == root) {
            return root.getParent();
        }
        // Search for root that is unexplored.
        BSTNode x = root.getParent();
        BSTNode q = x.getParent();

        while (x!= null && q.getLeft() != x) {
            x = q;
            q = x.getParent();
        }
        return q;
    }

    public BSTNode getLeft() {
        return this.left;
    }

    public BSTNode getRight() {
        return this.right;
    }

    public BSTNode getParent() {
        return parent;
    }

    @Override
    public String toString() {
        return "BSTNode{" +
                "val=" + val +
                '}';
    }

    public static void main(String args[]) {
        BSTNode node = new BSTNode(3);
        node.insert(0);
        node.insert(10);
        node.insert(6);
        node.insert(15);
        System.out.println(node);
        node.inTraverse();
        System.out.println(node.inOrderSuccessor());
    }
}
