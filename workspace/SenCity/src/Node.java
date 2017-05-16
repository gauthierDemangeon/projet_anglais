public class Node {

	private char elt;
	private Node fils = null;
	private Node frere = null;
	private ArrayListTraces TraceList;
	
	public Node(char elt,ArrayListTraces TraceList)
	{
		this.elt=elt;
		this.TraceList = TraceList;
	}

	public ArrayListTraces getListeTraces() 
	{
		return TraceList;
	}

	public void setListeTraces(ArrayListTraces listeTraces) 
	{
		TraceList = listeTraces;
	}

	public char getElt() 
	{
		return elt;
	}

	public void setElt(char elt) 
	{
		this.elt = elt;
	}

	public Node getFils() 
	{
		return fils;
	}

	public void setFils(Node fils) 
	{
		this.fils = fils;
	}

	public Node getFrere() 
	{
		return frere;
	}

	public void setFrere(Node frere) 
	{
		this.frere = frere;
	}
	
	

}
