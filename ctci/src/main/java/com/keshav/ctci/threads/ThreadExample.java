package com.keshav.ctci.threads;


public class ThreadExample {

    public class ThreadE extends Thread {
        private int count = 0;
        
        public void run() {
            System.out.println("thread starting");
            try{
                while (count < 5) {
                    Thread.sleep(500);
                    count++;
                }
            }
            catch(InterruptedException e) {
                System.out.println("thread interrupted");
            }
            System.out.println("thread terminating");
        }
    
        public int getCount() {
            return count;
        }
    }


    public void play() {
        ThreadE t = new ThreadE();
        t.start();

        try {
            while (t.getCount() != 5) {
                Thread.sleep(250);
            }
        }
        catch(InterruptedException e) {
            System.out.println("thread interrupted");
        }
    }


    public static void main(String args[]) {
        ThreadExample e = new ThreadExample();
        e.play();
    }
}
