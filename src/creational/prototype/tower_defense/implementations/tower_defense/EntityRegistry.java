package creational.prototype.tower_defense.implementations.tower_defense;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import creational.prototype.tower_defense.abstractions.engine.GameEntity;
import creational.prototype.tower_defense.abstractions.engine.GameEntityRegistry;

public class EntityRegistry implements GameEntityRegistry {
	private Map<Integer, List<GameEntity>> entities;
	
	public EntityRegistry() {
		this.entities = new HashMap<Integer, List<GameEntity>>();
	}
	
	public void add(Integer level, List<GameEntity> entities) {
		if (!this.entities.containsKey(level)) 
			this.entities.put(level, entities);
		else
			this.entities.get(level).addAll(entities);
	}
	
	public void add(Integer level, GameEntity entity, Integer quantity) {
		if (!this.entities.containsKey(level))
			this.entities.put(level, new ArrayList<GameEntity>());
		
		List<GameEntity> entities = new ArrayList<GameEntity>();
		for (int i = 0; i < quantity; i++)
			entities.add(entity.clone());
		
		this.entities.get(level).addAll(entities);
	}

	@Override
	public List<GameEntity> getEntities(Integer level) {
		return this.entities.get(level)
				.stream()
				.map(e -> e.clone())
				.toList();
	}
	
}
