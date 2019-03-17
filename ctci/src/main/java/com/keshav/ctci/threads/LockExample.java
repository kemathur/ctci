package com.keshav.ctci.threads;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockExample{

    public class WorkerThread implements Runnable{
        Account account;
        int type;
        int amount;

        public WorkerThread(Account account, int type, int amount) {
            this.account = account;
            this.type = type;
            this.amount = amount;
        }

        public void run() {
            if (type == 0) {
                account.withdraw(amount);
            }
            else if (type == 1){
                account.deposit(amount);
            }
            else {
                System.out.println("Balance is: " + account.getBalance());
            }
        }
    }

    // Thread safe account
    public class Account {
        Lock lock;
        private int balance;
        
        public Account(int b) {
            balance = b;
            lock = new ReentrantLock();
        }

        public void withdraw(int amount) {
            lock.lock();
            int temp = balance;
            try {
                temp = temp - amount;
                Thread.sleep(1000);
                balance = temp;
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.unlock();
        }

        public void deposit(int amount) {
            lock.lock();
            int temp = balance;
            try {
                temp = temp + amount;
                Thread.sleep(3000);
                balance = temp;
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.unlock();
        }

        public int getBalance() {
            lock.lock();
            int temp = balance;
            lock.unlock();
            return temp;
        }

    }

    private void play(){
        Account acc = new Account(50);
        WorkerThread w1 = new WorkerThread(acc, 0, 100);   // withdraw 100
        WorkerThread w2 = new WorkerThread(acc, 1, 60);    // deposit 60
        WorkerThread w3 = new WorkerThread(acc, 2, 0);    // deposit 60
        Thread t1 = new Thread(w1);
        Thread t2 = new Thread(w2);
        Thread t3 = new Thread(w3);
        t1.start();
        t3.start();
        t2.start();

        try {
            t1.join();
            t3.join();
            t2.join();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Balance from outside: "+ acc.getBalance());
    }


    public static void main(String args[]) {
        LockExample e = new LockExample();
        e.play();
    }


}
