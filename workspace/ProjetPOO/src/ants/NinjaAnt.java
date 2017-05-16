package ants;

import core.Ant;
import core.AntColony;
import core.Bee;

/**
 * An Ant that kicks asses
 *
 * @author DEMANGEON POLIZZI
 */
public class NinjaAnt extends Ant {


	/**
	 * Creates a new Ninja Ant
	 */
	public NinjaAnt () {
		super(1,6,false); // armor, food, beeBlock
		damage=1;
	}

	public Bee getTarget () {
		return place.getClosestBee(0, 0);
	}
	
	public void action (AntColony colony) {
		Bee target = getTarget();
		if (target != null) {
			target.reduceArmor(damage);
		}
		System.out.println("damage " + damage);
	}
	
	public boolean getWaterState () {
		return watersafe;
	}
}