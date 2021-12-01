package Model.Car;

import Model.Review.Review;
import interfaces.Model;
import java.util.ArrayList;
import java.util.Objects;

public class Car implements Comparable<Car>, Model{
    private int year;
    private String make;
    private String model;
    private double MSRP;
    private double averageRating;
    private ArrayList<Review> carReviews;

    /**
     * Constructor to create Car objects
     * @param year The year the car was manufactured
     * @param make The manufacturer of the car
     * @param model The model of the car
     * @param MSRP The average MSRP car is being sold for
     */
    public Car (int year, String make, String model, double MSRP)
    {
        this.year = year;
        this.make = make;
        this.model = model;
        this.MSRP = MSRP;
        averageRating = 0;
        carReviews = new ArrayList<>();
    }

    /**
     * Getter method for the year the car was manufactured
     * @return this.year
     */
    public int getYear()
    {
        return this.year;
    }

    /**
     * Getter method for make of the car object
     * @return this.make
     */
    public String getMake()
    {
        return this.make;
    }

    /**
     * Getter method for model of the car object
     * @return model
     */
    public String getModel()
    {
        return this.model;
    }

    /**
     * Getter method for MSRP of car object
     * @return MSRP
     */
    public double getMSRP()
    {
        return this.MSRP;
    }

    /**
     * Getter method for averageRating of car object
     * @return averageRating
     */
    public double getAverageRating()
    {
        return this.averageRating;
    }

    /**
     * Getter method for carReviews arraylist
     * @return carReviews
     */
    public ArrayList<Review> getReviews()
    {
        return this.carReviews;
    }

    /**
     * Creates a String representation of the Car object
     * @return String representation containing 'year' 'make' and 'model' of the car object
     * followed by a MSRP and Average Rating of the car
     */
    @Override
    public String toString() {
        return this.getYear() + " " + this.getMake() + " " + this.getModel() +
                " MSRP: $" + this.getMSRP() + " Average Rating: " + this.getAverageRating();
    }

    /**
     * Output the Year, Make, Model of Car
     * @return carName, contains just year, make, and model of car
     */
    public String carName(){
        String carName = this.getYear() + "," + this.getMake() + "," + getModel();
        return carName;
    }

    /**
     * Deep equals method that compares by hashCode
     * @param o Car object
     * @return True if hashCodes match, deep equals
     */
    @Override
    public boolean equals(Object o) {
      // null object or not object of same type check
        if (!(o instanceof Car))
            return false;
        Car that = (Car) o;
        return (this.compareTo(that) == 0);
    }

    /**
     * Generates hashCode based on carName, price, and averageRating
     * @return output of Object.hash of year, make, and model of the car
     */
    @Override
    public int hashCode()
    {
        return Objects.hash(this.year, this.make, this.model);
    }

    /**
     * Compares by carName by default
     * @return negative integer if preceding, 0 if equal, positive if following
     */
    public int compareTo(Car that)
    {
        if(!this.make.equals(that.make))
            return this.make.compareTo(that.make);
        if(!this.model.equals(that.model))
            return this.model.compareTo(that.model);
        if(this.year != that.year)
            return this.year - that.year;
        else
            return 0;
    }

    /**
     * Stores a review into carReviews and recalculates the averageRating
     * @param review Review to be stored
     */
    public void storeReview(Review review)
    {
        carReviews.add(review);
        calcAvgRating(review.getRating());
    }

    /**
     * Recalculates averageRating with a newRating, called when a new review is added
     * @param newRating The new rating from the review
     */
    private void calcAvgRating(double newRating)
    {
        averageRating = (averageRating + newRating) / carReviews.size();
    }
}
