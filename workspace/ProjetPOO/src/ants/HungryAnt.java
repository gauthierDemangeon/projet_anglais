package ants;

import core.AntColony;
import core.Ant;
import core.Bee;

	public class HungryAnt extends Ant {
		private int tmp=3;
	
		public HungryAnt () {
			super(1,4,true); // armor, food, beeBlock
		}
	
		public Bee getTarget () {
			return place.getClosestBee(0,0);
		}
		
		public void action(AntColony colony) {
			Bee target = getTarget();
			if (target != null && tmp>3) {
				target.reduceArmor(target.getArmor());
				tmp=0;
			} else {
				tmp++;
			}
		}
		
		public boolean getWaterState () {
			return watersafe;
		}
}
