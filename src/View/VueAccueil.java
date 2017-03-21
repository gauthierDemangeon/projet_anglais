package View;

import Controlers.*;
import Interface.Observer;
import Main.FenetreConnexion;
import Model.Model;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class VueAccueil extends ImagePanel implements Observer{

	/**
	 * Create the frame.
	 */
	JButton part1 = new JButton(new ImageIcon ("./images/boutton1.png"));
	JButton part2 = new JButton(new ImageIcon ("./images/boutton2.png"));
	JButton part3 = new JButton(new ImageIcon ("./images/boutton3.png"));
	JButton part4 = new JButton(new ImageIcon ("./images/boutton4.png"));
	JPanel pan = new JPanel(new GridLayout(1,4));
	
	JPanel pan2 = new JPanel(new GridLayout(1,2));
	JButton co  = new JButton(new ImageIcon ("./images/boutonconnexion.png"));
	
	Controlers controler;
	public VueAccueil(Controlers c) {
		super("./images/Présentation.jpg");
		controler = c;
		/*co.setName("connexion");
		co.setOpaque(false);
		co.setBorderPainted(false);
		co.setContentAreaFilled(false);
		co.addMouseListener(new mouseListener(m));*/
		
		part1.setName("part1");
		part1.setOpaque(false);
		part1.setBorderPainted(false);
		part1.setContentAreaFilled(false);
		part1.addActionListener(new BouttonListener());

		part2.setName("part2");
		part2.setOpaque(false);
		part2.setBorderPainted(false);
		part2.setContentAreaFilled(false);
		part2.addActionListener(new BouttonListener());

		part3.setName("part3");
		part3.setOpaque(false);
		part3.setBorderPainted(false);
		part3.setContentAreaFilled(false);
		part3.addActionListener(new BouttonListener());

		part4.setName("part4");
		part4.setOpaque(false);
		part4.setBorderPainted(false);
		part4.setContentAreaFilled(false);
		part4.addActionListener(new BouttonListener());

		co.setName("co");
		co.setOpaque(false);
		co.setBorderPainted(false);
		co.setContentAreaFilled(false);
		co.addActionListener(new BouttonListener());
		
		pan.setOpaque(false);
		pan.add(part1);
		pan.add(part2);
		pan.add(part3);
		pan.add(part4);
		
		pan2.setOpaque(false);
		pan2.add(co);
		JPanel pan3 = new JPanel(new BorderLayout());
		pan3.setOpaque(false);
		pan3.add(pan2, BorderLayout.EAST);
		
		add(pan3,BorderLayout.NORTH);
		add(pan,BorderLayout.CENTER);
	}
	
	 
	public void update() {
		if(controler.GetConnexionState())
			co.setIcon(new ImageIcon ("./images/boutonDeconnexion.png"));
		else
			co.setIcon(new ImageIcon ("./images/boutonconnexion.png"));
		controler.GetMainWindow().setContentPane(this);
		controler.GetMainWindow().update();
	}

	class BouttonListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			switch(((JButton)e.getSource()).getName())
			{
				case "part1":
				case "part2":
				case "part3":
				case "part4":
					controler.SetVue(((JButton)e.getSource()).getName());
					break;
				case "co":
					if(!controler.GetConnexionState())
						controler.SetConnexionWindow();
					else
						controler.Deconnexion();
					break;
				default:
					break;
			}
		}
	}
}
