package creational.prototype.tower_defense;

import java.util.List;

import creational.prototype.tower_defense.abstractions.engine.GameEntity;
import creational.prototype.tower_defense.abstractions.engine.Player;
import creational.prototype.tower_defense.abstractions.engine.GameEntityRegistry;

import creational.prototype.tower_defense.abstractions.tower_defense.Tower;
import creational.prototype.tower_defense.abstractions.tower_defense.Minion;
import creational.prototype.tower_defense.abstractions.tower_defense.Path;
import creational.prototype.tower_defense.implementations.engine.CommonPlayer;
import creational.prototype.tower_defense.implementations.tower_defense.Cannon;
import creational.prototype.tower_defense.implementations.tower_defense.EntityRegistry;
import creational.prototype.tower_defense.implementations.tower_defense.Goblin;
import creational.prototype.tower_defense.implementations.tower_defense.Road;

public class Main {
	private static final Player player = new CommonPlayer(50);
	private static final GameEntity[][] entityMap = new GameEntity[10][10];
	
	public static void main(String[] args) {
		final EntityRegistry registry = new EntityRegistry();
		
		final List<Path> paths = List.of(
				new Road(0, 5),
				new Road(1, 5),
				new Road(2, 5),
				new Road(3, 5),
				new Road(4, 5),
				new Road(5, 5).asGoal()
			);
		
		final Minion minion = new Goblin(5, 5, paths);
		final Tower tower = new Cannon(10);
		
		registry.add(1, minion, 5);
		registry.add(1, tower, 2);
		
		registry.add(2, minion, 8);
		registry.add(2, minion, 3);
		
		// [...]
		
		init(registry);
	}
	
	public static void init(GameEntityRegistry registry) {
		List<GameEntity> entities;
		
		// level 1:
		entities = registry.getEntities(1);
		summon(entities);
		
		// level 2:
		entities = registry.getEntities(2);
		summon(entities);
		
		// [...]
	}
	
	private static void summon(List<GameEntity> entities) {
		for (final GameEntity entity : entities)
			summon(entity);
	}
	
	private static void summon(GameEntity entity) {
		final Integer x = entity.getX();
		final Integer y = entity.getY();
		
		if (x == null || y == null)
			return;
		
		entityMap[x][y] = entity;
	}
	
	private static void run(List<GameEntity> entities) {
		for (final GameEntity entity : entities) 
			run(entity);
	}
	
	private static void run(GameEntity entity) {
		entity.act(entityMap, player);
	}
}
