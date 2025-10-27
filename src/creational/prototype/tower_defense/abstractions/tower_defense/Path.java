package creational.prototype.tower_defense.abstractions.tower_defense;

public interface Path {
	void setMinion(Minion minion);
	Minion getMinion();
	Boolean getIsGoal();
	Integer getX();
	Integer getY();
}

