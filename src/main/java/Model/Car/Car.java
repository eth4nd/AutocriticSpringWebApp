package Model.Car;

import interfaces.Model;
import java.util.Objects;

/**
 * Car model class that represents Car objects that will be stored in the car database.
 */
public class Car implements Comparable<Car>, Model{
    private String carName;
    private double avgRating;
    private int numOfRatings;
    private int totalRatings;

    /**
     * Constructor to create Car objects
     * @param carName is the name of the car
     * @param avgRating is the average rating for this car
     * @param numOfRatings is total number of ratings on car
     */
    public Car (String carName, double avgRating, int numOfRatings, int totalRatings)
    {
        this.carName = carName;
        this.avgRating = avgRating;
        this.numOfRatings = numOfRatings;
        this.totalRatings = totalRatings;
    }


    /**
     * Creates a String representation of the Car object
     * @return String representation of car object
     * returns ";carName;avgRating;numOfRatings;" which is our file storage format
     */
    @Override
    public String toString() {
        return ";"+this.carName+";"+this.avgRating+";"+this.numOfRatings+";";
    }

    /**
     * Creates a String representation of the year, make, and model of the car
     * @return carName, which contains a String of year, make, and model of car
     */
    public String carName(){
        return carName;
    }

    /**
     * Deep equals method that compares by hashCode
     * @param o Car object
     * @return true if hashCodes match, indicating deep equals
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
     * @return Object.hash of year, make, and model of the car
     */
    @Override
    public int hashCode()
    {
        return Objects.hash(this.carName,this.avgRating,this.numOfRatings);
    }

    /**
     * Compares by carName by default
     * @return negative integer if preceding, zero if equal, positive if following
     */
    public int compareTo(Car that)
    {
        if(!this.carName.equals(that.carName))
            return this.carName.compareTo(that.carName);
        if(this.avgRating != that.avgRating)
            return (int) (this.avgRating - that.avgRating);
        if(this.numOfRatings != that.numOfRatings)
            return this.numOfRatings - that.numOfRatings;
        else
            return 0;
    }


    /**
     * Recalculates averageRating with a newRating, called when a new review is added
     * to this particular object
     * @param newRating The new rating from the review
     */
    private void calcAvgRating(double newRating)
    {
        this.totalRatings += newRating;
        this.numOfRatings++;
        this.avgRating = totalRatings / numOfRatings;
    }
}
