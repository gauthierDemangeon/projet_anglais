package Main;

import javax.swing.JFrame;
import Model.Model;
import View.VueConnexion;

public class FenetreConnexion extends JFrame {
	


	
	public FenetreConnexion(Model m)
	
	{
	
		this.setTitle("Connexion");
		this.setBounds(100, 100, 482, 329);
	    
	    this.setLocationRelativeTo(null);
	    VueConnexion  v = new VueConnexion(m);
	    this.setContentPane(v);
	    this.setResizable(false);
	    this.setVisible(true);
	}
}
