package edu.umb.cs680.hw05;

public class StandBy implements State {

    private static StandBy standby;
    private Escalator escalator;

    private StandBy() {
        escalator = Escalator.getInstance();
    }

    public static StandBy getInstance() {
        if (standby == null)
        	standby = new StandBy();

        return standby;
    }

    @Override
    public void startButtonPushed() {
        System.out.print("Escalator Starting");
        escalator.moveSteps();
        escalator.changeState(Operating.getInstance());
    }

    @Override
    public void motionDetected() {
    	System.out.print("Escalator Starting");
        escalator.moveSteps();
        escalator.changeState(Operating.getInstance());
    }

    @Override
    public void stopButtonPushed() {
        System.out.print("Escalator stopped");
        escalator.disableSensor();
        escalator.changeState(Stopped.getInstance());

    }
    
    @Override
    public void motionNotDetected() {
        System.out.print("Keeps standing by");

    }
    
}