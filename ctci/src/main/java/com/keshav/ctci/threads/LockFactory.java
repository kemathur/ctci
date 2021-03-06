package com.keshav.ctci.threads;

import com.keshav.ctci.hash.HashMap;
import com.keshav.ctci.list.ArrayList;
import com.keshav.ctci.list.LinkedList;
import com.keshav.ctci.util.KVPair;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// Factory and other classes to manage locks
public class LockFactory {
    private static LockFactory instance;
    private int maxLocks;
    private LockNode[] locks; // dependency graph of locks
    private HashMap<Integer, LinkedList<LockNode>> lockOrderTable; // thread to lock map

    private LockFactory() { }

    private LockFactory(int n) {
        instance = new LockFactory();
        init(n);
    }

    private void init(int n) {
        maxLocks = n;
        locks = new LockNode[n];
        for (int i=0; i<n; i++) {
            locks[i] = new LockNode(i, maxLocks);
        }
        lockOrderTable = new HashMap<>();
    }

    public static synchronized LockFactory initialize(int count) {
        if (instance == null) instance = new LockFactory(count);
        return instance;
    }

    public static LockFactory getInstance() {
        return instance;
    }

    private boolean hasCycle(HashMap<Integer, Boolean> touchedNodes) {
        for (KVPair<Integer, Boolean> kv : touchedNodes) {
            if (!kv.value()) {
                if(locks[kv.key()].hasCycle(touchedNodes)) {
                    return true;
                }
            }
        }

        return false;
    }

    public synchronized boolean addToLockOrderTable(int id, int[] order) {
        HashMap<Integer, Boolean> touchedNodes = new HashMap<>();
        int n = order.length;
        // add all to touched nodes
        for (int i=0; i<n; i++) {
            touchedNodes.put(order[i], false);
        }

        // add connections
        for (int i=1; i<n; i++) {
            LockNode prev = locks[order[i-1]];
            LockNode curr = locks[order[i]];
            prev.add(curr);
        }

        if (hasCycle(touchedNodes)) {
            // remove connections
            for (int i=1; i<n; i++) {
                LockNode prev = locks[order[i-1]];
                LockNode curr = locks[order[i]];
                prev.remove(curr);
            }
            return false;
        }

        // Now insert into processor map.
        ArrayList<Integer> orderList= new ArrayList<>();
        for (int i=0; i<n; i++) {
            orderList.add(order[i]);
        }

        return true;
    }
}
