package ants;

import core.Ant;
import core.AntColony;

/**
 * An Ant that harvests food
 *
 * @author DEMANGEON POLIZZI
 */
public class HarvesterAnt extends Ant {

	/**
	 * Creates a new Harvester Ant
	 */
	public HarvesterAnt () {
		super(1,2,true); // armor, food, beeBlock
	}

	@Override
	public void action (AntColony colony) {
		colony.increaseFood(1);
	}
	
	public boolean getWaterState () {
		return watersafe;
	}
}
