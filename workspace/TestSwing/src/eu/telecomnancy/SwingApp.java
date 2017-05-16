package eu.telecomnancy;

import eu.telecomnancy.sensor.FahrenheitSensorDecorater;
import eu.telecomnancy.sensor.ISensor;
import eu.telecomnancy.sensor.NewSensor;
import eu.telecomnancy.sensor.ProxySensor;
import eu.telecomnancy.sensor.RoundSensorDecorater;
import eu.telecomnancy.sensor.TemperatureSensor;
import eu.telecomnancy.ui.MainWindow;

public class SwingApp {

    public static void main(String[] args) {
        ISensor sensor = new TemperatureSensor();
        new MainWindow(sensor);
    }

}
