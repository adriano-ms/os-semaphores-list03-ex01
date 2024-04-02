package controller;

import java.util.concurrent.Semaphore;

public class CarController extends Thread {

	public static final int NORTH = 0;
	public static final int SOUTH = 1;
	public static final int EAST = 2;
	public static final int WEST = 3;

	private String direction;
	private Semaphore mutex;

	public CarController() {
		super();
	}

	public CarController(int direction, Semaphore mutex) {
		this.direction = toDirection(direction);
		this.mutex = mutex;
	}
	
	private void pass() throws InterruptedException {
		mutex.acquire();
		System.out.println(this + ": passing with direction " + direction);
		mutex.release();
	}
	
	public String toDirection(int direction) {
		switch(direction) {
		case NORTH:
			return "NORTH";
		case SOUTH:
			return "SOUTH";
		case EAST:
			return "EAST";
		default:
			return "WEST";
		}
	}

	@Override
	public void run() {
		try {
			pass();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {

		return this.getName().replace("Thread-", "Car ");
	}
}
