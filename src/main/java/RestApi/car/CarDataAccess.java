package RestApi.car;

import Model.Car.Car;
import RestApi.datastore.CarRepository;
import RestApi.datastore.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CarDataAccess {

    private final CarRepository carRepository;

    @Autowired
    public CarDataAccess(CarRepository carRepository){
        this.carRepository = carRepository;
    }
    List<Car> getCars(){
        return carRepository.getCars();
    }
}
