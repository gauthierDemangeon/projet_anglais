import java.io.* ;
import java.util.ArrayList ;
import java.util.Collection;


public class ArrayListTraces extends Traces
{
	
	public void initialiser() 
	{
		Tracelist = new ArrayList<Trace>();
	}
	@Override
	public Collection<Trace> extract(String ssid) 
	{
		ArrayList<Trace> traces = new ArrayList<Trace>();
		for(Trace t:Tracelist)
		{
			if(t.getSsid().equals(ssid))
				traces.add(t);
		}
		return traces;
	}
	public static void main (String [] args) throws IOException 
	{
		ArrayList<Trace> trace2 = new ArrayList<Trace>();
		ArrayListTraces trace = null;
		long t1,t2;
		trace = new ArrayListTraces();
		t1 = System.currentTimeMillis();
		trace.Load("capture_wifi.csv","capture_gps.csv",50);
		t2 = System.currentTimeMillis();
		trace.Save("data.txt");
		System.out.println("Nb de traces"+trace.taille());
		System.out.println("temps d'executtion : " + (t2-t1) + " ms");
		
		t1 = System.currentTimeMillis();
		trace2 = (ArrayList<Trace>) trace.extract("eduroam");
		t2 = System.currentTimeMillis();
		System.out.println(trace2.size());
		System.out.println("temps d'extraction : " + (t2-t1) + " ms");
	}
}
