package edu.umb.cs680.hw05;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EscalatorTest {
	
	Escalator escalator= Escalator.getInstance();

	@Test
    public void stopButtonStanByTest(){
		escalator.changeState(StandBy.getInstance());
        escalator.stopButtonPushed();
        State actual = escalator.getState();
        State expected = Stopped.getInstance();
        assertSame(expected,actual);
	}
	
    @Test
    public void stopButtonOperatingTest(){
    escalator.changeState(Operating.getInstance());
    escalator.stopButtonPushed();
    State actual1 = escalator.getState();
    State expected1 = Stopped.getInstance();
    assertSame(expected1,actual1);
     
    
    
}
    
    @Test
    public void startButtonStanByTest(){
		escalator.changeState(StandBy.getInstance());
        escalator.startButtonPushed();
        State actual = escalator.getState();
        State expected = Operating.getInstance();
        assertSame(expected,actual);
	}
	
	@Test
	public void ChangeStateTest() {
		escalator.changeState(StandBy.getInstance());
		State actual= escalator.getState();
		State expected = StandBy.getInstance();
		assertSame(expected,actual);
	}
	@Test
	public void startButtonStoppedTest() {
		escalator.changeState(Stopped.getInstance());
		escalator.startButtonPushed();
		State actual= escalator.getState();
		State expected = StandBy.getInstance();
		assertSame(expected,actual);
		
	}
	
	@Test
    public void motionDetectedStanByTest(){
		escalator.changeState(StandBy.getInstance());
        escalator.motionDetected();
        State actual = escalator.getState();
        State expected = Operating.getInstance();
        assertSame(expected,actual);
	}
	
	@Test
    public void motionNotDetectedOperatingTest(){
		escalator.changeState(Operating.getInstance());
        escalator.motionNotDetected();
        State actual = escalator.getState();
        State expected = StandBy.getInstance();
        assertSame(expected,actual);
	}

}
