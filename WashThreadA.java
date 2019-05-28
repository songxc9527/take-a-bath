package com.example.demo.practice;

public class WashThreadA implements Runnable {

    private RobotService robotService;

    public WashThreadA(RobotService robotService) {
        this.robotService = robotService;
    }

    @Override
    public void run() {
        robotService.awaitCuoZao();
    }

}
