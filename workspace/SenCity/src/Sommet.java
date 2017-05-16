
public class Sommet {

	private String name;
	private Trace trace;
	private Double min; // Minimum de distance entre un certain sommet et un sommet d'origine
	private Sommet predecessor;
	
	public Sommet(String name, Trace trace) {
		this.name=name;
		this.trace=trace;
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Trace getTrace() {
		return trace;
	}

	public void setTrace(Trace trace) {
		this.trace = trace;
	}
	
	public Double getMin() {
		return min;
	}


	public void setMin(Double min) {
		this.min = min;
	}
	
	public Sommet getPredecessor() {
		return predecessor;
	}


	public void setPredecessor(Sommet predecessor) {
		this.predecessor = predecessor;
	}
	
}
