import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;

public class HashMapTraces extends MapTraces{

	
	public void initialiser() 
	{
		Map = new HashMap<String,ArrayList<Trace>>();
	}


	@Override
	public Collection<Trace> extract(String ssid) 
	{
		return Map.get(ssid);
	}
	
	public static void main (String [] args) throws IOException 
	{
		/*LinkedListTraces trace = new LinkedListTraces();
		trace.Load("capture_wifi.csv","capture_gps.csv",70);
		System.out.println(trace.toString());
		trace.Save("data.txt");*/
	}
}
