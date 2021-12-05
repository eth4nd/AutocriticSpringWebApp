package Model.Car;


import Model.Review.Review;
import Model.Review.ReviewSystem;
import Model.User.User;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class CarUnitTest {

//
//    Car hondaCivic2021 = new Car(2021, "Honda", "Civic", 21250);
//    Car teslaModelS2021 = new Car(2021, "Tesla", "Model-S", 69420.00);
//
//
//    @Test
//    public void testGetYear () {
//        assertEquals(2021, hondaCivic2021.getYear(), "Year should return 2021");
//        assertEquals(2021, teslaModelS2021.getYear(), "Year should return 2021");
//    }
//
//    @Test
//    public void testGetMake(){
//        assertEquals("Honda", hondaCivic2021.getMake(),"Should return 'Honda'");
//        assertEquals("Tesla",teslaModelS2021.getMake(),"Should return 'Tesla'");
//        assertFalse(hondaCivic2021.getModel().equals(teslaModelS2021.getModel()));
//    }
//
//    @Test
//    public void testGetMSRP () {
//        assertEquals(21250, hondaCivic2021.getMSRP(), "MSRP should return 21250.00 \n " +
//                "Actual return value: " + hondaCivic2021.getMSRP());
//        assertEquals(69420, teslaModelS2021.getMSRP(), "MSRP should return 69420.00 \n " +
//                "Actual return value: " + teslaModelS2021.getMSRP());
//    }
//
//    @Test
//    public void testGetModel(){
//        assertEquals("Civic",hondaCivic2021.getModel(),"Should return Civic");
//        assertEquals("Model-S",teslaModelS2021.getModel(),"Should return Model-S");
//    }
//
//
//    @Test
//    public void testGetAverageRating () {
//        User testUser = new User("test","test");
//        // add a 4 star rating to honda
//        ReviewSystem.inputReview("Great first car!",4.0,testUser.getUsername(),hondaCivic2021.carName());
//        // add a 2 star rating to honda
//        ReviewSystem.inputReview("not reliable, had tons of problems", 2.0,testUser.getUsername(),hondaCivic2021.carName());
//        // Average review should return 3 for honda
//        assertEquals(3.0,hondaCivic2021.getAverageRating(),"Average Rating for Honda should return: 3.0");
//
//        //add a 3 star rating to tesla
//        ReviewSystem.inputReview("nice car, but overpriced",3.0,testUser.getUsername(),teslaModelS2021.carName());
//        //add a 5 star rating to tesla
//        ReviewSystem.inputReview("awesome, best car i've driven",5.0,testUser.getUsername(),teslaModelS2021.carName());
//        //Average review should return 4 for tesla
//        assertEquals(4.0, teslaModelS2021.getAverageRating(),"Average Rating for Tesla should return: 4.0");
//
//    }
//


}