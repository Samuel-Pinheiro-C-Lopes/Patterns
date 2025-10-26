package creational.prototype.tower_defense.implementations;

import creational.prototype.tower_defense.abstractions.Minion;

public class Goblin implements Minion {
	private Integer y;
	private Integer x;
	private Integer size;
	
	public Goblin(Integer size) {
		super();
		this.size = size;
		this.x = null;
		this.y = null;
	}

	public Goblin(Goblin goblin) {
		this(goblin.size);
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
	public void move(Integer x, Integer y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public void takeDamage(Integer damage) {
		this.size -= damage;
	}
	
	@Override
	public Goblin clone() {
		return new Goblin(this);
	}
}
