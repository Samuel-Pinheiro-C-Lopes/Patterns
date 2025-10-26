package creational.prototype.tower_defense.implementations;

import creational.prototype.tower_defense.abstractions.Minion;
import creational.prototype.tower_defense.abstractions.Tower;

public class Cannon implements Tower {
	private Integer x;
	private Integer y;
	private Integer damage;
	
	public Cannon(final Cannon cannon) {
		this(cannon.damage);
	}

	public Cannon(Integer damage) {
		super();
		this.damage = damage;
		this.x = null;
		this.y = null;
	}

	@Override
	public void summon(Integer x, Integer y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public Integer getX() {
		return this.x;
	}
	
	@Override
	public Integer getY() {
		return this.y;
	}

	@Override
	public void attack(Minion minion) {
		minion.takeDamage(this.damage);
	}
	
	@Override
	public Cannon clone() {
		return new Cannon(this);
	}
}
