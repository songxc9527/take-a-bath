package com.example.demo.practice;

public class WashThreadC implements Runnable {

    private RobotService robotService;

    public WashThreadC(RobotService robotService) {
        this.robotService = robotService;
    }

    @Override
    public void run() {
        robotService.awaitChuanyi();
    }

}
