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
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null);
	    Model m = new Model(this);
	    VueAccueil v = new VueAccueil(m);
	    m.getViews().add(v);
	    this.setContentPane(v);
	    this.setVisible(true);
	}
	
}
