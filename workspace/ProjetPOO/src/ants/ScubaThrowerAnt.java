package ants;


import core.Ant;
import core.AntColony;
import core.Bee;

/**
 * An ant who throws leaves at bees underwater !
 *
 * @author DEMANGEON POLIZZI
 */
public class ScubaThrowerAnt extends Ant {


	/**
	 * Creates a new Scuba Thrower Ant.
	 * Armor: 1, Food: 5, Damage: 1
	 */
	
	public ScubaThrowerAnt () {
		super(1,5,true); //armor, food, beeBlock
		damage = 1;
		watersafe=true;
	}
	
	public boolean getWaterState () {
		return watersafe;
	}

	/**
	 * Returns a target for this ant
	 *
	 * @return A bee to target
	 */
	public Bee getTarget () {
		return place.getClosestBee(0, 3);
	}

	public void action (AntColony colony) {
		Bee target = getTarget();
		if (target != null) {
			target.reduceArmor(damage);
		}
	}
}