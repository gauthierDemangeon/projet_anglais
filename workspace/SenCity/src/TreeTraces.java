import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

public class TreeTraces extends AbstractTraces{

	private Node racine;
	private int size = 0;
	private ArrayList<Node> ListeFeuille = new ArrayList<Node>();
	
	public TreeTraces (Node node)
	{
		this.racine = node;
	}
	public Node rechercheFeuille(String ssid)
	{
		Node N = racine;
		for(int i=0;i<ssid.length();i++)
		{
			while(N.getElt() != ssid.charAt(i))
			{
				N = N.getFrere();
			}
			N = N.getFils();
		}
		if(!ListeFeuille.contains(N))
			ListeFeuille.add(N);
		return N;
	}
	public void AddTree(Trace t,String ssid)
	{
		Node N = rechercheFeuille(ssid);
		if (N.getListeTraces() == null)
		{
			N.setListeTraces(new ArrayListTraces());
			N.getListeTraces().initialiser();
		}
		N.getListeTraces().Add(t);
		size++;
	}
	public void ajouterSsid(String ssid)
	{
		ssid = ssid+'!';
		Node N = racine;
		for(int i=1;i<ssid.length();i++)
		{
			while(N.getElt() != ssid.charAt(i-1))
			{
				if(N.getFrere() == null)
					N.setFrere(new Node(ssid.charAt(i-1),null));
				N = N.getFrere();
			}
			if(N.getFils() == null)
				N.setFils(new Node(ssid.charAt(i),null));
			N = N.getFils();
		}
		if(N.getElt() != ssid.charAt(ssid.length()-1))
		{
			while(N.getFrere() != null)
				N = N.getFrere();
			N.setFrere(new Node(ssid.charAt(ssid.length()-1),null));
		}
	}
	public boolean ssidExistant(String ssid)
	{
		ssid = ssid+'!';
		Node N = racine;
		for(int i=0;i<ssid.length();i++)
		{
			while(N.getElt() != ssid.charAt(i))
			{
				if(N.getFrere() == null)
					return false;
				N = N.getFrere();
			}
			if(N.getFils() == null)// && i < ssid.length()-1)
				return false;
			N = N.getFils();
		}
		return true;
		
	}
	
	
	@Override
	public void initialiser() 
	{
		// TODO Auto-generated method stub
		
	}
	@Override
	public String toString() 
	{
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public int taille() 
	{
		return size;
	}
	
	@Override
	public Collection<Trace> extract(String ssid) 
	{
		return rechercheFeuille(ssid).getListeTraces().Tracelist;
	}
	
	@Override
	public void Add(Trace trace) {
		if(!ssidExistant(trace.getSsid()))
		{
			ajouterSsid(trace.getSsid());
		}
		AddTree(trace,trace.getSsid());
	}

	@Override
	public void Save(String nomFichier) {
		// TODO Auto-generated method stub
		FileWriter Fw;
		BufferedWriter Buffer;
		
		try 
		{
			Fw = new FileWriter(nomFichier);
			Buffer = new BufferedWriter(Fw);
			
			for(Node N:ListeFeuille)
			{
				for(Trace t:N.getListeTraces().Tracelist)
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
	
	public LinkedList<String> recupSsid()
	{
		LinkedList<String> ssid = new LinkedList<String>();
		for(Node N:ListeFeuille)
		{
			ssid.add(((ArrayList<Trace>)N.getListeTraces().Tracelist).get(0).getSsid());
		}
		return ssid;
	}

	public static void main (String [] args) throws IOException 
	{
		long t1,t2;
		TreeTraces trace = new TreeTraces(new Node('e',null));
		ArrayList<Trace> trace2 = new ArrayList<Trace>();
		t1 = System.currentTimeMillis();
		trace.Load("capture_wifi.csv","capture_gps.csv",50);
		t2 = System.currentTimeMillis();
		trace.Save("data.txt");
		System.out.println(trace.taille());
		System.out.println("temps d'execution : " + (t2-t1) + " ms");
		t1 = System.currentTimeMillis();
		trace2 = (ArrayList<Trace>) trace.extract("eduroam");
		t2 = System.currentTimeMillis();
		System.out.println(trace2.size());
		System.out.println("temps d'extraction : " + (t2-t1) + " ms");
	}
}
