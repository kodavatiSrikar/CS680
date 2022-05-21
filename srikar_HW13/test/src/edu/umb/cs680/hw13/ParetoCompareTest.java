package edu.umb.cs680.hw13;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw13.Car;

public class ParetoCompareTest {
	private static Car car_1;
	private static Car car_2;
	private static Car car_3;
	private static LinkedList<Car> usedCars;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		usedCars = new LinkedList<>();
		car_1 = new Car("Toyota", "RAV4", 70000, 2011, 7000.0f);
		car_2 = new Car("Honda", "CRV", 80000, 2010, 8000.0f);
		car_3 = new Car("Honda", "WRV", 75000, 2012, 6000.0f);
		usedCars.add(car_1);
		usedCars.add(car_2);
		usedCars.add(car_3);
	}
	
	@Test
	public void dominationCountCar1() {
		int expected = 1;
		car_1.setDominationCount(usedCars);
		int actual = car_1.getDominationCount();
		assertEquals(expected, actual);
	}
	
	@Test
	public void dominationCountCar2() {
		int expected = 2;
		car_2.setDominationCount(usedCars);
		int actual = car_2.getDominationCount();
		assertEquals(expected, actual);
	}
	
	@Test
	public void dominationCountCar3() {
		int expected = 0;
		car_3.setDominationCount(usedCars);
		int actual = car_3.getDominationCount();
		assertEquals(expected, actual);
	}

	@Test
	public void dominationCountAscendingSort() {
		LinkedList<Car> expected = new LinkedList<>();
		expected.add(car_3);
		expected.add(car_1);
		expected.add(car_2);
		car_1.setDominationCount(usedCars);
		car_2.setDominationCount(usedCars);
		car_3.setDominationCount(usedCars);
		Collections.sort(usedCars, Comparator.comparing(car -> car.getDominationCount()));
		Assert.assertArrayEquals(expected.toArray(), usedCars.toArray());
	}

}
