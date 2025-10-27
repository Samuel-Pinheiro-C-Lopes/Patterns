package creational.prototype.tower_defense.implementations.tower_defense;

import creational.prototype.tower_defense.abstractions.engine.GameEntity;
import creational.prototype.tower_defense.abstractions.engine.Player;
import creational.prototype.tower_defense.abstractions.tower_defense.Minion;
import creational.prototype.tower_defense.abstractions.tower_defense.Tower;

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

	// attacks the column 
	@Override
	public void act(GameEntity[][] mapEntities, Player player) {
		try {
			for (final GameEntity entity : mapEntities[this.getX()])
				if (entity instanceof Minion)
					((Minion) entity).takeDamage(damage);
		} catch (IndexOutOfBoundsException ex) {
			ex.printStackTrace();
		}	
	}

	@Override
	public Boolean getIsAlive() {
		return Boolean.TRUE;
	}

	@Override
	public Boolean getIsAlly() {
		return Boolean.TRUE;
	}
}
