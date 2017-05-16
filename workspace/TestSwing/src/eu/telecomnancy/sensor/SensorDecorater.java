package eu.telecomnancy.sensor;

public abstract class SensorDecorater implements ISensor {

	ISensor sensor;
	public SensorDecorater(ISensor s)
	{
		sensor = s;
	}
	protected double FahrenheitConversion(double value)
	{
		return value*1.8+32;
	}
	protected double DegreeConversion(double value)
	{
		return (value-32)/1.8;
	}
	public double Round(double value) 
	{
	     return Math.round(value);
	}
}
