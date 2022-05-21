package edu.umb.cs680.hw11;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.Assert;

import org.junit.jupiter.api.Test;
import java.util.Collections;
import java.util.LinkedList;
import edu.umb.cs680.hw11.Car;
import edu.umb.cs680.hw11.ParetoComparator;
import org.junit.jupiter.api.BeforeAll;
public class ParetoComparatorTest {
	private static Car car_1;
	private static Car car_2;
	private static Car car_3;
	private static LinkedList<Car> usedCars;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		usedCars = new LinkedList<>();
		car_1 = new Car("Toyota", "RAV4", 70000, 2011, 7000.0f);
		car_2 = new Car("Honda", "CRV", 80000, 2010, 8000.0f);
		car_3 = new Car("Honda", "WRV", 60000, 2012, 6000.0f);
		usedCars.add(car_1);
		usedCars.add(car_2);
		usedCars.add(car_3);
	}
	
	@Test
	public void dominationCountcar_1() {
		int expected = 1;
		car_1.setDominationCount(usedCars);
		int actual = car_1.getDominationCount();
		assertEquals(expected, actual);
	}
	
	@Test
	public void dominationCountcar_2() {
		int expected = 2;
		car_2.setDominationCount(usedCars);
		int actual = car_2.getDominationCount();
		assertEquals(expected, actual);
	}
	
	@Test
	public void dominationCountcar_3() {
		int expected = 0;
		car_3.setDominationCount(usedCars);
		int actual = car_3.getDominationCount();
		assertEquals(expected, actual);
	}

	@Test
	public void dominationCountAscendingSortTest() {
		LinkedList<Car> expected = new LinkedList<>();
		expected.add(car_3);
		expected.add(car_1);
		expected.add(car_2);
		car_1.setDominationCount(usedCars);
		car_2.setDominationCount(usedCars);
		car_3.setDominationCount(usedCars);
		Collections.sort(usedCars, new ParetoComparator());
		Assert.assertArrayEquals(expected.toArray(), usedCars.toArray());
	}

}