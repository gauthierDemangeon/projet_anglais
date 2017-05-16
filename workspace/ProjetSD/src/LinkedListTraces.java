import java.io.* ;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList ;


public class LinkedListTraces extends Traces
{
	
	public void initialiser() 
	{
		Tracelist = new LinkedList<Trace>();
	}


	@Override
	public Collection<Trace> extract(String ssid) 
	{
		LinkedList<Trace> traces = new LinkedList<Trace>();
		for(Trace t:Tracelist)
		{
			if(t.getSsid().equals(ssid))
				traces.add(t);
		}
		return traces;
	}
	
	public static void main (String [] args) throws IOException 
	{
		long t1,t2;
		LinkedListTraces trace = new LinkedListTraces();
		LinkedList<Trace> trace2 = new LinkedList<Trace>();
		t1 = System.currentTimeMillis();
		trace.Load("capture_wifi.csv","capture_gps.csv",50);
		t2 = System.currentTimeMillis();
		trace.Save("data.txt");
		System.out.println(trace.taille());
		System.out.println("temps d'executtion : " + (t2-t1) + " ms");
		t1 = System.currentTimeMillis();
		trace2 = (LinkedList<Trace>)trace.extract("eduroam");
		t2 = System.currentTimeMillis();
		System.out.println(trace2.size());
		System.out.println("temps d'extraction : " + (t2-t1) + " ms");
	}
}
