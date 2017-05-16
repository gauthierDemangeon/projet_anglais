import java.io.IOException;
import java.util.ArrayList;


public class Graphe {

	ArrayList<Sommet> S;
	ArrayList<Arc> A;
	
	public Graphe (ArrayList<Sommet> S, ArrayList<Arc> A) {
		this.S=S;
		this.A=A;
	}
	
	/* Graphe vide */
	public void empty() {
		S=new ArrayList<Sommet>();
		A=new ArrayList<Arc>();
	}
	
	/* Methodes d'ajout de sommets et d'arcs*/
	public void add(Graphe G, Sommet s) {
		if (!isVertex(s)) {
			S.add(s);
		}
	}
	
	public void add (Graphe G, Arc a) {
		if (!isArrow(a) && isVertex(a.getInitial()) && isVertex(a.getTerminal())) {
			A.add(a);
		}
	}
	
	/* Methodes de suppression de sommets et d'arcs*/
	public void remove (Graphe G, Sommet s) {
		if(isVertex(s)) {
			S.remove(s);
		}
	}
	
	public void remove (Graphe G, Arc a) {
		if(isArrow(a)) {
			A.remove(a);
		}
	}
	
	/* Methodes de tests pour les sommets et les arcs d'un grphe*/
	public boolean isEmpty(Graphe G) {
		if (S.size()==0) {
			return true;
		}
		return false;
	}
	
	public boolean isVertex(Sommet s) {
		if (!isEmpty(this)) {
			for (int i=1;i<=S.size();i++) {
				if (S.get(i).equals(s)) {
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean isArrow (Arc a) {
		if (!isEmpty(this)) {
			for (int i=1; i<A.size();i++) {
				if (A.get(i).equals(a)) {
					return true;
				}
			}
		}
		return false;
	}
	
	/* Demi-degre exterieur*/
	public int outDegree(Sommet s) {
		int cpt = 0; // initialisation d'un compteur
		for (int i=0;i<A.size();i++){
			if(A.get(i).getInitial().equals(s)){
				cpt+=1;
			}
		}
		return cpt;
	}
	
	/* Demi-degre interieur*/
	public int inDegree(Sommet s) {
		int cpt = 0;
		for (int i=0;i<A.size();i++){
			if(A.get(i).getTerminal().equals(s)){
				cpt+=1;
			}
		}
		return cpt;
	}
	
	public int degree(Sommet s) {
		int in = inDegree(s);
		int out = outDegree(s);
		return in + out;
	}
	
	/* Methodes permettant de recuperer la liste des successeurs et des predecesseurs*/
	public ArrayList<Sommet> successors(Sommet s){
		ArrayList<Sommet> successors = new ArrayList<Sommet>();
		for (int i=0;i<A.size();i++){
			if(A.get(i).getInitial().equals(s)){
				successors.add(A.get(i).getTerminal());
			}
		}
		return successors;
	}
	
	public ArrayList<Sommet> predecessors(Sommet s){
		ArrayList<Sommet> predecessors = new ArrayList<Sommet>();
		for (int i=0;i<A.size();i++){
			if(A.get(i).getTerminal().equals(s)){
				predecessors.add(A.get(i).getInitial());
			}
		}
		return predecessors;
	}
	
	public Arc poidsArc(Sommet si,Sommet st){
		for(int i=0;i<A.size();i++){
			if(A.get(i).getInitial()==si && A.get(i).getTerminal() == st){
				return(A.get(i));
			}
		}
		return null;
	}

	public Sommet getSommetDistMin(ArrayList<Sommet> Q) {
		double min=Integer.MAX_VALUE;
		Sommet smin=null;
		for (Sommet s: Q) {
			if (s.getMin()<min) {
				min=s.getMin();
				smin=s;
			}
		}
		return smin;
	}
	
	
	public ArrayList<Sommet> getS() {
		return S;
	}

	public void setS(ArrayList<Sommet> s) {
		S = s;
	}

	public ArrayList<Arc> getA() {
		return A;
	}

	public void setA(ArrayList<Arc> a) {
		A = a;
	}
}