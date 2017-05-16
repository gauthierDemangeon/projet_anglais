package eu.telecomnancy.sensor;

public interface State {
    public boolean getStatus();
    public void update(NewSensor sensor) throws SensorNotActivatedException;
    public double getValue(NewSensor sensor) throws SensorNotActivatedException;
}
