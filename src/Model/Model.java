package Model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import Interface.Observable;
import Interface.Observer;
import Interface.Observer;
import Main.Fenetre;
import Main.FenetreConnexion;

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
			// TODO Auto-generated catch block
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
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
	@Override
	public void addObserver(Observer obs) {
		if(!views.contains(obs))
			views.add(obs);
		notifyObserver(obs);
	}
	@Override
	public void removeObserver() {
		views = new ArrayList<Observer>();
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
