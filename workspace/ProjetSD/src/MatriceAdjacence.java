import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;


public class MatriceAdjacence {
	
	private Double[][] Matrice;
	private int n;
	
	public MatriceAdjacence(Graphe G){
		ArrayList<Sommet> S = G.getS();
		int n = S.size();
		Matrice = new Double[n][n];
		Arc aTemp;
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){ // Modif
				aTemp = new Arc(S.get(i),S.get(j),null);
				if(G.isArrow(aTemp)){
					Matrice[i][j] = G.poidsArc(S.get(i),S.get(j)).getPoids();
				}
				else{
					Matrice[i][j] = 0.0;
				}
			}
		}
		this.n = n;
	}

	
	public Double[][] getMatrice() {
		return Matrice;
	}
	
	public void setMatrice(Double[][] matrice) {
		Matrice = matrice;
	}
	
	public void afficheMatrice()
	{
		for(int i=0;i<this.Matrice.length;i++)
		{
			System.out.print("[");
			for(int j=0;j<this.Matrice[i].length-1;j++)
			{
				System.out.print(this.Matrice[i][j]+" , ");
			}
			System.out.println(this.Matrice[i][this.Matrice[i].length-1]+"]");
		}
	}

	public void maj_distances(Double[] d,int s1,int s2){ 
		 if(d[s2]> (d[s1] + this.getMatrice()[s1][s2])){
			 d[s2] = d[s1] + this.getMatrice()[s1][s2];
		 }
	}
	
	/* Indique si TOUS les sommets compris dans la queue ont ete visites */
	public Boolean tousVisites(Boolean[] Q){
		for(int i=0;i<Q.length;i++){
			if(Q[i]==true){
				return(false);
			}
		}
		return true;
	}
	
	public int getCoutMin(Boolean[] Q,Double[] d){
		int min = -1;
		Double cout_min = 100000000000000.0;
		for(int i =0;i<n;i++){
			if(d[i]<cout_min && Q[i]){
				min = i;
				cout_min = d[i];
			}
		}
		if(tousVisites(Q)){
			return(Q.length-1);
		}
		return min;
	}
	
	/*	Algorithme de Dijkstra: renvoi la liste des poids en fonction d'un sommet initial */
	
	public Double[] Dijkstra(int si){ 
		
		// Initialisation
		Double[] d = new Double[n];
		for(int s=0;s<n;s++)
		{
			d[s] = Double.MAX_VALUE;
		}
		d[si]=0.0;
		int s1 = si;
		Boolean[] Q = new Boolean[n]; // Queue rassemble tous les sommets non visites
		for(int i=0;i<n;i++){
			Q[i]=true;
			}
		// Boucle principale
		while (!tousVisites(Q)){
			s1 = getCoutMin(Q,d);
			Q[s1]=false;
			for (int s2=0;s2<n;s2++){
				if(Matrice[s1][s2] > 0.0){
					maj_distances(d,s1,s2);
				}
			}
		}
		return d;
	}
	
	/* Determine le chemin le plus court d'un sommet initial vers un sommet terminal*/
	public ArrayList<Integer> cheminPlusCourt(int si,int st){
		ArrayList<Integer> cheminOpt = new ArrayList<Integer>();
		Double[] d = Dijkstra(si);
		int s = st;
		Double coutPred;
		int predecesseur = s;
		while(s != si){
			cheminOpt.add(s);
			coutPred = 0.0;
			for(int i = 0;i<n;i++){
				if(Matrice[i][s]>0.0 && d[i]<=d[s] && coutPred<=d[i]){
					coutPred = d[i];
					predecesseur = i;
				}
			}
			s = predecesseur;
			
		}
		cheminOpt.add(si);
		return inverseChemin(cheminOpt);
	}
	
	/* Permet d'inverser l'ordre des elements d'une liste */
	public ArrayList<Integer> inverseChemin(ArrayList<Integer> chemin) {
		ArrayList<Integer> cheminInverse = new ArrayList<Integer>();
		for (int i=chemin.size()-1; i>=0; i--) {
			cheminInverse.add(chemin.get(i));
		}
		return cheminInverse;
	}
	
	public static void afficheChemin(ArrayList<Integer> Chemin)
	{
		System.out.print("Le plus court chemin est : ");
		for(int i=0;i<Chemin.size()-1;i++)
		{
			System.out.print("Sommet "+Chemin.get(i)+" --> ");
		}
		System.out.println("Sommet "+Chemin.get(Chemin.size()-1));
	}
	
    public static void main (String [] args) throws IOException 
	{
		Double alpha,dmax;
		String fWifi,fGPS,ssid;
		int seuil;
		int Si,St;
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
		do
		{
			trace.Load(fWifi,fGPS,seuil);
			trace.Save("data.txt");
			afficheSsid(trace.recupSsid());
			System.out.println("Veuillez indiquer le ssid souhaité : ");
			ssid = scanInput.nextLine();
			trace2 = (ArrayList<Trace>) trace.extract(ssid);
			System.out.println("Veuillez indiquer alpha : ");
			alpha = Double.parseDouble(scanInput.nextLine());
			System.out.println("Veuillez indiquer la distance max : ");
			dmax = Double.parseDouble(scanInput.nextLine());
			GrapheTraces graphe = new GrapheTraces(trace2,alpha,dmax);
			MatriceAdjacence M = new MatriceAdjacence(graphe.getG());
			gpsSommet(graphe.getG()); // modif
			//System.out.println("Nombre de sommet : " + M.Matrice.length + "( entre 0 et "+ (M.Matrice.length-1)+" )");
			do
			{
				System.out.println("Veuillez indiquer le sommet initial ( entre 0 et "+ (M.Matrice.length-1)+" ) : "); // modif
				Si = Integer.parseInt(scanInput.nextLine());
				System.out.println("Veuillez indiquer le sommet terminal ( entre 0 et "+ (M.Matrice.length-1)+" ) : "); // modif
				St = Integer.parseInt(scanInput.nextLine());
			} while(Si == St || Si >= M.Matrice.length || St >= M.Matrice.length);
			afficheChemin(M.cheminPlusCourt(Si,St));
			System.out.println("Voulez vous faire une autre recherche? : (y/n)");
			if(scanInput.nextLine().equals("n"))
				fin = !fin;
		}
		while(fin);
		scanInput.close();
	}

	private static void afficheSsid(LinkedList<String> recupSsid) {
		for(int i=0;i<recupSsid.size()-1;i++)
		{
			System.out.print((i+1)+") "+recupSsid.get(i)+" | ");
		}
		System.out.println(recupSsid.size()+") "+recupSsid.get(recupSsid.size()-1));
	}
	
	//modif
	private static void gpsSommet(Graphe g)
	{
		for(int i=0;i<g.getS().size();i++)
		{
			System.out.println("Coordonnées "+g.getS().get(i).getName()+ " : Lat = "+g.getS().get(i).getTrace().getGps().getLatitude()+" Lon = "+g.getS().get(i).getTrace().getGps().getLongitude());
		}
	}
}
