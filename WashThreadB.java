package com.example.demo.practice;

public class WashThreadB implements Runnable {

    private RobotService robotService;

    public WashThreadB(RobotService robotService) {
        this.robotService = robotService;
    }

    @Override
    public void run() {
        robotService.awaitMuyulu();
    }

}
