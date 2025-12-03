package structural.dpc.proxy.implementations;

import structural.dpc.composite.interfaces.Equippable;
import structural.dpc.composite.interfaces.Player;

public class GoldRequiredEquippable implements Equippable {
	private final Equippable equippable;
	
	public GoldRequiredEquippable(final Equippable equippable) {
		this.equippable = equippable;
	}
	
	@Override
	public Integer getLevelNeeded() {
		return this.equippable.getLevelNeeded();
	}

	@Override
	public Integer getDamageDealt() {
		return this.equippable.getDamageDealt();
	}

	@Override
	public Integer getDefenceReceived() {
		return this.equippable.getDefenceReceived();
	}

	@Override
	public Integer getPrice() {
		return this.equippable.getPrice();
	}
	
	@Override
	public Boolean canBeEquipped(final Player player) {
		return Integer.compare(player.getGold(), this.equippable.getPrice()) >= 0;
	}
}

