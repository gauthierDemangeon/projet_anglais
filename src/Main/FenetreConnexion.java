package Main;

import javax.swing.JFrame;

import Controlers.Controlers;
import Model.Model;
import View.VueConnexion;

public class FenetreConnexion extends JFrame {
	


	
	public FenetreConnexion(Controlers c)
	
	{
	
		this.setTitle("Connexion");
		this.setBounds(100, 100, 482, 329);
	    
	    this.setLocationRelativeTo(null);
	    this.setResizable(false);
	    this.setVisible(false);
	}

	public void update()
	{
		this.setVisible(true);
		this.revalidate();
	}
}
