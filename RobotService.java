package com.example.demo.practice;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class RobotService {

    private Lock lock = new ReentrantLock(true);
    public Condition washCondition = lock.newCondition();

    public void awaitCuoZao() {
        lock.lock();
        System.out.println("等着给老板搓澡...");
        System.out.println("开始等待时间：" + System.currentTimeMillis() + " -- 当前线程：" + Thread.currentThread().getName());
        try {
            washCondition.await();
            System.out.println("结束等待时间：" + System.currentTimeMillis() + " -- 当前线程：" + Thread.currentThread().getName());
            Thread.sleep(3000);
            System.out.println("搓澡完毕！");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void awaitMuyulu() {
        lock.lock();
        System.out.println("等着给老板打沐浴露...");
        System.out.println("开始等待时间：" + System.currentTimeMillis() + " -- 当前线程：" + Thread.currentThread().getName());
        try {
            washCondition.await();
            System.out.println("结束等待时间：" + System.currentTimeMillis() + " -- 当前线程：" + Thread.currentThread().getName());
            Thread.sleep(3000);
            System.out.println("打沐浴露完毕！");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void awaitChuanyi() {
        lock.lock();
        System.out.println("等着给老板更衣...");
        System.out.println("开始等待时间：" + System.currentTimeMillis() + " -- 当前线程：" + Thread.currentThread().getName());
        try {
            washCondition.await();
            System.out.println("结束等待时间：" + System.currentTimeMillis() + " -- 当前线程：" + Thread.currentThread().getName());
            Thread.sleep(3000);
            System.out.println("更衣完毕！");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void signalWash() {
        lock.lock();
        System.out.println("老板：给我洗澡");
        System.out.println("通知时间：" + System.currentTimeMillis() + " -- 当前线程：" + Thread.currentThread().getName());
        try {
            washCondition.signalAll();
        } finally {
            lock.unlock();
        }
    }

}
