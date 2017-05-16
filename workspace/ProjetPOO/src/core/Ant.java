package core;

/**
 * A class representing a basic Ant
 *
 * @author DEMANGEON POLIZZI
 */
public abstract class Ant extends Insect {

	protected int foodCost; // the amount of food needed to make this ant
	protected boolean beeBlocked;
	protected int damage;
	/**
	 * Creates a new Ant, with a food cost of 0.
	 *
	 * @param armor
	 *            The armor of the ant.
	 */
	public Ant (int armor,int food, boolean block) {
		super(armor, null);
		foodCost = food;
		beeBlocked = block;
	}

	/**
	 * Returns the ant's food cost
	 *
	 * @return the ant's good cost
	 */
	public int getFoodCost () {
		return foodCost;
	}

	/**
	 * Removes the ant from its current place
	 */
	@Override
	public void leavePlace () {
		place.removeInsect(this);
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public int getDamage() {
		return damage; 
	}
	
	public void setDamage(int dmg) {
		damage = dmg;
	}
	
	
	
}
