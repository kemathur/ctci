package com.keshav.ctci.trees;

import com.keshav.ctci.queue.Queue;

import java.util.ArrayList;
import java.util.List;


public class GraphAL {

    public List<NodeAL> nodes;

    public GraphAL() {
        nodes = new ArrayList<>();
    }

    public void init(NodeAL node) {
        if (node.visited())
            return;
        nodes.add(node);
        node.markVisited();
        for (NodeAL n :  node.getChildren()) {
            init(n);
        }
    }

    public void insert(NodeAL n) {
        nodes.add(n);
    }

    /*
    *  Search if path exists.
    * */
    public boolean search(NodeAL start, NodeAL end) {
        if (start == end) return true;
        
        resetVisited();
        // Need to do BFS and stop at found node. Keep updating visited.
        Queue<NodeAL> q = new Queue();
        q.insert(start);
        
        while (!q.isEmpty()) {
            NodeAL node = q.deque();
            if (!node.visited()) {
                if (node == end)
                    return true;
                node.markVisited();
                for (NodeAL n : node.getChildren()) {
                    q.insert(n);
                }
            }
        }
        return false;
    }

    public void resetVisited() {
        for (NodeAL n : nodes) {
            n.resetVisited();
        }
    }

    public String printNodes() {
        String ret = "[";
        for (NodeAL n : nodes) {
            ret += n.getVal() + ", ";
        }
        ret += "]";
        return ret;
    }

    @Override
    public String toString() {
        return "GraphAL{" +
                "nodes=" + printNodes() +
                '}';
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
        NodeAL end = new NodeAL(42);
        System.out.println(node);

        GraphAL g = new GraphAL();      
        g.init(node);
        g.insert(end);
        System.out.println(g);
        System.out.println(g.search(node, node2));
    }
    
}
