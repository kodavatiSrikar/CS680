package edu.umb.cs680.hw05;

public class Stopped implements State {

    private static Stopped stopped;
    private Escalator escalator;

    private Stopped() {
    	escalator = Escalator.getInstance();
    }

    public static Stopped getInstance() {
        if (stopped == null)
        	stopped = new Stopped();

        return stopped;
    }

    @Override
    public void startButtonPushed() {
        System.out.print("Escalator StandBy");
        escalator.enableSensor();
        escalator.changeState(StandBy.getInstance());
    }

    @Override
    public void motionDetected() {
        System.out.print("Keep in stop mode sensor not active");
    }

    @Override
    public void stopButtonPushed() {
        System.out.print("Keep the escalator stopped");

    }
    
    @Override
    public void motionNotDetected() {
        System.out.print("Keep in stop mode sensor not active");

    }
    
}