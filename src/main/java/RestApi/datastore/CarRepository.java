package RestApi.datastore;



import Model.Car.Car;
import Model.Car.CarDatabase;
import Model.Database.BucketManager;


import org.springframework.stereotype.Repository;
import java.util.*;
import java.util.concurrent.TimeUnit;

@Repository
public class CarRepository {

    private List<Car> CARS;

    public CarRepository(){
        BucketManager bucketManager = new BucketManager();
        CarDatabase carDatabase = new CarDatabase();
        //load users into the user repository for frontend
        CARS = carDatabase.downloadCar("placeholder", bucketManager.getS3Database(),100);

    }

    public List<Car> getCars(){
        return CARS;
    }
}
