package Main;

import Controlers.Controlers;
import Model.Model;
import View.VueAccueil;

public class Main 
{
	public static void main (String [] args)
	{
		Fenetre f = new Fenetre();
		
	    Model model = new Model(f);

	    Controlers controler = new Controlers(model);
	    
	    VueAccueil vue = new VueAccueil(controler);
	    
	    model.addObserver(vue);
	}
}
