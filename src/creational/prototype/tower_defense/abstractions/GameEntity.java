package creational.prototype.tower_defense.abstractions;

public interface GameEntity extends Cloneable { 
	void summon(Integer x, Integer y);
	Integer getX();
	Integer getY();
}
