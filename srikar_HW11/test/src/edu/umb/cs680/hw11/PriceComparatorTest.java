package edu.umb.cs680.hw11;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.LinkedList;

import org.junit.Assert;


import edu.umb.cs680.hw11.Car;
import edu.umb.cs680.hw11.PriceComparator;

public class PriceComparatorTest {

	@Test
	public void priceAscendingSortTest() {
		LinkedList<Car> usedCars = new LinkedList<>();
		Car car_1 = new Car("Toyota", "RAV4", 70000, 2011, 7000.0f);
		Car car_2 = new Car("Honda", "CRV", 80000, 2010, 8000.0f);
		Car car_3 = new Car("Subaru", "FORESTER", 60000, 2012, 6000.0f);
		usedCars.add(car_1);
		usedCars.add(car_2);
		usedCars.add(car_3);
		LinkedList<Car> expected = new LinkedList<>();
		expected.add(car_3);
		expected.add(car_1);
		expected.add(car_2);
		Collections.sort(usedCars, new PriceComparator());
		Assert.assertArrayEquals(expected.toArray(), usedCars.toArray());
	}
}