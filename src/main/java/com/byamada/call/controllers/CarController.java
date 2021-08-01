package com.byamada.call.controllers;

import com.byamada.call.domain.Car;
import com.byamada.call.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private CarService service;

    @GetMapping
    public ResponseEntity<List<Car>> getAllCars(){
        return ResponseEntity.ok(service.getCars());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable Integer id){
        return ResponseEntity.ok(service.getCarById(id));
    }

    @GetMapping("/color")
    public ResponseEntity<Car> getCarByName(@RequestParam(required = true) String name){
        return ResponseEntity.ok(service.getCarByName(name));
    }

    @PostMapping
    public ResponseEntity<Integer> postCar(@RequestBody Car car){
        int id = service.postCar(car);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping()
    public ResponseEntity<Car> updateCar(@RequestBody Car car){
        service.updateCar(car);
        return ResponseEntity.notFound().build();

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable Integer id){
        service.deleteCar(id);
        return ResponseEntity.noContent().build();
    }


}
