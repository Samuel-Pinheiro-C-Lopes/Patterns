package creational.prototype.tower_defense.abstractions.tower_defense;

import creational.prototype.tower_defense.abstractions.engine.GameEntity;

public interface Minion extends GameEntity {
	void move(Integer X, Integer Y);
	void takeDamage(Integer damage);
	Integer getDamage();
	Minion clone();
}

