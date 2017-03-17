package Model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import Class.Grille;
import Interface.Observable;
import Interface.Observer;
import Interface.Observer;
import Main.Fenetre;
import Main.FenetreConnexion;
import View.VueJeu;

public class Model implements Observable{
	Fenetre f;
	FenetreConnexion fc;
	ArrayList<Observer> views = new ArrayList<Observer>();
	boolean connect = false;
	
	public boolean isConnect() {
		return connect;
	}
	public void setConnect(boolean connect) {
		this.connect = connect;
		if(connect)
			fc.dispose();
		notifyObserver(this.Instanceof("VueAccueil"));
	}
	public FenetreConnexion getFc() {
		return fc;
	}
	public void setFc(FenetreConnexion fc) {
		this.fc = fc;
	}
	
	public Fenetre getF() {
		return f;
	}
	public void setF(Fenetre f) {
		this.f = f;
	}
	public ArrayList<Observer> getViews() {
		return views;
	}
	public void setViews(ArrayList<Observer> views) {
		this.views = views;
	}
	
	public Model(Fenetre f)
	{
		this.f = f;
	}
	public boolean UserExistant(String usr,String pwd)
	{
		try {
			FileReader Fr = new FileReader("./DB/Login.csv");
			BufferedReader Br = new BufferedReader(Fr);
			String line = null;
			while((line = Br.readLine()) != null)
			{
				if(line.split(";")[0].equals(usr) && line.split(";")[1].equals(String.valueOf(pwd.hashCode())))
					return true;
			}
			Br.close();
			Fr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean SaveUser(String usr,String pwd)
	{
		try {
			FileWriter Fw = new FileWriter("./DB/Login.csv");
			BufferedWriter Bw = new BufferedWriter(Fw);
			Bw.write(usr + ';' + pwd.hashCode());
			Bw.close();
			Fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	public Grille ParseurGrille(String path)
	{
		Grille g = null;
		try{
			BufferedReader fichierCSV = new BufferedReader(new FileReader(path));
			String reader;
			int n;
			Boolean finGrille = false;
			ArrayList<String[]> lettres = new ArrayList<String[]>();
			ArrayList<String> mots = new ArrayList<String>();
			ArrayList<String> indication = new ArrayList<String>();
			ArrayList<Boolean> orientation = new ArrayList<Boolean>();
			
			while((reader = fichierCSV.readLine())!= null)
			{	
				if(reader.replaceAll(";", "").equals(""))
				{
					finGrille = true;
					reader = fichierCSV.readLine();
				}
				
				String[] ligne = reader.split(";",-1);
				if(!finGrille)
				{  
					lettres.add(ligne);
				}
				else
				{
					mots.add(ligne[0].trim());
					indication.add(ligne[1]);
					orientation.add(ligne[2].trim().equals("h"));
				}
			}
			String[][] tabLettre = new String[lettres.size()][lettres.get(0).length];
			for(int i=0;i<lettres.size();i++)
			{
				tabLettre[i] = lettres.get(i);
			}
			String[] tabMots = new String[mots.size()];
			tabMots = mots.toArray(tabMots);
			String[] tabIndication = new String[indication.size()];
			tabIndication = indication.toArray(tabIndication);
			Boolean[] tabOrientation = new Boolean[orientation.size()];
			tabOrientation = orientation.toArray(tabOrientation);
			g = new Grille(tabMots,tabIndication,tabOrientation,tabLettre);
		}
		catch (IOException e){
			System.out.println("Le fichier est introuvable !");
		}
		return g;
	}
	public Observer Instanceof(String typeofview)
	{
		for(Observer v : views)
		{
			if(v.getClass().getName().endsWith((typeofview)))
				return v;
		}
		return null;
	}
	public Observer Instanceof(int level)
	{
		for(Observer v : views)
		{
			if(v instanceof VueJeu && ((VueJeu)v).getlevel() == level)
				return v;
		}
		return null;
	}
	@Override
	public void addObserver(Observer obs) {
		if(!views.contains(obs))
			views.add(obs);
		notifyObserver(obs);
	}
	@Override
	public void removeObserver(Observer obs) {
		if(obs == null)
			views = new ArrayList<Observer>();
		else
		{
			if(views.contains(obs))
				views.remove(obs);
		}
	}
	@Override
	public void notifyObserver(Observer obs) {
		if(obs == null)
		{
			for(Observer o : views)
			      o.update();
		}
		else
			obs.update();
	}
}
