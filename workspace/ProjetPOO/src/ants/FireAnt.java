package ants;

import core.AntColony;
import core.Ant;
import core.Bee;
import core.Place;

	public class FireAnt extends Ant {
		
		/**
		 * Creates a new Fire Ant.
		 * Armor: 1, Food: 4, Damage: 3
		 */
		public FireAnt () {
			super(1,4,true); //armor, food, beeBlock
			damage=3;
		}
		
		public void action(AntColony colony) {
			//This Ant does nothing
		}
		public void reduceArmor(int amount) {
			Place p = this.getPlace();
			super.reduceArmor(amount);
			if (this.armor <= 0) {
				BOUM(p.getBees());
			}
		}
		
		public void BOUM(Bee[] bees) {
			for(Bee b: bees) {
				System.out.println("armure :"+ b.getArmor());
				b.reduceArmor(damage);
			}
		}
		
		public boolean getWaterState () {
			return watersafe;
		}
}
