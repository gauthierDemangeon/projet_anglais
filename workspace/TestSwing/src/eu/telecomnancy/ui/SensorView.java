package eu.telecomnancy.ui;

import eu.telecomnancy.sensor.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SensorView extends JPanel implements Observeur {
    private ISensor sensor;

    private JLabel value = new JLabel("N/A Â°C");
    private JButton on = new JButton("On");
    private JButton off = new JButton("Off");
    private JButton update = new JButton("Acquire");
    private JButton Convert = new JButton("Fahrenheit");
    private JButton Round = new JButton("Round");
    
    private boolean deg = true;
    private boolean round = false;
    private String unit = " °C";
    
    public SensorView(ISensor c) {
        this.sensor = c;
        this.setLayout(new BorderLayout());

        value.setHorizontalAlignment(SwingConstants.CENTER);
        Font sensorValueFont = new Font("Sans Serif", Font.BOLD, 18);
        value.setFont(sensorValueFont);

        this.add(value, BorderLayout.CENTER);


        on.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sensor.on();
            }
        });

        off.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sensor.off();
            }
        });

        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    sensor.update();
                } catch (SensorNotActivatedException sensorNotActivatedException) {
                    sensorNotActivatedException.printStackTrace();
                }
            }
        });

        Convert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	if(deg)
            	{
            		sensor = new FahrenheitSensorDecorater(sensor);
            		unit = " °F";
            		Convert.setText("Degré");
            	}
            	else
            	{
            		sensor = new DegreeSensorDecorater(sensor);
            		unit = " °C";
            		Convert.setText("Fahrenheit");
            	}
            	deg = !deg;
            }
        });

        Round.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	if(!round)
            	{
            		sensor = new RoundSensorDecorater(sensor);
            		Round.setText("Unround");
            	}
            	else
            	{
            		sensor = new UnroundSensorDecorater(sensor);
            		Round.setText("Round");
            	}
            	round = !round;
            }
        });

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(1, 5));
        buttonsPanel.add(update);
        buttonsPanel.add(on);
        buttonsPanel.add(off);
        buttonsPanel.add(Convert);
        buttonsPanel.add(Round);

        this.add(buttonsPanel, BorderLayout.SOUTH);
    }

	@Override
	public void update() {
		try
		{
			value.setText(sensor.getValue() + unit);
		}
		catch (SensorNotActivatedException sensorNotActivatedException)
		{
			value.setText("N/A Â°C");
			sensorNotActivatedException.printStackTrace();
		}
	}
}
