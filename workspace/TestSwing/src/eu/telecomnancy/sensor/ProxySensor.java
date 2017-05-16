package eu.telecomnancy.sensor;

import java.time.Instant;

public class ProxySensor implements ISensor{

	ISensor sensor;
	public ProxySensor(ISensor s)
	{
		sensor = s;
	}
	@Override
	public void Attach(Observeur o) {
		// TODO Auto-generated method stub
		sensor.Attach(o);
		System.out.println("méthode : Attach(Observeur o) / résultat : observeur attaché / date : " + new java.util.Date());
	}

	@Override
	public void Detach(Observeur o) {
		// TODO Auto-generated method stub
		sensor.Detach(o);
		System.out.println("méthode : Detach(Observeur o) / résultat : observeur détaché / date : " + new java.util.Date());
	}

	@Override
	public void Notify() {
		// TODO Auto-generated method stub
		sensor.Notify();
		System.out.println("méthode : Notify() / résultat : observeurs notifiés / date : " + new java.util.Date());
	}

	@Override
	public void on() {
		// TODO Auto-generated method stub
		sensor.on();
		System.out.println("méthode : on() / résultat : capteur on / date : " + new java.util.Date());
	}

	@Override
	public void off() {
		// TODO Auto-generated method stub
		sensor.off();
		System.out.println("méthode : off() / résultat : capteur off / date : " + new java.util.Date());
	}

	@Override
	public boolean getStatus() {
		// TODO Auto-generated method stub
		System.out.println("méthode : getStatus() / résultat : " + sensor.getStatus() + " / date : " + new java.util.Date());
		return sensor.getStatus();
	}

	@Override
	public void update() throws SensorNotActivatedException {
		// TODO Auto-generated method stub
		sensor.update();
		System.out.println("méthode : update() / résultat : capteur off / date : " + new java.util.Date());
	}

	@Override
	public double getValue() throws SensorNotActivatedException {
		// TODO Auto-generated method stub
		System.out.println("méthode : getValue() / résultat : " + sensor.getValue() + " / date : " + new java.util.Date());
		return sensor.getValue();
	}

}
