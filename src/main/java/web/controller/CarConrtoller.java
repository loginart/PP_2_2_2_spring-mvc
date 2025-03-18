package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.servise.CarServiseImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class CarConrtoller {
    @GetMapping("/cars")
    public String printCars(@RequestParam(value = "count",required = false) Integer count, ModelMap model) {
        CarServiseImpl carServise = new CarServiseImpl();
        Car honda = new Car("Honda", "Civic", 1);
        Car lada = new Car("Lada", "Granta", 2);
        Car opel = new Car("Opel", "Astra", 3);
        Car lada4 = new Car("Lada", "Vesta", 4);
        Car mazda = new Car("Mazda", "CX5", 5);
        List<Car> cars = List.of(honda, lada, opel, lada4, mazda);
        List<Car> result = carServise.getAuto(cars, count);
        model.addAttribute("result", result);
        return "cars";
    }
}
