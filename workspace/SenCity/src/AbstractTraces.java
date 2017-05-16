import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public abstract class AbstractTraces {

	public abstract void initialiser();
	public abstract String toString();
	public abstract int taille();
	public abstract Collection<Trace> extract(String ssid);
	public abstract void Add(Trace trace);

	public long TraiteTS(String elt)
	{
		long ts = Long.parseLong(elt);
		ts = ts/1000000000;
		return ts;
	}
	
	public void Load(String nomFichierWifi,String nomFichierGPS,double perte) throws IOException
	{ 
		FileReader FrW,FrG;
		BufferedReader BufferW,BufferG;
		String ligneW,ligneG;
		Trace trace;
		double cpt=0,cptW=0;
		initialiser();
		try 
		{
			FrW = new FileReader(nomFichierWifi);
			BufferW = new BufferedReader(FrW);
			
			ligneW=BufferW.readLine();
			ligneW=BufferW.readLine();
			
			FrG = new FileReader(nomFichierGPS);
			BufferG = new BufferedReader(FrG);
			
			ligneG=BufferG.readLine();
			ligneG=BufferG.readLine();
			long tsW,tsG;
			while (ligneW != null && ligneG != null) 
			{
				String eltW[] = ligneW.split(",");
				String eltG[] = ligneG.split(",");
				
				tsW = TraiteTS(eltW[0]);
				tsG = TraiteTS(eltG[0]);
				if(tsW > tsG) {
					ligneG=BufferG.readLine();
				}
				else {
					if(tsG > tsW) {
						ligneW=BufferW.readLine();
						cptW++;
					}
					else {
						if(!eltW[2].equals("<hidden>")) {
							trace = new Trace (tsW, eltW[2], Integer.parseInt(eltW[5]),new GPS(Double.parseDouble(eltG[1]),Double.parseDouble(eltG[2])));
							Add(trace);
						}
						ligneW=BufferW.readLine();
					}
				}
				cpt++;
			}
			BufferW.close();
			BufferG.close();
			if((cptW/cpt)*100>=perte){
				throw new IOException();
				}
		}
		catch (IOException e) 
		{
			e.printStackTrace();
			System.out.println("Erreur lors du chargement du fichier"); 
		}
	}

	public abstract void Save(String nomFichier);
	
	public static void main (String [] args) throws IOException 
	{
		long t1,t2;
		HashMapTraces trace = new HashMapTraces();
		ArrayList<Trace> trace2 = new ArrayList<Trace>();
		t1 = System.currentTimeMillis();
		trace.Load("capture_wifi_2.csv","capture_gps_2.csv",50);
		t2 = System.currentTimeMillis();
		//System.out.println(trace.toString());
		trace.Save("data.txt");
		System.out.println(trace.taille());
		System.out.println("temps d'executtion : " + (t2-t1) + " ms");
		t1 = System.currentTimeMillis();
		trace2 = (ArrayList<Trace>) trace.extract("eduroam");
		t2 = System.currentTimeMillis();
		System.out.println("temps d'extraction : " + (t2-t1) + " ms");
	}
}
