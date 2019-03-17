package com.keshav.ctci.threads;


public class RunnableExample implements Runnable{

    private int count = 0;

    public void run() {
        System.out.println("thread starting");
        try{
            while(count < 5) {
                Thread.sleep(500);
                count++;
            }
        } catch (InterruptedException e) {
            System.out.println("thread interrupted");
        }
        System.out.println("thread terminating");
    }

    public int getCount() {
        return count;
    }


    public static void main(String args[]) {
        RunnableExample re = new RunnableExample();
        Thread t = new Thread(re);
        t.start();

        while(re.getCount() != 5) {
            try {
                Thread.sleep(250);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
