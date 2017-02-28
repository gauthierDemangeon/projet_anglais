package View;

import Controlers.*;
import Model.Model;

import java.awt.*;
import javax.swing.*;

public class VueAccueil extends ImagePanel implements Vue{

	/**
	 * Create the frame.
	 */
	JButton part1 = new JButton(new ImageIcon ("./images/favoriGrise.png"));
	JButton part2 = new JButton(new ImageIcon ("./images/favoriJaune.png"));
	JButton part3 = new JButton(new ImageIcon ("./images/favoriGrise.png"));
	JButton part4 = new JButton(new ImageIcon ("./images/favoriJaune.png"));
	JPanel pan = new JPanel(new GridLayout(1,4));
	
	JPanel pan2 = new JPanel(new GridLayout(1,2));
	JButton co  = new JButton("Sign in / Register");
	
	Model model;
	public VueAccueil(Model m) {
		super();
		
		model = m;
		
		/*co.setName("connexion");
		co.setOpaque(false);
		co.setBorderPainted(false);
		co.setContentAreaFilled(false);
		co.addMouseListener(new mouseListener(m));*/
		
		part1.setName("part1");
		part1.setOpaque(false);
		part1.setBorderPainted(false);
		part1.setContentAreaFilled(false);
		part1.addMouseListener(new ButtonMouseControler(m));

		part2.setName("part2");
		part2.setOpaque(false);
		part2.setBorderPainted(false);
		part2.setContentAreaFilled(false);
		part2.addMouseListener(new ButtonMouseControler(m));

		part3.setName("part3");
		part3.setOpaque(false);
		part3.setBorderPainted(false);
		part3.setContentAreaFilled(false);
		part3.addMouseListener(new ButtonMouseControler(m));

		part4.setName("part4");
		part4.setOpaque(false);
		part4.setBorderPainted(false);
		part4.setContentAreaFilled(false);
		part4.addMouseListener(new ButtonMouseControler(m));

		co.setName("co");
		co.addMouseListener(new ButtonMouseControler(m));
		
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
		model.getF().setContentPane(this);
		model.getF().revalidate();
	}
}
