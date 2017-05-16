package ants;

import core.Ant;
import core.Bee;
import core.AntColony;

public class StunAnt extends Ant{

	public StunAnt() {
		super(1,6,true);
	}

	@Override
	public void action(AntColony colony) {
		if(this.place.getBees().length != 0) {
			this.place.getBees()[0].SetStunState(true);
		}
	}
	
	public boolean getWaterState () {
		return watersafe;
	}
}