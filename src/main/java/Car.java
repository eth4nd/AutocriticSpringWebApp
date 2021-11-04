public class Car {
    private String carDescription;
    private double price;
    private double averageRating;

    public Car (String carDescription, double price, double averageRating)
    {
        this.carDescription = carDescription;
        this.price = price;
        this.averageRating = averageRating;
    }

    public String getCarDescription()
    {
        return this.carDescription;
    }

    public double getPrice()
    {
        return this.price;
    }

    public double getAverageRating()
    {
        return this.averageRating;
    }
}