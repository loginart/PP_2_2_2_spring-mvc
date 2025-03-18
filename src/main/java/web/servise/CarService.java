package web.servise;

import web.model.Car;

import java.util.List;

public interface CarService {
     List<Car> getAuto(List<Car> cars, Integer count);
}
