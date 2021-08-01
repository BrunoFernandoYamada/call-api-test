package com.byamada.call.repositories;

import com.byamada.call.domain.Car;
import com.byamada.call.utils.CustomComparetor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


@Component
public class CarRepository {

    private static CarRepository carRepository = new CarRepository();
    private List<Car> cars = new ArrayList<>();

    private CarRepository(){
        instatiateCars();
    }

    public static CarRepository getInstance(){
        return carRepository;
    }

    private void instatiateCars(){
        Car car1 = new Car(1,"Ferrari", "Red");
        Car car2 = new Car(2,"New Beatle", "White");
        Car car3 = new Car(3,"Porsche", "Yellow");

        cars.addAll(Arrays.asList(car1,car2,car3));

    }

    public List<Car> getCars() {
        return cars;
    }

    public Car getCarById(int id){
        for(Car car : this.cars){
            if(car.getId() == id) {
                return car;
            }
        }
        return null;
    }

    public Car getCarByName(String name){
        for(Car car : this.cars){
            if(car.getName().equals(name)) {
                return car;
            }
        }
        return null;
    }

    public Car getCarByColor(String color){
        for(Car car : this.cars){
            if(car.getColor().equals(color)) {
                return car;
            }
        }
        return null;
    }

    public Car updateCar(Car carToUpdate){
        cars.stream().map(elemento -> {
            if(elemento.getId() == carToUpdate.getId()){
                cars.remove(elemento);
                cars.add(carToUpdate);
                return carToUpdate;
            }
            return null;
        });

        throw new RuntimeException("Not valid Car id");
    }

    public void deleteCar(Car car){
        cars.remove(car);
    }

    public int postCar(Car car){
        car.setId(getLastId());
        cars.add(car);
        return car.getId();
    }


    public int getLastId(){
        Comparator<Car> comparator = new CustomComparetor();
        cars.stream().sorted(comparator);
        return cars.get(cars.size() - 1).getId() + 1;

    }


}
