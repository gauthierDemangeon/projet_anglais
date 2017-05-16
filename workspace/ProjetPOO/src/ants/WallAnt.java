package ants;

import core.Ant;
import core.AntColony;

/**
 * An Ant that do nothing but have a strong armor
 *
 * @author DEMANGEON POLIZZI
 */

public class WallAnt extends Ant {
	
	public WallAnt () {
		super(4,4,true); // armor, food, beeBlock
	}

	@Override
	public void action(AntColony colony) {
		// TODO Auto-generated method stub
		//There is nothing to do because the Ant does nothing
	}
	
	public boolean getWaterState () {
		return watersafe;
	}
}
