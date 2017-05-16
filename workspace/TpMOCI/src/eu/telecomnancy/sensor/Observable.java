package eu.telecomnancy.sensor;

public interface Observable {

	public void Attach(Observeur o);
	public void Detach(Observeur o);
	public void Notify();
}
