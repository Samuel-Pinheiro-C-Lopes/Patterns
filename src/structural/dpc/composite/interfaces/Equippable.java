package structural.dpc.composite.interfaces;

public interface Equippable {
	Integer getLevelNeeded();
	Integer getDamageDealt();
	Integer getDefenceReceived();
	Integer getPrice();
	
	default Boolean canBeEquipped(final Player player) {
		return Boolean.TRUE;
	}
}
