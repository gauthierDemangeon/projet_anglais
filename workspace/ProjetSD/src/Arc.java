
public class Arc {
	private Sommet initial; // Extremite initiale
	private Sommet terminal; // Extremite terminale
	private Double poids; // Poids de l'arete
	
	public Arc(Sommet initial, Sommet terminal, Double poids) {
		this.initial=initial;
		this.terminal=terminal;
		this.poids=poids;
	}

	public Sommet getInitial() {
		return initial;
	}

	public void setInitial(Sommet initial) {
		this.initial = initial;
	}

	public Sommet getTerminal() {
		return terminal;
	}

	public void setTerminal(Sommet terminal) {
		this.terminal = terminal;
	}

	public Double getPoids() {
		return poids;
	}

	public void setPoids(Double poids) {
		this.poids = poids;
	}
	
	public boolean equals(Arc A) {
		if(this.getInitial() == A.getInitial() && this.getTerminal() == A.getTerminal())
			return true;
		return false;
	}

}
