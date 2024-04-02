package view;

import java.util.concurrent.Semaphore;

import controller.CarController;

public class Main {

	public static void main(String[] args) {
		
		CarController[] cars = new CarController[4];
		Semaphore mutex = new Semaphore(1);
		
		for(int i = 0; i < 4; i++) 
			cars[i] = new CarController(i,mutex);
		
		for(CarController car : cars) 
			car.start();
	}
}
