package com.keshav.ctci.trees;

import com.keshav.ctci.queue.Queue;

import java.util.ArrayList;
import java.util.List;


public class NodeAL {

    public int getVal() {
        return val;
    }

    private int val;
    private List<NodeAL> children;
    private boolean visited = false;

    public NodeAL(int val) {
        this.val = val;
        children = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "NodeAL{" +
                "val=" + val +
                ", children=" + children +
                '}';
    }

    public void insert(NodeAL n) {
        children.add(n);
    }

    public void visit() {
        if (!visited) {
            System.out.println(val + ", ");
            visited = true;
        }
    }

    public boolean visited() {
        return visited;
    }

    public void markVisited() {
        visited = true;
    }

    public void resetVisited() {
        this.visited = false;
    }


    /*
       * Depth First Search.
       * O(n)
    */
    void DFS() {
        this.visit();
        for (NodeAL n : children) {
            n.DFS();
        }
    }

    /*
      * Breadth first search
      * O(n)
    */
    void BFS() {
        Queue<NodeAL> q = new Queue<>();
        this.visit();
        for (NodeAL n : children) {
            q.insert(n);
        }
        while (!q.isEmpty()) {
            NodeAL node = q.deque();
            node.visit();
            for (NodeAL n : node.getChildren()) {
                if (!n.visited())
                    q.insert(n);
            }
        }
    }

    public List<NodeAL> getChildren() {
        return children;
    }

    public static void main(String args[]) {
        NodeAL node = new NodeAL(5);
        node.insert(new NodeAL(23));
        NodeAL node1 = new NodeAL(50);
        NodeAL node2 = new NodeAL(15);
        node2.insert(new NodeAL(67));
        node2.insert(new NodeAL(46));
        node1.insert(node2);
        node1.insert(new NodeAL(-1));
        node1.insert(new NodeAL(3));
        node1.insert(new NodeAL(10));
        node.insert(node1);

        System.out.println(node);
//        node.DFS();
        node.BFS();
    }
}
