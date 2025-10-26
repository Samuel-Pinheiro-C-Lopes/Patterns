package creational.prototype.spell.implementations;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import creational.prototype.spell.abstractions.Affectable;
import creational.prototype.spell.abstractions.Attacker;
import creational.prototype.spell.abstractions.Fighter;
import creational.prototype.spell.abstractions.Spell;

public class Mage implements Fighter {
	private List<Spell> spells;
	private List<Spell> castedSpells;
	private Integer healthPoints;
	private Integer fireResistance;
	private Boolean stunned;
	private Boolean slowed;
	
	public Mage(Integer healthPoints, Integer fireResistance) {
		this.healthPoints = healthPoints;
		this.fireResistance = fireResistance;
		
		this.stunned = Boolean.FALSE;
		this.slowed = Boolean.FALSE;
		
		this.spells = new ArrayList<Spell>();
		this.castedSpells = new ArrayList<Spell>();
	}
	
	public Boolean learnSpell(final Spell spell) {
		return this.spells.add(spell);
	}
	
	@Override
	public void attack(Affectable target) {
		if (!this.canAttack())
			return;
		
		if (this.spells.size() == 0) {
			this.spells.addAll(castedSpells);
			this.castedSpells.clear();
		}
		
		final Spell currentSpell = this.spells.getFirst();
		
		try {
			if (this.slowed) 
				castSlow(currentSpell, target);
			else 
				castFast(currentSpell, target);
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
		
		this.castedSpells.add(currentSpell);
		this.spells.remove(currentSpell);
	}
	
	@Override
	public Boolean canAttack() {
		return this.canFight() && !this.stunned;
	}
	
	@Override
	public void recoverFromSlow() {
		this.slowed = Boolean.FALSE;
	}
	
	@Override
	public void recoverFromStun() {
		this.stunned = Boolean.FALSE;
	}
	
	@Override
	public void takeStun() {
		this.stunned = Boolean.TRUE;
	}

	@Override
	public void takeDamage(final Integer damage) {
		this.healthPoints -= damage;
		
	}

	@Override
	public void takeBurn(final Integer damage) {
		int damageToTake = damage - this.fireResistance;
		
		if (damageToTake > 0)
			this.healthPoints -= damageToTake;
	}

	@Override
	public void takeSlow() {
		this.slowed = Boolean.TRUE;
		
	}
	
	private void castSlow(final Spell spell, final Affectable target) throws InterruptedException {
		Thread.sleep(Duration.ofSeconds(2l));
		spell.cast(target);
	}
	
	private void castFast(final Spell spell, final Affectable target) throws InterruptedException {
		Thread.sleep(Duration.ofSeconds(1l));
		spell.cast(target);
	}

	@Override
	public Boolean canFight() {
		return this.healthPoints > 0;
	}
}
