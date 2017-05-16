import java.io.IOException;
import java.util.Scanner;


public class Stats {

	public Stats() {}
	
	public static void main (String [] args) 
	{
		try 
		{
			CaptureWifi wifi = new CaptureWifi("capture_wifi.csv");
			String ligne = wifi.readLine();
			ligne = wifi.readLine();
			while (ligne!=null) 
			{
				Scanner Sc = new Scanner(ligne);
				Sc.useDelimiter(",");
				String elt = Sc.next();
				if (elt.equals(args[0])) 
				{
					
					while (Sc.hasNext()) 
					{
						System.out.println(ligne);
						elt = Sc.next();
					}
					
				}
				ligne = wifi.readLine() ;
				Sc.close();
			}
		} catch (IOException e) 
		{
			e.printStackTrace();
			System.out.println("Erreur du chargement du fichier");
		}
	}
	
}


