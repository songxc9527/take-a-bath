package com.example.demo.practice;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReenTrantLockTest {

    public static void main(String[] args) throws InterruptedException {

        RobotService robotService = new RobotService();

        System.out.println("老板：我想洗澡，去准备一下。");

        WashThreadA washThreadA = new WashThreadA(robotService);
        Thread czReady = new Thread(washThreadA);
        czReady.setName("czReady");
        czReady.start();

        Thread.sleep(500);

        WashThreadB washThreadB = new WashThreadB(robotService);
        Thread myReady = new Thread(washThreadB);
        myReady.setName("myReady");
        myReady.start();

        Thread.sleep(500);

        WashThreadC washThreadC = new WashThreadC(robotService);
        Thread gyReady = new Thread(washThreadC);
        gyReady.setName("gyReady");
        gyReady.start();

        Thread.sleep(2000);

        robotService.signalWash();

    }
}
