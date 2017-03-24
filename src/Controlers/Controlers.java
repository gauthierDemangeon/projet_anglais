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
import View.VueJeu;

public class Controlers {

	Model model;
	
	public Controlers(Model m)
	{
		model = m;
	}
	public void SetVue(String name)
	{
		int level = 0;
		switch(name)
		{
			case "part1":
				level = 0;
				break;
			case "part2":
				level = 1;
				break;
			case "part3":
				level = 2;
				break;
			case "part4":
				level = 3;
				break;
		}
		if(model.Instanceof(level) == null)
		{
			model.addObserver(new VueJeu(this,level));
		}
		else
			model.notifyObserver(model.Instanceof(level));
	}
	public void BackAccueil()
	{
		VueAccueil va = null;
		if(model.Instanceof("VueAccueil") == null)
		{
			va = new VueAccueil(this);
		}
		else
		{
			va = (VueAccueil) model.Instanceof("VueAccueil");
		}
		model.addObserver(va);
		model.notifyObserver(va);
	}
	public void SetConnexionWindow()
	{
		if(model.getFc() == null)
		{
			FenetreConnexion f = new FenetreConnexion(this);
			model.setFc(f);
		}
		//On garde les donn�es
		VueConnexion vc = null;
		if(model.Instanceof("VueConnexion") == null)
		{
			vc = new VueConnexion(this);
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
		//On garde les donn�es
		VueNouvelUtilisateur vnu = null;
		if(model.Instanceof("VueNouvelUtilisateur") == null)
		{
			vnu = new VueNouvelUtilisateur(this);
		}
		else
		{
			vnu = (VueNouvelUtilisateur) model.Instanceof("VueNouvelUtilisateur");
		}
		// OU VueNouvelUtilisateur vnu = new VueNouvelUtilisateur(this);
		model.addObserver(vnu);
	}
	public void ColorButton(String hint,boolean orientation,int level)
	{
		VueJeu vj = null;
		if(model.Instanceof(level) == null)
		{
			vj = new VueJeu(this,level);
		}
		else
		{
			vj = (VueJeu) model.Instanceof(level);
		}
		model.addObserver(vj);
		
		vj.setClicked(true);
		vj.setButtonIndexes(vj.getGrille().getWordIndexes(hint, orientation));
		model.notifyObserver(vj);
	}
	public Grille GetGrille(int level)
	{
		String path = null;
		switch(level)
		{
		case 0:
			path = "./DB/grille_debutant.csv";
			break;
		case 1:
			path = "./DB/grille_facile.csv";
			break;
		case 2:
			path = "./DB/grille_intermédiaire.csv";
			break;
		case 3:
			path = "./DB/grille_expert.csv";
			break;
		default:
			path = "./DB/grille_debutant.csv";
			break;
		}
		return model.ParseurGrille(path);
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
