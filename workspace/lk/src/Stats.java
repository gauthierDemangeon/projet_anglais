import java.io.IOException;
import java.util.Scanner;


public class Stats {

	public Stats() {

	}
	
	public static void main (String [] args) {
		try {
			CaptureWifi Capt = new CaptureWifi("capture_wifi.csv") ;
			String ligne = Capt.readLine() ;
			ligne = Capt.readLine() ;
			//System.out.println(ligne) ;
			
			while (ligne!=null) {
				Scanner sc = new Scanner(ligne) ;
				sc.useDelimiter(",") ;
				String p = sc.next();
				//System.out.println(p);
				
				if (p.equals(args[2])) {
					//System.out.println("Ca marche");
					
					while (sc.hasNext()) {
						System.out.println(ligne) ;
						p = sc.next();
					}
					
				}
				ligne = Capt.readLine() ;
			}
		} catch (IOException e) {
			e.printStackTrace() ;
			System.out.println("Erreur") ;
		}
	}
	
}


