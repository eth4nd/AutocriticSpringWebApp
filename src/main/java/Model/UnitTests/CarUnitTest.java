package Model.UnitTests;


import Model.Car.Car;
import Model.Car.CarDatabase;
import Model.Database.BucketManager;
import Model.Review.Review;
import Model.Review.ReviewDatabase;
import Model.Review.ReviewSystem;
import Model.User.User;
import Model.User.UserDatabase;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CarUnitTest {

    Car testCar = new Car("2020 Honda Civic", 0, 0, 0);
    Car testCar2 = new Car("2012 Rolls Royce Phantom", 5, 1, 5);

    @Test
    public void testCarClass() {
        String carNames[] = {"2020 Honda Civic", "2012 Rolls Royce Phantom"};
        //Check if paramaters are correct for test car 1
        assertEquals("carname should be " + carNames[0], testCar.getCarName(), carNames[0]);
        assertEquals(0.0, testCar.getAvgRating(), 0.0);
        assertEquals(0.0, testCar.getNumOfRatings(),0.0);
        assertEquals(0.0,testCar.getTotalRating(),0.0);
        //Check if parameters are correct for test car 2
        assertEquals("carname should be " + carNames[1],testCar2.getCarName(),carNames[1]);
        assertEquals(5.0,testCar2.getAvgRating(),0.0);
        assertEquals(1.0,testCar2.getNumOfRatings(),0.0);
        assertEquals(5.0,testCar2.getTotalRating(),0.0);

        //Add ratings to test car 1
        testCar.addRating(5);
        testCar.addRating(4);
        testCar.addRating(3);
        testCar.addRating(2);
        testCar.addRating(1);
        assertEquals(3.0,testCar.getAvgRating(),0.1);
        assertEquals(5,testCar.getNumOfRatings(),0);
        assertEquals(15,testCar.getTotalRating(),0);

        //add ratings to test car 2
        testCar2.addRating(1);
        testCar2.addRating(1);
        testCar2.addRating(1);
        testCar2.addRating(1);
        assertEquals(1.8,testCar2.getAvgRating(),0.1);
        assertEquals(5,testCar2.getNumOfRatings(),0);
        assertEquals(9,testCar2.getTotalRating(),0);
    }
    @Test
    public void testCarDatabaseDownloadCars(){
        BucketManager b = new BucketManager();
        CarDatabase carDatabase = new CarDatabase();
        List<Car> listOfDownloadedCars = carDatabase.downloadCar("placeholder",b.getS3Database(),3);
        assertTrue(listOfDownloadedCars.size()<=3);
    }

}