package creational.prototype.tower_defense.abstractions.engine;

public interface GameEntity extends Cloneable { 
	void act(GameEntity[][] mapEntities, Player player);
	Boolean getIsAlive();
	Boolean getIsAlly();
	Integer getX();
	Integer getY();
	GameEntity clone();
}


