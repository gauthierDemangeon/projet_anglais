import java.io.*;
import java.util.Scanner;

public class Test {
	

	public static void main (String [] args) throws IOException {
		try {
			CaptureWifi wifi = new CaptureWifi("capture_wifi.csv") ;
			String ligne = wifi.readLine() ;
			while (ligne!=null) {
				ligne = wifi.readLine() ;
				Scanner Sc = new Scanner(ligne) ;
				System.out.println(Sc) ;
			}
		} catch (IOException e) {
			e.printStackTrace() ;
			System.out.println("Erreur du chargement du fichier") ;
		}
	}
}