package creational.prototype.tower_defense.implementations.engine;

import creational.prototype.tower_defense.abstractions.engine.Player;

public class CommonPlayer implements Player {
	private Integer health;
	private Integer currentLevel;
	
	public CommonPlayer(Integer initialHealth) {
		this.health = initialHealth;
		this.currentLevel = 1;
	}
	
	@Override
	public void takeDamage(Integer damage) {
		this.health -= damage;
	}

	@Override
	public Integer getHealth() {
		return this.health;
	}

	@Override
	public Integer getCurrentLevel() {
		return this.currentLevel;
	}

	@Override
	public void increaseLevel() {
		this.health++;
		
	}

}
