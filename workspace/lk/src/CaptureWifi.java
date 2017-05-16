import java.io.*;
import java.util.Scanner ;

public class CaptureWifi {
	
	private FileReader Capture ;
	private BufferedReader CaptureFiltre ; 
	private Scanner Filtre ;
	
	public CaptureWifi(String nomFichier) throws FileNotFoundException {
		this.Capture = new FileReader(nomFichier) ; // Permet de lire un fichier
		CaptureFiltre = new BufferedReader(Capture) ; // Tampon : recupere chaque ligne
		Filtre = new Scanner(CaptureFiltre) ; // Scanner : recupere chaque donnee (segmentation des mots)
	}

	public String readLine() throws IOException { // Permet de lire sur un scanner
		return CaptureFiltre.readLine() ;
	}
	
	public void affiche() {
		System.out.println(Filtre) ;
	}
}
