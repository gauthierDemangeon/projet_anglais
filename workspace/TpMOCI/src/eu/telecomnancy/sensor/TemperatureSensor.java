package eu.telecomnancy.sensor;

import java.util.ArrayList;
import java.util.Random;

public class TemperatureSensor implements ISensor {
    boolean state;
    double value = 0;
	ArrayList<Observeur> ObserverList = new ArrayList<Observeur>();
	
    @Override
    public void on() {
        state = true;
    }

    @Override
    public void off() {
        state = false;
    }

    @Override
    public boolean getStatus() {
        return state;
    }

    @Override
    public void update() throws SensorNotActivatedException {
        if (state)
        {
            value = (new Random()).nextDouble() * 100;
            Notify();
        }
        else throw new SensorNotActivatedException("Sensor must be activated before acquiring new values.");
    }

    @Override
    public double getValue() throws SensorNotActivatedException {
        if (state)
            return value;
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
