package eu.telecomnancy.sensor;

public class FahrenheitSensorDecorater extends SensorDecorater {

	public FahrenheitSensorDecorater(ISensor s) {
		super(s);
	}

	@Override
	public void on() {
		// TODO Auto-generated method stub
		this.sensor.on();
	}

	@Override
	public void off() {
		// TODO Auto-generated method 
		this.sensor.off();
	}

	@Override
	public boolean getStatus() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void update() throws SensorNotActivatedException {
		// TODO Auto-generated method stub
		this.sensor.update();
	}

	@Override
	public double getValue() throws SensorNotActivatedException {
		// TODO Auto-generated method stub
		return this.FahrenheitConversion(this.sensor.getValue());
	}

	@Override
	public void Attach(Observeur o) {
		// TODO Auto-generated method stub
		this.sensor.Attach(o);
	}

	@Override
	public void Detach(Observeur o) {
		// TODO Auto-generated method stub
		this.sensor.Detach(o);
	}

	@Override
	public void Notify() {
		// TODO Auto-generated method stub
		this.sensor.Notify();
	}

}
