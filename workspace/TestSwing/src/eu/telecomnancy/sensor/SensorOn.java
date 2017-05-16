package eu.telecomnancy.sensor;

import java.util.Random;

public class SensorOn implements State {
	
	@Override
	public boolean getStatus() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void update(NewSensor sensor) {
		// TODO Auto-generated method stub
		sensor.value = (new Random()).nextDouble() * 100;
        sensor.Notify();
	}

	@Override
	public double getValue(NewSensor sensor) throws SensorNotActivatedException {
		// TODO Auto-generated method stub
		return sensor.value;
	}

}
