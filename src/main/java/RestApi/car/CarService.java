package RestApi.car;


import Model.Car.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    private final CarDataAccess carDataAccess;

    @Autowired
    public CarService(CarDataAccess carDataAccess){
        this.carDataAccess = carDataAccess;
    }
    List<Car> getCars(){
        return carDataAccess.getCars();
    }

}
