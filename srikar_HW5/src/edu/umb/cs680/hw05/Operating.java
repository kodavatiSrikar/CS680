package edu.umb.cs680.hw05;

public class Operating implements State {

    private static Operating operating;
    private Escalator escalator;

    private Operating() {
        escalator = Escalator.getInstance();
    }

    public static Operating getInstance() {
        if (operating == null)
        	operating = new Operating();

        return operating;
    }

    @Override
    public void startButtonPushed() {
        System.out.print("Keep moving steps");
        
    }

    

    @Override
    public void stopButtonPushed() {
        System.out.print("Escalator stopped");
        escalator.stopSteps();
        escalator.disableSensor();
        escalator.changeState(Stopped.getInstance());

    }
    
    @Override
    public void motionDetected() {
    	System.out.print("Keep moving steps");
    }

    @Override
    public void motionNotDetected() {
        System.out.print("Escalator standby");
        escalator.stopSteps();
        escalator.changeState(StandBy.getInstance());
        

    }
    
}