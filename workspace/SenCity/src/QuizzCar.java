import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class QuizzCar {

	public static void main (String [] args) throws IOException 
	{
		String fWifi,fGPS,ssid;
		int seuil;
		boolean fin = true;
		Scanner scanInput = new Scanner(System.in);
		TreeTraces trace = new TreeTraces(new Node('e',null));
		ArrayList<Trace> trace2 = new ArrayList<Trace>();
		System.out.println("Veuillez indiquer le nom du fichier Wifi : ");
		fWifi = scanInput.nextLine();
		System.out.println("Veuillez indiquer le nomdu fichier GPS : ");
		fGPS = scanInput.nextLine();
		System.out.println("Veuillez indiquer le seuil voulu : ");
		seuil = Integer.parseInt(scanInput.nextLine());
		trace.Load(fWifi,fGPS,seuil);
		//trace.Save("data.txt");
		do
		{
			System.out.println("Veuillez indiquer le ssid souhaité : ");
			ssid = scanInput.nextLine();
			trace2 = (ArrayList<Trace>) trace.extract(ssid);
			System.out.println("Nb traces pour "+ssid+" : "+trace2.size());
			System.out.println("Voulez vous faire une autre recherche? : (y/n)");
			if(scanInput.nextLine().equals("n"))
				fin = !fin;
		}
		while(fin);
	}
}
