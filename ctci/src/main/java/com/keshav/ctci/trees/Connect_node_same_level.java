package com.keshav.ctci.trees;

import java.util.LinkedList; 
import java.util.Queue; 
/*
*  Connect nodes at same level using level order
*  traversal.
*  Code from GeeksForGeek : https://www.geeksforgeeks.org/connect-nodes-at-same-level/
*  Better alternative to storing the depth information
* */
public class Connect_node_same_level {
    
    // Node class 
    static class Node { 
        int data; 
        Node left, right, nextRight; 
        Node(int data){ 
            this.data = data; 
            left = null; 
            right = null; 
            nextRight = null; 
        } 
    }; 
    
    // Sets nextRight of all nodes of a tree 
    static void connect(Node root) 
    { 
        Queue<Node> q = new LinkedList<Node>(); 
        q.add(root); 
    
        // null marker to represent end of current level 
        q.add(null); 
    
        // Do Level order of tree using NULL markers 
        while (!q.isEmpty()) { 
            Node p = q.peek(); 
            q.remove(); 
            if (p != null) { 
    
                // next element in queue represents next 
                // node at current Level 
                p.nextRight = q.peek(); 
    
                // push left and right children of current 
                // node 
                if (p.left != null) 
                    q.add(p.left); 
                if (p.right != null) 
                    q.add(p.right); 
            } 
            
            // if queue is not empty, push NULL to mark 
            // nodes at this level are visited 
            else if (!q.isEmpty()) 
                q.add(null); 
        } 
    } 
    
    /* Driver program to test above functions*/
    public static void main(String args[]) 
    { 
    
        /* Constructed binary tree is 
                10 
                / \ 
            8    2 
            /        \ 
        3        90 
        */
        Node root = new Node(10); 
        root.left = new Node(8); 
        root.right = new Node(2); 
        root.left.left = new Node(3); 
        root.right.right = new Node(90); 
    
        // Populates nextRight pointer in all nodes 
        connect(root); 
    
        // Let us check the values of nextRight pointers 
        System.out.println("Following are populated nextRight pointers in \n" + 
    "the tree (-1 is printed if there is no nextRight)"); 
        System.out.println("nextRight of "+ root.data +" is "+ 
        ((root.nextRight != null) ? root.nextRight.data : -1)); 
        System.out.println("nextRight of "+ root.left.data+" is "+ 
        ((root.left.nextRight != null) ? root.left.nextRight.data : -1)); 
        System.out.println("nextRight of "+ root.right.data+" is "+ 
        ((root.right.nextRight != null) ? root.right.nextRight.data : -1)); 
        System.out.println("nextRight of "+ root.left.left.data+" is "+ 
        ((root.left.left.nextRight != null) ? root.left.left.nextRight.data : -1)); 
        System.out.println("nextRight of "+ root.right.right.data+" is "+ 
        ((root.right.right.nextRight != null) ? root.right.right.nextRight.data : -1)); 
    } 
}    


