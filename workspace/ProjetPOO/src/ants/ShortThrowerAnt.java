package ants;

import core.Ant;
import core.AntColony;
import core.Bee;

/**
 * An ant who throws leaves at near bees 
 *
 * @author DEMANGEON POLIZZI
 */
public class ShortThrowerAnt extends ThrowerAnt {


	/**
	 * Creates a new Short Thrower Ant.
	 * Armor: 1, Food: 3, Damage: 1
	 */
	public ShortThrowerAnt () {
		super(); // armor, food, beeBlock
		foodCost = 3;
		damage = 1;
	}

	/**
	 * Returns a target for this ant
	 *
	 * @return A bee to target
	 */
	public Bee getTarget () {
		return place.getClosestBee(0, 2);
	}

	@Override
	public void action (AntColony colony) {
		Bee target = getTarget();
		if (target != null) {
			target.reduceArmor(damage);
		}
	}
	
	public boolean getWaterState () {
		return watersafe;
	}
}
