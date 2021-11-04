import org.junit.Test;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class CarUnitTest {

    private final String carDescription = "this car is cool";
    private final double price = 26900.00;
    private final double averageRating = 4.3;

    Car car = new Car(carDescription, price, averageRating);

    @Test
    public void testGetDescription () {
        assertEquals(car.getCarDescription(), carDescription, "carDescriptions should be deep equal");
    }

    @Test
    public void testGetPrice () {
        assertEquals(car.getPrice(), price, "price should be equal");
    }

    @Test
    public void testGetAverageRating () {
        assertEquals(car.getAverageRating(), averageRating, "averageRatings should be equal");
    }
}