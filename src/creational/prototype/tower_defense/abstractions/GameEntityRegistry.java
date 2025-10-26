package creational.prototype.tower_defense.abstractions;

import creational.prototype.tower_defense.enums.MinionType;
import creational.prototype.tower_defense.enums.TowerType;

public interface GameEntityRegistry {
	Minion getMinion(MinionType type);
	Tower getTower(TowerType type);
}
