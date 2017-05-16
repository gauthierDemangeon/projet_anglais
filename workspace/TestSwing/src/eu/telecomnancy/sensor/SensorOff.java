package eu.telecomnancy.sensor;

public class SensorOff implements State {
	@Override
	public boolean getStatus() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void update(NewSensor sensor) throws SensorNotActivatedException {
		// TODO Auto-generated method stub
		throw new SensorNotActivatedException("Sensor must be activated before acquiring new values.");
	}

	@Override
	public double getValue(NewSensor sensor) throws SensorNotActivatedException {
		// TODO Auto-generated method stub
		throw new SensorNotActivatedException("Sensor must be activated to get its value.");
	}

}
