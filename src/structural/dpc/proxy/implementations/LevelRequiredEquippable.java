package structural.dpc.proxy.implementations;

import structural.dpc.composite.interfaces.Equippable;
import structural.dpc.composite.interfaces.Player;

public class LevelRequiredEquippable implements Equippable {
	private final Equippable equippable;
	private Player obtainedBy;
	
	public LevelRequiredEquippable(final Equippable equippable) {
		this.equippable = equippable;
		obtainedBy = null;
	}
	
	@Override
	public Integer getLevelNeeded() {
		this.verifySelf();
		return this.equippable.getLevelNeeded();
	}
	@Override
	public Integer getDamageDealt() {
		this.verifySelf();
		return this.equippable.getDamageDealt();
	}
	@Override
	public Integer getDefenceReceived() {
		this.verifySelf();
		return this.equippable.getDefenceReceived();
	}
	@Override
	public Integer getPrice() {
		this.verifySelf();
		return this.equippable.getPrice();
	}
	@Override
	public Boolean buy(final Player player) {
		Boolean canBuy = Integer.compare(player.getLevel(), this.equippable.getLevelNeeded()) >= 0;
		
		if (canBuy.equals(Boolean.TRUE))
			this.obtainedBy = player;
		
		return canBuy;
	}
	
	private void verifySelf() {
		if (obtainedBy == null)
			throw new IllegalArgumentException("Not obtained item can't be used.");
	}
}
