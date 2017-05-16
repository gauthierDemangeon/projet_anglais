import java.io.*;
import java.util.Scanner;

public class Test {
	

	public static void main (String [] args) throws IOException {
		try {
			CaptureWifi Capt = new CaptureWifi("capture_wifi.csv") ;
			String ligne = Capt.readLine() ;
			//System.out.println(ligne) ;
			while (ligne!=null) {
				ligne = Capt.readLine() ;
				Scanner sc = new Scanner(ligne) ;
				System.out.println(sc) ;
			}
		} catch (IOException e) {
			e.printStackTrace() ;
			System.out.println("Erreur") ;
		}
	}
}