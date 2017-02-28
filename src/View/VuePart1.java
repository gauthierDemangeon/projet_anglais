package View;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

import Controlers.Controlers;
import Interface.Observer;
import Model.Model;

public class VuePart1 extends ImagePanel implements Observer {

	Controlers controler;
	public VuePart1(Controlers c)
	{
		super();
		controler = c;
		JButton back = new JButton(new ImageIcon ("./images/boutonlogo.png"));
		back.setName("backV1");
		back.setOpaque(false);
		back.setBorderPainted(false);
		back.setContentAreaFilled(false);
		back.addActionListener(new ButtonListener());
		JPanel pan = new JPanel(new BorderLayout());
		pan.setOpaque(false);
		pan.add(back,BorderLayout.AFTER_LINE_ENDS);
		add(pan,BorderLayout.SOUTH);
	}
	public void update() {
		controler.GetMainWindow().setContentPane(this);
		controler.GetMainWindow().update();
	}
	
	public class ButtonListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			switch(((JButton)e.getSource()).getName())
			{
				case "backV1":
					controler.BackAccueil();
					break;
				default:
					break;
			}
		}
	}
}
