package com.byamada.call.services;

import com.byamada.call.domain.Car;
import com.byamada.call.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    @Autowired
    private CarRepository repository;

    public List<Car> getCars(){
        return repository.getCars();
    }

    public Car getCarById(int id){
        if(id == 0){
            throw new RuntimeException("Not valid Car id");
        }
        return repository.getCarById(id);
    }

    public Car getCarByName(String name){
        if(name.isEmpty()){
            throw new RuntimeException("Not valid Car name");
        }
        return repository.getCarByName(name);
    }

    public Car getCarByColor(String color){
        if(color.isEmpty()){
            throw new RuntimeException("Not valid Car color");
        }
        return repository.getCarByColor(color);
    }

    public Car updateCar(Car car){
        Car carToUpdate = getCarById(car.getId());
        if(carToUpdate == null){
            throw new RuntimeException("Not valid Car id");
        }
        return repository.updateCar(car);
    }

    public void deleteCar(int id){
        Car carToDelete = getCarById(id);
        if(carToDelete == null){
            throw new RuntimeException("Not valid Car id");
        }
        repository.deleteCar(carToDelete);
    }

    public int postCar(Car car){
        return repository.postCar(car);
    }

    public int getLastId(){
        return repository.getLastId();
    }

}
