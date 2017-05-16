package ants;

import core.Ant;
import core.AntColony;
import core.Bee;

/**
 * An ant who throws leaves at bees
 *
 * @author DEMANGEON POLIZZI
 */
public class ThrowerAnt extends Ant {


	/**
	 * Creates a new Thrower Ant.
	 * Armor: 1, Food: 4, Damage: 1
	 */
	public ThrowerAnt () {
		super(1,4,true); // armor, food, beeBlock
		damage = 1;
	}

	/**
	 * Returns a target for this ant
	 *
	 * @return A bee to target
	 */
	public Bee getTarget () {
		return place.getClosestBee(0, 3);
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
