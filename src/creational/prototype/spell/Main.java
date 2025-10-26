package creational.prototype.spell;

import creational.prototype.spell.abstractions.Spell;
import creational.prototype.spell.implementations.FireSpell;
import creational.prototype.spell.implementations.IceSpell;
import creational.prototype.spell.implementations.Mage;

public class Main {	
	public static void main(String[] args) {
		// preparing spells
		Spell fireBall = new FireSpell(10, 5);
		Spell fireArrow = new FireSpell(20, 0);
		Spell fireHand = new FireSpell(5, 25);
		Spell iceSpear = new IceSpell(20, Boolean.FALSE, Boolean.FALSE);
		Spell iceStorm = new IceSpell(5, Boolean.TRUE, Boolean.FALSE);
		Spell iceHand = new IceSpell(0, Boolean.TRUE, Boolean.TRUE);
		
		// preparing mages
		Mage rightMage = new Mage(50, 10);
		Mage leftMage = new Mage(35, 15);
		
		// fight!!!
		init();
	}

	private static void init() {
		
	}
}
