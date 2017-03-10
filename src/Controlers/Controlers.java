package Controlers;

import java.util.Arrays;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Class.Grille;
import Main.Fenetre;
import Main.FenetreConnexion;
import Model.Model;
import View.VueAccueil;
import View.VueConnexion;
import View.VueNouvelUtilisateur;
import View.VuePart1;

public class Controlers {

	Model model;
	
	public Controlers(Model m)
	{
		model = m;
	}
	public void SetVue(String name)
	{
		switch(name)
		{
			case "part1":
				VuePart1 vp1 = new VuePart1(this);
				model.addObserver(vp1);
				break;
			case "part2":
				break;
			case "part3":
				break;
			case "part4":
				break;
		}
	}
	public void BackAccueil()
	{
		VueAccueil va = null;
		if(model.Instanceof("VueAccueil") == null)
		{
			va = new VueAccueil(this);
			model.getViews().add(va);
		}
		else
		{
			va = (VueAccueil) model.Instanceof("VueAccueil");
		}
		model.notifyObserver(va);
	}
	public void SetConnexionWindow()
	{
		if(model.getFc() == null)
		{
			FenetreConnexion f = new FenetreConnexion(this);
			model.setFc(f);
		}
		//On garde les données
		VueConnexion vc = null;
		if(model.Instanceof("VueConnexion") == null)
		{
			vc = new VueConnexion(this);
			model.getViews().add(vc);
		}
		else
		{
			vc = (VueConnexion) model.Instanceof("VueConnexion");
		}
		// OU VueConnexion vc = new VueConnexion(this);
		model.addObserver(vc);
	}
	public boolean UserExistant(String user,String pwd)
	{
		if(user.length() == 0 || user.equals("Username") || pwd.length() == 0 || pwd.equals("Password"))
			return false;
		return model.UserExistant(user, pwd);
	}
	public void SaveUser(String user,String pwd)
	{
		model.SaveUser(user, pwd);
		Connexion();
	}
	public void SetNewUserView()
	{
		model.getFc();
		//On garde les données
		VueNouvelUtilisateur vnu = null;
		if(model.Instanceof("VueNouvelUtilisateur") == null)
		{
			vnu = new VueNouvelUtilisateur(this);
			model.getViews().add(vnu);
		}
		else
		{
			vnu = (VueNouvelUtilisateur) model.Instanceof("VueNouvelUtilisateur");
		}
		// OU VueNouvelUtilisateur vnu = new VueNouvelUtilisateur(this);
		model.addObserver(vnu);
	}
	public void ColorButton(String word,boolean orientation)
	{
		VuePart1 vp1 = null;
		if(model.Instanceof("VuePart1") == null)
		{
			vp1 = new VuePart1(this);
			model.getViews().add(vp1);
		}
		else
		{
			vp1 = (VuePart1) model.Instanceof("VuePart1");
		}
		vp1.setClicked(true);
		vp1.setButtonIndexes(vp1.getGrille().getWordIndexes(word, orientation));
		model.notifyObserver(vp1);
	}
	public Grille GetGrille()
	{
		return model.ParseurGrille("./DB/grille.csv");
	}
	public void Connexion()
	{
		model.setConnect(true);
	}
	public void Deconnexion()
	{
		model.setConnect(false);
	}
	public Fenetre GetMainWindow()
	{
		return model.getF();
	}
	public FenetreConnexion GetConnexionWindow()
	{
		return model.getFc();
	}
	public boolean GetConnexionState()
	{
		return model.isConnect();
	}
}
