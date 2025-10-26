package creational.prototype.tower_defense.abstractions;

public interface Minion extends GameEntity {
	void move(Integer X, Integer Y);
	void takeDamage(Integer damage);
	Minion clone();
}
