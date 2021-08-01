package com.byamada.call;

import com.byamada.call.domain.Car;
import com.byamada.call.repositories.CarRepository;
import com.byamada.call.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CallApplication implements CommandLineRunner {

	@Autowired
	private CarService service;

	@Autowired
	private CarService service2;

	public static void main(String[] args) {
		SpringApplication.run(CallApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println(service.getLastId());

		Car car = new Car(null,"Jeep Compass", "Dark grey");

		service.postCar(car);

/*

		System.out.println(service.getCars());
		service.deleteCar(1);

*/
		System.out.println(service2.getCars());

		System.out.println(service.getLastId());


	}
}
