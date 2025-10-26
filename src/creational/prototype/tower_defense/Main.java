package creational.prototype.tower_defense;

import creational.prototype.tower_defense.abstractions.GameEntityRegistry;
import creational.prototype.tower_defense.abstractions.Minion;
import creational.prototype.tower_defense.abstractions.Tower;
import creational.prototype.tower_defense.enums.MinionType;
import creational.prototype.tower_defense.enums.TowerType;
import creational.prototype.tower_defense.implementations.EntityRegistry;

public class Main {
	public static void init(GameEntityRegistry registry) {
		Minion firstM = registry.getMinion(MinionType.GOBLIN);
		Minion secondM = registry.getMinion(MinionType.GOBLIN);

		Tower firstT = registry.getTower(TowerType.CANNON);
		
		firstM.summon(1, 5);
		secondM.summon(2, 5);
		
		firstT.summon(3, 4);
		
		// ...
		
		firstM.move(1, 0);
		secondM.move(1, 0);
		
		// ...
		
		firstT.attack(firstM);
		firstT.attack(secondM);
		
		// ...
		
		System.out.println("finished");
	}
	
	public static void main(String[] args) {
		final EntityRegistry registry = new EntityRegistry();
		
		init(registry);
	}
}
