package creational.prototype.tower_defense.abstractions.tower_defense;

import creational.prototype.tower_defense.abstractions.engine.GameEntity;

public interface Tower extends GameEntity {
	void attack(Minion minion);
	Tower clone();
}

