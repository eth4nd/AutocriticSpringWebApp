package Model.Car;


import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class CarUnitTest {

    private final String carName = "this car is cool";
    private final double price = 26900.00;

    Car car = new Car(carName, price);

    @Test
    public void testGetDescription () {
        assertEquals(car.getCarName(), carName, "carDescriptions should be deep equal");
    }

    @Test
    public void testGetPrice () {
        assertEquals(car.getPrice(), price, "price should be equal");
    }

    @Test
    public void testGetAverageRating () {
        //assertEquals(car.getAverageRating(), averageRating, "averageRatings should be equal");
    }
}