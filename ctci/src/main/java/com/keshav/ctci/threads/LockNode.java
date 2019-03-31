package com.keshav.ctci.threads;

import com.keshav.ctci.hash.HashMap;
import com.keshav.ctci.list.ArrayList;
import com.keshav.ctci.list.LinkedList;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockNode {
    public enum VisitedState {
        FRESH,
        VISITING,
        VISITED
    };

    private int id;
    private Lock lock;
    private int maxLocks;
    private LinkedList<LockNode> children;

    public LockNode(int i, int max) {
        id = i;
        lock = new ReentrantLock();
        children = new LinkedList<LockNode>();
        maxLocks = max;
    }

    public int getId() {
        return id;
    }

    public Lock getLock() {
        return lock;
    }

    public void add(LockNode c) {
        children.add(c);
    }

    public boolean hasCycle(HashMap<Integer, Boolean> touchedNodes) {
        VisitedState[] visited = new VisitedState[maxLocks];
        for (int i=0; i<maxLocks; i++) {
            visited[i] = VisitedState.FRESH;
        }
        return hasCycle(visited, touchedNodes);
    }

    public boolean hasCycle(VisitedState visited[], HashMap<Integer, Boolean> touchedNodes) {
        if (visited[id] == VisitedState.FRESH) {
            visited[id] = VisitedState.VISITING;
        }
        else {
            return true;
        }
        touchedNodes.put(id, true);
        for (int i=0; i<children.size(); i++) {
            LockNode child = children.get(i);
            boolean ret = child.hasCycle(visited, touchedNodes);
            if (ret) return true;
        }
        visited[id] = VisitedState.VISITED;
        return false;
    }

    public void remove(LockNode c) {
        children.remove(c);
    }
}