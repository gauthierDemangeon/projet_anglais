import java.io.*;

public class CaptureWifi 
{
	
	private FileReader Fr ;
	private BufferedReader Buffer ; 
	//private Scanner Sc ;
	
	public CaptureWifi(String nomFichier) throws FileNotFoundException 
	{
		Fr = new FileReader(nomFichier);
		Buffer = new BufferedReader(Fr);
		//Filtre = new Scanner(CaptureFiltre);
	}

	public String readLine() throws IOException 
	{
		return Buffer.readLine();
	}
}
