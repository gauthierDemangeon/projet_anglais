import java.io.* ;
import java.util.LinkedList ;
import java.util.Scanner;


public class Traces {
	
	private LinkedList <Trace> listTrace ;

	public Traces() {
		this.listTrace = new LinkedList <Trace> () ;
		
	}
	
	public void ajouter (Trace trace) { // Ajouter une trace a la liste de Traces
		this.listTrace.add(trace) ;
	}
	
	public int taille () { // Recuperer la taille de la liste
		return listTrace.size() ;
	}
	
	public String toString() { // Convertir en chaine de caracteres
		return listTrace.toString() ;
	}
	
	public void load(String nomFichier) { // Charger les donnees dans un tableau 
		FileReader file ;
		BufferedReader fileBuff ;
		Scanner fileScan ;
		String l ;
		String timestamp ;
		String ssid ;
		String signal;
		int sig ;
		Trace trace ;
		
		try {
			file = new FileReader(nomFichier) ;
			fileBuff = new BufferedReader(file) ;
			l=fileBuff.readLine() ;
			l=fileBuff.readLine() ;
			
			
			while (l!=null) {
				fileScan=new Scanner(l) ;
				fileScan.useDelimiter(",") ;
				timestamp=fileScan.next();
				fileScan.next() ;
				ssid=fileScan.next() ;
				fileScan.next() ;
				fileScan.next();
				signal=fileScan.next();
				sig=Integer.parseUnsignedInt(signal);
				trace = new Trace (timestamp, ssid, sig) ;
				ajouter(trace) ;
				l=fileBuff.readLine() ;
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Erreur") ;
		} 
	}
	
	public void save(String nomFichier) { // Sauvegarde les donnees chargees
		FileWriter fileWrite ;
		BufferedWriter fileWriteBuff ;
		
		try {
			fileWrite = new FileWriter(nomFichier);
			fileWriteBuff = new BufferedWriter(fileWrite);
			for(Trace t : listTrace) {
				fileWriteBuff.write(t.toString());
				fileWriteBuff.newLine(); // Retour a la ligne
			}
			
			
		} catch (IOException e) {
			e.printStackTrace() ;
			System.out.println("Erreur");
		}
	}
	
	public static void main (String [] args) throws IOException {
		Traces trace = new Traces();
		trace.load("capture_wifi.csv");
		System.out.println(trace.toString());
		trace.save("données_sauvées.txt");
	}
}
