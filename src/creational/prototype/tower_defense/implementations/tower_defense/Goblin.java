package creational.prototype.tower_defense.implementations.tower_defense;

import java.util.List;

import creational.prototype.tower_defense.abstractions.engine.GameEntity;
import creational.prototype.tower_defense.abstractions.engine.Player;
import creational.prototype.tower_defense.abstractions.tower_defense.Minion;
import creational.prototype.tower_defense.abstractions.tower_defense.Path;

public class Goblin implements Minion {
	private final List<Path> paths;
	private Integer currentPathIndex;
	private Integer y;
	private Integer x;
	private Integer health;
	private Integer damage;
	
	public Goblin(Integer health, Integer damage, List<Path> paths) {
		super();
		this.paths = paths;
		this.health = health;
		this.damage = damage;
		this.currentPathIndex = null;
		this.x = null;
		this.y = null;
	}

	public Goblin(Goblin goblin) {
		this(goblin.health, goblin.damage, goblin.paths);
	}
	
	@Override
	public Goblin clone() {
		return new Goblin(this);
	}

	
	@Override
	public void move(Integer x, Integer y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public void act(GameEntity[][] mapEntities, Player player) {
		try {
			final Path currentPath;
			
			if (this.currentPathIndex >= this.paths.size()) {
				this.health = Integer.MIN_VALUE;
				return;
			}
			
			if (this.currentPathIndex == null) {
				currentPath = this.paths.getFirst();
				this.currentPathIndex = 0;
			} else {
				currentPath = this.paths.get(this.currentPathIndex);				
				this.currentPathIndex += 1;
			}
			
			if (currentPath.getMinion() != null)
				return;
			
			currentPath.setMinion(this);
			this.x = currentPath.getX();
			this.y = currentPath.getY();
			
			if (currentPath.getIsGoal() == Boolean.TRUE)
				player.takeDamage(damage);
			
		} catch (IndexOutOfBoundsException ex) {
			ex.printStackTrace();
		}
	}
	
	@Override
	public void takeDamage(Integer damage) {
		this.health -= damage;
	}

	@Override
	public Boolean getIsAlive() {
		return Boolean.valueOf(this.health > 0);
	}

	@Override
	public Boolean getIsAlly() {
		return Boolean.FALSE;
	}

	@Override
	public Integer getDamage() {
		return this.damage;
	}
	
	@Override
	public Integer getX() {
		return this.x;
	}
	
	@Override
	public Integer getY() {
		return this.y;
	}
}
