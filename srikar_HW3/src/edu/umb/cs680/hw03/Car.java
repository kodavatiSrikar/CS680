package edu.umb.cs680.hw03;

public class Car {
	private String make, model;
    private int mileage, year;
    private float price;

    // Constructor
    public Car(String make, String model , int mileage, int year, float price) {
        this.make=make;
        this.model=model;
        this.year=year;
        this.mileage=mileage;
        this.price=price;

    }
    public String getCarMake() {
        return this.make;
    }

    public String getCarModel() {
        return  this.model;
    }

    public int getCarMileage() {
        return this.mileage;
    }

    public int getCarYear() {
        return this.year;
    }

    public float getCarPrice() {
        return this.price;
    }

    public static void main(String[] args) {
        Car car = new Car("Tata", "nano", 24, 2014, 9 );
        System.out.println(car.getCarMileage());
        System.out.println(car.getCarYear());
    }


}
