package eu.telecomnancy.sensor;

import java.util.ArrayList;
import java.util.Random;

public class NewSensor implements ISensor {
    State state;
	public double value = 0;
	
	ArrayList<Observeur> ObserverList = new ArrayList<Observeur>();
	
	public NewSensor()
	{
		state = new SensorOff();
	}
    @Override
    public void on() {
        state = new SensorOn();
    }

    @Override
    public void off() {
        state = new SensorOff();
    }

    @Override
    public boolean getStatus() {
        return state.getStatus();
    }

    @Override
    public void update() throws SensorNotActivatedException {
        state.update(this);
    }

    @Override
    public double getValue() throws SensorNotActivatedException {
            return state.getValue(this);
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
