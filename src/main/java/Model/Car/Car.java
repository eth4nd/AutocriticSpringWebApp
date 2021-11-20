package Model.Car;

import Model.Review.Review;

import java.util.ArrayList;
import java.util.Objects;

public class Car implements Comparable<Car>{
    private String carName;
    private double price;
    private double averageRating;
    private ArrayList<Review> carReviews = new ArrayList<>();

    public Car (String carName, double price)
    {
        this.carName = carName;
        this.price = price;
        averageRating = 0;
    }

    public String getCarName()
    {
        return this.carName;
    }

    public double getPrice()
    {
        return this.price;
    }

    public double getAverageRating()
    {
        return this.averageRating;
    }

    public ArrayList<Review> getReviews()
    {
        return this.carReviews;
    }

    @Override
    public String toString() {
        return "name: " + this.carName + ", price: " + this.price + ", average rating: " + this.averageRating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car that = (Car) o;
        return this.hashCode() == that.hashCode();
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.carName, this.price, this.averageRating);
    }

    /**
     * Compare by carName by default
     */
    public int compareTo(Car that) {
        return this.carName.compareTo(that.carName);
    }

    public void storeReview(Review review)
    {
        carReviews.add(review);
        calcAvgRating(review.getRating());
    }
    private void calcAvgRating(double newRating)
    {
        averageRating = (averageRating + newRating) / carReviews.size();
    }
}
