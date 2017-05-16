package ants;

import core.Ant;
import core.AntColony;
import core.Bee;

/**
 * An ant who throws leaves at bees
 *
 * @author DEMANGEON POLIZZI
 */
public class LongThrowerAnt extends ThrowerAnt {


	/**
	 * Creates a new Long Thrower Ant.
	 * Armor: 1, Food: 3, Damage: 1
	 */
	public LongThrowerAnt () {
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
		return place.getClosestBee(4, 10);
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
