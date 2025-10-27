package creational.prototype.spell.implementations;

import creational.prototype.spell.abstractions.Affectable;
import creational.prototype.spell.abstractions.Spell;

public class IceSpell implements Spell {
	private Integer damage;
	private Boolean stuns;
	private Boolean slows;

	public IceSpell(Integer damage, Boolean stuns, Boolean slows) {
		super();
		this.damage = damage;
		this.stuns = stuns;
		this.slows = slows;
	}

	public IceSpell(IceSpell iceSpell) {
		this(iceSpell.damage, iceSpell.stuns, iceSpell.slows);
	}

	@Override
	public void cast(Affectable target) {
		target.takeDamage(damage);
		
		if (this.stuns)
			target.takeStun();
		
		if (this.slows)
			target.takeSlow();
	}
	
	@Override
	public IceSpell clone() {
		return new IceSpell(this);
	};

}
