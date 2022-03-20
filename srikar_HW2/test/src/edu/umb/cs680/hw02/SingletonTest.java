package edu.umb.cs680.hw02;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SingletonTest {

	@Test
	public void instanceReturn() {
		Singleton singleton = Singleton.getInstance("buterin");
		assertNotNull(singleton);
	}
	
	@Test
	public void instanceEqual() {
		Singleton expected= Singleton.getInstance("buterin");
		Singleton actual= Singleton.getInstance("nakamoto");
		System.out.println(expected.hashCode());
		System.out.println(actual.hashCode());
		assertEquals(expected.hashCode(),actual.hashCode());
	}

}

