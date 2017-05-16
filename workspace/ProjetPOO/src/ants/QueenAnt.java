package ants;

import java.util.ArrayList;

import core.Ant;
import core.AntColony;
import core.Bee;
import core.Place;

/**
 * The Queen !
 *
 * @author DEMANGEON POLIZZI
 */
public class QueenAnt extends ScubaThrowerAnt {

	/**
	 * Creates the Queen !
	 * Armor: 1, Food: 6, Damage: 1
	 */
	static int nbQueen=0;
	boolean Imposteur=false;
	ArrayList<Ant> BoostedAnts= new ArrayList<Ant>();
	public QueenAnt () {
		super(); 
		foodCost+=1;
		erasable=false;
		nbQueen+=1;
		if(nbQueen>2){Imposteur=true;}
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
		if(!Imposteur)
		{
			colony.getQueenPlace().setQueenPlace(this.place);
			try
			{
				if(this.place.getExit().getAnt() != null && !(BoostedAnts.contains(this.place.getExit().getAnt()))) {
					BoostedAnts.add(this.place.getExit().getAnt());
					this.place.getExit().getAnt().setDamage(this.place.getExit().getAnt().getDamage()*2);
				}
			} catch(Exception e){}
			try
			{
				if(this.place.getEntrance().getAnt()!=null && !(BoostedAnts.contains(this.place.getEntrance().getAnt()))) {
					BoostedAnts.add(this.place.getEntrance().getAnt());
					this.place.getEntrance().getAnt().setDamage(this.place.getEntrance().getAnt().getDamage()*2);
				}
			} catch(Exception e){}
			
			Bee target = getTarget();
			if (target != null) {
				target.reduceArmor(damage);
			}
		}
		else 
		{
			this.reduceArmor(this.getArmor());
		}
	}
	
	public boolean getWaterState () {
		return watersafe;
	}
}
