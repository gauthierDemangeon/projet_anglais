package eu.telecomnancy.sensor;

import java.util.ArrayList;

public class Adaptateur implements ISensor {

	LegacyTemperatureSensor Sensor;
	ArrayList<Observeur> ObserverList;
	private double temp = 0;
	public Adaptateur()
	{
		Sensor = new LegacyTemperatureSensor();
		ObserverList = new ArrayList<Observeur>();
	}
	@Override
	public void on() {
		if(!Sensor.getStatus())
			Sensor.onOff();
	}

	@Override
	public void off() {
		if(Sensor.getStatus())
			Sensor.onOff();
	}

	@Override
	public boolean getStatus() {
		
		return Sensor.getStatus();
	}

	@Override
	public void update() throws SensorNotActivatedException {
		if (Sensor.getStatus())
		{
			temp = Sensor.getTemperature();
			Notify();
		}
		else
			throw new SensorNotActivatedException("Sensor must be activated to get its value.");
	}

	@Override
	public double getValue() throws SensorNotActivatedException {
        if (Sensor.getStatus())
            return temp;
        else throw new SensorNotActivatedException("Sensor must be activated to get its value.");
	}
	@Override
	public void Attach(Observeur o) {
		if(!ObserverList.contains(o))
			ObserverList.add(o);
	}
	@Override
	public void Detach(Observeur o) {
		if(ObserverList.contains(o))
			ObserverList.remove(o);
	}
	@Override
	public void Notify() {
		for(Observeur o : ObserverList)
		{
			o.update();
		}
	}

}
