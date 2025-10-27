package creational.prototype.tower_defense.abstractions.engine;

import java.util.List;

public interface GameEntityRegistry {
	List<GameEntity> getEntities(Integer level);
}

