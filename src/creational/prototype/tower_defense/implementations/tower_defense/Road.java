package creational.prototype.tower_defense.implementations.tower_defense;

import creational.prototype.tower_defense.abstractions.tower_defense.Minion;
import creational.prototype.tower_defense.abstractions.tower_defense.Path;

public class Road implements Path {
	private final Integer x;
	private final Integer y;
	private Minion minion;
	private Boolean isGoal;
	
	public Road(Integer x, Integer y) {
		this.isGoal = Boolean.FALSE;
		this.x = x;
		this.y = y;
		this.minion = null;
	}
	
	public Road(final Road road) {
		this(road.x, road.y);
	}
	
	public Road asGoal() {
		this.isGoal = Boolean.TRUE;
		return this;
	}

	@Override
	public Integer getX() {
		return this.x;
	}

	@Override
	public Integer getY() {
		return this.y;
	}

	@Override
	public Minion getMinion() {
		return this.minion;
	}

	@Override
	public void setMinion(final Minion minion) {
		this.minion = minion;
	}

	@Override
	public Boolean getIsGoal() {
		return this.isGoal;
	}
}
