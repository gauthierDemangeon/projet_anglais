import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

public abstract class Traces extends AbstractTraces{

	protected Collection<Trace> Tracelist;
	
	public abstract void initialiser();
	
	public String toString() 
	{
		return Tracelist.toString();
	}
	
	public int taille () 
	{
		return Tracelist.size();
	}
	
	public void Add (Trace trace) {
		Tracelist.add(trace);
	}
	public abstract Collection<Trace> extract(String ssid); 
	public void Save(String nomFichier) 
	{
		FileWriter Fw;
		BufferedWriter Buffer;
		
		try 
		{
			Fw = new FileWriter(nomFichier);
			Buffer = new BufferedWriter(Fw);
			
			for(Trace t : Tracelist) 
			{
				Buffer.write(t.toString());
				Buffer.newLine();
			}
			
			
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
			System.out.println("Erreur lors de la sauvegarde du fichier");
		}
	}
	
	public static void main (String [] args) throws IOException 
	{
		long t1,t2;
		LinkedListTraces trace = new LinkedListTraces();
		LinkedList<Trace> trace2 = new LinkedList<Trace>();
		t1 = System.currentTimeMillis();
		trace.Load("capture_wifi_2.csv","capture_gps_2.csv",50);
		//System.out.println(trace.toString());
		t2 = System.currentTimeMillis();
		trace.Save("data.txt");
		System.out.println("temps d'executtion : " + (t2-t1) + " ms");
		System.out.println(trace.taille());
		t1 = System.currentTimeMillis();
		trace2 = (LinkedList<Trace>) trace.extract("eduroam");
		t2 = System.currentTimeMillis();
		System.out.println("temps d'extraction : " + (t2-t1) + " ms");
	}
}
