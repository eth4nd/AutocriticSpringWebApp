package Model.Car;

import Model.Review.Review;

import java.util.ArrayList;
import java.util.Objects;

public class Car implements Comparable<Car>{
    private String carName;
    private double price;
    private double averageRating;
    private ArrayList<Review> carReviews = new ArrayList<>();

    /**
     * Constructor to create Car objects
     * @param carName The name of the car
     * @param price The price of the car
     */
    public Car (String carName, double price)
    {
        this.carName = carName;
        this.price = price;
        averageRating = 0;
    }

    /**
     * Getter method for carName
     * @return carName
     */
    public String getCarName()
    {
        return this.carName;
    }

    /**
     * Getter method for price
     * @return price
     */
    public double getPrice()
    {
        return this.price;
    }

    /**
     * Getter method for averageRating
     * @return averageRating
     */
    public double getAverageRating()
    {
        return this.averageRating;
    }

    /**
     * Getter method for carReviews
     * @return carReviews
     */
    public ArrayList<Review> getReviews()
    {
        return this.carReviews;
    }

    /**
     * Creates a String representation of the Car object
     * @return String representation containing carName, price, averageRating
     */
    @Override
    public String toString() {
        return "name: " + this.carName + ", price: " + this.price + ", average rating: " + this.averageRating;
    }

    /**
     * Deep equals method that compares by hashCode
     * @param o Car object
     * @return True if hashCodes match, deep equals
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car that = (Car) o;
        return this.hashCode() == that.hashCode();
    }

    /**
     * Generates hashCode based on carName, price, and averageRating
     * @return int
     */
    @Override
    public int hashCode() {
        return Objects.hash(this.carName, this.price, this.averageRating);
    }

    /**
     * Compares by carName by default
     * @return -1 if preceding, 0 if equal, 1 if following
     */
    public int compareTo(Car that) {
        return this.carName.compareTo(that.carName);
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
     * Recalculates averageRating with a newRating
     * @param newRating The new rating from the review
     */
    private void calcAvgRating(double newRating)
    {
        averageRating = (averageRating + newRating) / carReviews.size();
    }
}
