package edu.umb.cs680.hw01;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;

import org.junit.jupiter.api.Test;

class PrimeGeneratorTest {

	@Test
	public void Is12Even() {
		PrimeGenerator GetPrime= new PrimeGenerator(12,15);
		boolean expected= true;
		boolean actual= GetPrime.isEven(12);
		assertTrue(GetPrime instanceof PrimeGenerator);
		assertEquals(expected, actual);
	}
	@Test
	public void InRange() {
		try{
			PrimeGenerator GetPrime= new PrimeGenerator(15,12);
			
			fail("Wrong input values: from=15 to=12");
		}
		catch(RuntimeException ex){
//			System.out.println(ex.getMessage());
			assertEquals("Wrong input values: from=15 to=12", ex.getMessage());
		}
		
	}
	@Test
	public void PrimeBtw1To30() {
		PrimeGenerator GetPrime= new PrimeGenerator(1,30);
		GetPrime.generatePrimes();
		long[] expected= {2,3,5,7,11,13,17,19,23,29}; 
		LinkedList<Long> actualList = GetPrime.getPrimes();
		Object[] actualObj= actualList.toArray();
		int length = actualObj.length;
	    long[] actual = new long[length];
	    for(int i=0; i<length; i++){
	    	actual[i] = (Long) actualObj[i];
	    }
	        
		assertTrue(GetPrime instanceof PrimeGenerator);
		assertArrayEquals(expected,actual);
	}
	@Test
	public void Is13Prime() {
		PrimeGenerator GetPrime= new PrimeGenerator(1,30);
		GetPrime.isPrime(13);
		boolean expected= true;
		boolean actual= GetPrime.isPrime(13);
		assertTrue(GetPrime instanceof PrimeGenerator);
		assertEquals(expected, actual);
		
	}

}
