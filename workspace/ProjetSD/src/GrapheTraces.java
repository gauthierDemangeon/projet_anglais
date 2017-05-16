import java.util.ArrayList;

public class GrapheTraces {
	
	private Graphe G;
	
	/* Releve la distance physique entre deux trace (conversion de longitute/latitude en distance)*/
	public Double distanceTrace(Trace t1, Trace t2,Double alpha )
	{
		Double R = 6371000.0; // m
		Double lat1=t1.getGps().getLatitude();
		Double lat2 =t2.getGps().getLatitude();
		Double dLat = (lat1*Math.PI/180-lat2*Math.PI/180);
		
		Double dLon = (t1.getGps().getLongitude()*Math.PI/180-t2.getGps().getLongitude()*Math.PI/180);

		Double a = Math.sin(dLat/2) * Math.sin(dLat/2) +
		        Math.sin(dLon/2) * Math.sin(dLon/2) * Math.cos(lat1) * Math.cos(lat2); 
		Double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a)); 
		Double d = R * c;
		return (alpha*d+(1-alpha)*1/(t1.getSignal()+t2.getSignal()));
		
	}
	
	/* Renvoi le sommet associe au barycentre d'une liste de traces */
	public Sommet barycentre(String name,ArrayList<Trace> t){ 
		Double moyenneLatitude = 0.0;
		Double moyenneLongitude = 0.0;
		int moyenneSignal = 0;
		int n =t. size();
		for(int i=0;i<n;i++){
			moyenneLatitude += t.get(i).getGps().getLatitude();
			moyenneLongitude += t.get(i).getGps().getLongitude();
			moyenneSignal += t.get(i).getSignal();
		}
		moyenneLatitude = moyenneLatitude/(double) n;
		moyenneLongitude = moyenneLongitude/(double) n;
		moyenneSignal = moyenneSignal / n;
		
		long ts = t.get(0).getTimestamp(); 
		String ssid = t.get(0).getSsid() ;
		int signal = moyenneSignal;
		GPS gps = new GPS(moyenneLatitude,moyenneLongitude);
		Trace moyTrace = new Trace(ts,ssid,signal,gps);
		Sommet sommet = new Sommet(name,moyTrace);
		return sommet;
	}
	
	/*Creation d'un arc entre le sommet s1 et s2 */
	public Arc creeArc(Sommet s1,Sommet s2,Double alpha){
		Double cout = distanceTrace(s1.getTrace(), s2.getTrace(),alpha );
		return new Arc(s1,s2,cout);
	}
	
	/* Creation des arcs entre les secteurs (assimiles a des sommets) */
	public ArrayList<Arc> creeArc(ArrayList<Sommet> S,Double distanceMax,Double alpha){
		ArrayList<Arc> A = new ArrayList<Arc>();
		for (int i = 0;i<S.size();i++){
			for (int j =0;j<S.size();j++){
				if (j!=i && estDansSecteur(S.get(i),S.get(j),5*distanceMax,alpha)){ // MODIF!
					 A.add(creeArc(S.get(i),S.get(j),alpha));
				}
			}
		}
		return A;
	}
	
	/* Verifie qu'une trace t1 est proche d'un autre trace t2 */
	public Boolean estDansSecteur(Trace t1,Trace t2,Double dmax,Double alpha){
		Double cout = distanceTrace(t1, t2,alpha );
		if(cout<=dmax){
			return true;
		}
		return false;
	}

	/* Même principe qu'avec les traces mais avec des sommets */
	public Boolean estDansSecteur(Sommet s1,Sommet s2,Double dmax,Double alpha){
		Double cout = distanceTrace(s1.getTrace(), s2.getTrace(),alpha );
		if(cout<=dmax){
			return true;
		}
		return false;
	}
	
	/* Recupere une liste des traces voisines */
	public ArrayList<Trace> traceVoisines(Trace trace,ArrayList<Trace> t,Double distanceMax,Double alpha){
		ArrayList<Trace> tracesVoisines = new ArrayList<Trace>();	
		for(int i=0;i<t.size();i++){
			if(estDansSecteur(trace,t.get(i),distanceMax,alpha)){
				tracesVoisines.add(t.get(i)); 
				t.remove(i);
			}	
		}
		return tracesVoisines;
	}
	
	/* Creation d'un sommet a partir de la liste de toutes les traces en fonction d'une distance maximum */
	public void creeSommetBarycentre(ArrayList<Trace> t,Double distanceMax,Double alpha){
		ArrayList<Sommet> resultat = new ArrayList<Sommet>();
		ArrayList<Trace> tracesVoisines;
		String name = "s";
		int i = 0;
		while (t.size() != 0){
			tracesVoisines = traceVoisines(t.get(0),t,distanceMax,alpha);
			if(t.size() != 0 && t.contains(t.get(0)))
				t.remove(0);
			name = name + Integer.toString(i);
			resultat.add(barycentre(name,tracesVoisines));
			i++;
			name = "s";
		}
		this.getG().setS(resultat);
	}
	
	public GrapheTraces (ArrayList<Trace> t,Double alpha,Double dmax){
		this.setG(new Graphe(new ArrayList<Sommet>(),new ArrayList<Arc>()));
		creeSommetBarycentre(t,dmax,alpha);
		this.setG(new Graphe(this.getG().getS(),creeArc(this.getG().getS(),dmax,alpha)));
	}

	public Graphe getG() {
		return G;
	}

	public void setG(Graphe g) {
		G = g;
	}
}