package RestApi.car;

import Model.Car.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/car")
@CrossOrigin("*")
public class CarController {

    private final CarService carService;

    @Autowired
    public CarController(CarService userService){
        this.carService = userService;
    }

    @GetMapping
    public List<Car> getUsers()
    {
        return carService.getCars();
    }
}
