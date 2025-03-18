package web.servise;

import org.springframework.ui.Model;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

public class CarServiseImpl implements CarService {
    @Override
    public List<Car> getAuto(List<Car> cars, Integer count) {
        List<Car> carList = new ArrayList<>();
        if (count == null){
            return carList;
        }

        if (count >= 5) {
            return cars;
        }
        for (int i = 0; i < count; i++) {
            carList.add(cars.get(i));
        }
        return carList;
    }
}
