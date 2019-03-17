package com.keshav.ctci.threads;


/*
*  Example of synchronized method.
*
* */

public class SynchronizedExample {

    public class MyThread extends Thread{
        private String name;
        private MyData data;

        public MyThread(String name, MyData data) {
            this.name = name;
            this.data = data;
        }

        public void run() {
            data.foo(name);
        }
    }

    public class MyData {
        public synchronized void foo(String name) {
            System.out.println("foo started from thread: " + name);
            try{
                Thread.sleep(3000);
            }
            catch(InterruptedException e) {
                System.out.println("thread " + name + " interrupted");
            }
            System.out.println("foo ending from thread: " + name);
        }
    }

    private void play1() {
        System.out.println("same object");
        MyData data = new MyData();
        MyThread t1 = new MyThread("1", data);
        MyThread t2 = new MyThread("2", data);
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void play2() {
        System.out.println("different object");
        MyData data1 = new MyData();
        MyData data2 = new MyData();
        MyThread t1 = new MyThread("1", data1);
        MyThread t2 = new MyThread("2", data2);
        t1.start();
        t2.start();
    }

    public static void main(String args[]) {
        SynchronizedExample eg = new SynchronizedExample();
        eg.play1();
        eg.play2();
    }

}
