package creational.prototype.tower_defense.implementations;

import java.util.HashMap;
import java.util.Map;

import creational.prototype.tower_defense.abstractions.GameEntityRegistry;
import creational.prototype.tower_defense.abstractions.Minion;
import creational.prototype.tower_defense.abstractions.Tower;
import creational.prototype.tower_defense.enums.MinionType;
import creational.prototype.tower_defense.enums.TowerType;

public class EntityRegistry implements GameEntityRegistry {
	private Map<MinionType, Minion> minions;
	private Map<TowerType, Tower> towers;
	
	public EntityRegistry() {
		this.minions = new HashMap<MinionType, Minion>();
		this.towers = new HashMap<TowerType, Tower>();
		
		this.minions.put(MinionType.GOBLIN, new Goblin(10));
		this.towers.put(TowerType.CANNON, new Cannon(2));
	}
	
	public void addMinion(MinionType type, Minion minion) {
		this.minions.putIfAbsent(type, minion);
	}
	
	@Override
	public Minion getMinion(MinionType type) {
		return this.minions.get(type);
	}
	
	public void addTower(TowerType type, Tower tower) {
		this.towers.putIfAbsent(type, tower);
	}
	
	@Override
	public Tower getTower(TowerType type) {
		return this.towers.get(type);
	}
}
