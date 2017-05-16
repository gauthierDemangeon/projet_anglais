import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public abstract class MapTraces extends AbstractTraces{


	protected Map<String,ArrayList<Trace>> Map;
	
	public abstract void initialiser();
	
	public String toString() 
	{
		return Map.toString();
	}
	
	public int taille () 
	{
		return Map.size();
	}
	
	public void Add (Trace trace) 
	{
		String ssid = trace.getSsid();
		if(!Map.containsKey(ssid)) 
		{
			Map.put(ssid,new ArrayList<Trace>());
		}
		Map.get(ssid).add(trace);
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
			for(String ssid : Map.keySet()) 
			{
				for(Trace t:Map.get(ssid))
				{
					Buffer.write(t.toString());
					Buffer.newLine();
				}
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
		HashMapTraces trace = new HashMapTraces();
		ArrayList<Trace> trace2 = new ArrayList<Trace>();
		t1 = System.currentTimeMillis();
		trace.Load("capture_wifi.csv","capture_gps.csv",50);
		t2 = System.currentTimeMillis();
		//System.out.println(trace.toString());
		trace.Save("data.txt");
		System.out.println(trace.taille());
		System.out.println("temps d'executtion : " + (t2-t1) + " ms");
		t1 = System.currentTimeMillis();
		trace2 = (ArrayList<Trace>) trace.extract("eduroam");
		t2 = System.currentTimeMillis();
		System.out.println(trace2.size());
		System.out.println("temps d'extraction : " + (t2-t1) + " ms");
	}
}
