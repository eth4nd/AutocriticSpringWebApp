public class Car {
    private String carDescription;
    private double price;
    private double averageRating;

    /**
     * Constructor for Car objects, Cars should be unique
     * @param carDescription The description of the car
     * @param price The price of the car
     * @param averageRating The average rating of the car
     */
    public Car (String carDescription, double price, double averageRating)
    {
        this.carDescription = carDescription;
        this.price = price;
        this.averageRating = averageRating;
    }

    /**
     * Getter method for carDescription
     * @return carDescription
     */
    public String getCarDescription()
    {
        return this.carDescription;
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
}