package edu.umb.cs680.hw05;

public class Escalator {
	private static Escalator escalator;
    private static State state;
    
    private Escalator() {}

    public static Escalator getInstance() {
        if (escalator == null) {
            escalator = new Escalator();
            state = Stopped.getInstance();
        }
        return escalator;
    }
    
    public void changeState(State state) {
        Escalator.state = state;
    }
    
    public State getState() {
        return this.state;
    }
    
    public void startButtonPushed() {
    	state.startButtonPushed();
    }
    
    public void stopButtonPushed() {
    	state.stopButtonPushed();
    }
    
    public void motionDetected() {
    	state.motionDetected();
    }
    public void motionNotDetected() {
    	state.motionNotDetected();
    }
    public void moveSteps() {
        System.out.println("Move Steps");

    }

    public void stopSteps() {
        System.out.println("Stop steps");

    }

    public void enableSensor() {
        System.out.println("Enable Sensor");

    }

    public void disableSensor() {
        System.out.println("Disable Sensor");

    }

}
