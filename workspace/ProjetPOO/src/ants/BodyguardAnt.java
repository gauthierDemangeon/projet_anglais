package ants;

import core.Ant;
import core.AntColony;
import core.Containing;

/**
 * An Ant that defends other ants
 *
 * @author DEMANGEON POLIZZI
 */
public class BodyguardAnt extends Ant implements Containing {
	
	//private boolean containing;
	private Ant antcontained;

	/**
	 * Creates a new Bodyguard Ant
	 */
	public BodyguardAnt () {
		super(2,5,true) ; // armor, food, beeBlock
		antcontained = null;
		watersafe=false;
	}

	@Override
	public void action (AntColony colony) {
		if(antcontained!=null){
			antcontained.action(colony);
		}
	}
	
	public boolean getWaterState () {
		return watersafe;
	}
	
	@Override
	public boolean isEmpty() {
		if (antcontained==null) {
			return true;
		} else {
			return false;
		}	
	}

	@Override
	public boolean AddContenantInsect(Ant ant) {
		if (this.isEmpty()==false) { // Check if the current ant is not able to contain another ant
			System.out.println("Already containing a ant");
			return false;
		} else {
			System.out.println("Not containing any ant");
			antcontained=ant;
			return true;
		}
	}

	@Override
	public boolean RemoveContenantInsect() {
		if (this.isEmpty()==false) { // Also check if the current ant is not able to contain another ant
			antcontained=null;
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Ant GetContenantInsect() {
		return antcontained;
	}	

}
