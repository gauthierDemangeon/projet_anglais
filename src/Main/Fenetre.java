package Main;

import javax.swing.JFrame;

import Model.Model;
import View.*;

public class Fenetre extends JFrame {
	
	//SearchModel m ;
	
	public Fenetre()
	{
		// Fenetre
		this.setTitle("English Pratice");
	    this.setSize(1280, 740);        
	    this.setExtendedState(JFrame.MAXIMIZED_BOTH);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null);
	    this.setVisible(false);
	}
	public void update()
	{
		this.setVisible(true);
		this.revalidate();
	}
}
