package edu.umb.cs680.hw03;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class CarTest {

    private String[] carToStringArray(Car car) {
        String[] carInfo =  {
                car.getCarMake(), car.getCarModel(), Integer.toString(car.getCarYear())
        };
        return carInfo;
    }

    @Test
    public void verifyCarEqualityWithMakeModelYear()
    {
        String[] expected = {"Tesla","Model s","2021"};
        Car actual= new Car("Tesla","Model s",405,2021,94990);
        assertArrayEquals(expected,carToStringArray(actual));
    }

    @Test
    public void verifyCarNotEqualityWithMakeModelYear()
    {
        String[] expected = {"Tesla","Model s","2021"};
        Car actual= new Car("Tesla","Model s",405,2022,94990);
        
        assertFalse(Arrays.equals(expected,carToStringArray(actual)));
    }

}