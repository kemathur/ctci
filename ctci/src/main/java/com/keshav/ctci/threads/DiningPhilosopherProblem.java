package com.keshav.ctci.threads;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DiningPhilosopherProblem {

    // thread safe chopstick
    public class ChopStick {
        private int name;    // identifier for chopstick
        private int cur;     // current philosopher
        private ReentrantLock lock;

        public ChopStick(int i) {
            cur = -1;
            name = i;
            lock = new ReentrantLock();
        }

        public void pickup(int i) {
            lock.lock();
            cur = i;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Chopstick #" + name  + " picked by Philosopher #: " + cur);
        }

        public void putDown() {
            if (lock.isHeldByCurrentThread()) {
                int temp = cur;
                cur = -1;
                lock.unlock();
                System.out.println("Chopstick #" + name  + " put down by Philosopher #: " + temp);
            }
        }

        public int getCur() {
            return cur;
        }

    }

    public class Philosopher implements Runnable {
        private int name;      // name of philosopher
        private ChopStick left, right;
        private int bites = 10;

        public Philosopher(int name, ChopStick left, ChopStick right) {
            this.name = name;
            this.left = left;
            this.right = right;
        }

        @Override
        public void run() {
            for (int i=0; i<bites; i++) {
                eat(i);
            }
        }

        private void eat(int i) {
            System.out.println("Philosopher #" + name + " eating bite #" + i);
            left.pickup(name);
            right.pickup(name);
            left.putDown();
            right.putDown();
        }
    }

    public void play(int n) {
        // Create chopsticks
        ChopStick[] sticks = new ChopStick[n];
        for (int i=0; i<n; i++) {
            sticks[i] = new ChopStick(i);
        }

        // Create philosophers
        Thread[] threads = new Thread[n];
        Philosopher[] philosophers = new Philosopher[n];
        int k = 0;
        for(int i=0; i<n; i++) {
            philosophers[i] = new Philosopher(i, sticks[i], sticks[Math.floorMod(i - 1, n)]);
            System.out.println("creating philosopher #" + i + "(" + i  + ", " + Math.floorMod(i - 1, n) +")");
            threads[i] = new Thread(philosophers[i]);
        }

        // eat
        for(int i=0; i<n; i++) {
            threads[i].start();
        }
    }

    public static void main(String args[]) {
        DiningPhilosopherProblem p = new DiningPhilosopherProblem();
        System.out.println(-1%5);
        p.play(5);
    }


}
