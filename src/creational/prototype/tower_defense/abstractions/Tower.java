package creational.prototype.tower_defense.abstractions;

public interface Tower extends GameEntity {
	void attack(Minion minion);
	Tower clone();
}