package creational.prototype.tower_defense.abstractions.engine;

public interface Player {
	Integer getHealth();
	Integer getCurrentLevel();
	void takeDamage(Integer damage);
	void increaseLevel();
}

