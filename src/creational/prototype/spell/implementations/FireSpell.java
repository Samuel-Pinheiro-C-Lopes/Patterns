package creational.prototype.spell.implementations;

import creational.prototype.spell.abstractions.Affectable;
import creational.prototype.spell.abstractions.NamedSpell;
import creational.prototype.spell.abstractions.Spell;

public class FireSpell implements Spell {
	private Integer damage;
	private Integer burnDamage;
	
	public FireSpell(Integer damage, Integer burnDamage) {
		super();
		this.damage = damage;
		this.burnDamage = burnDamage;
	}

	public FireSpell(FireSpell fireSpell) {
		this(fireSpell.damage, fireSpell.burnDamage);
	}
	
	@Override
	public void cast(Affectable target) {
		target.takeDamage(damage);
		target.takeBurn(burnDamage);
		
	}

	@Override
	public FireSpell clone() {
		return new FireSpell(this);
	}

}
