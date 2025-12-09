package structural.dpc.proxy.implementations;

import structural.dpc.composite.interfaces.Equippable;
import structural.dpc.composite.interfaces.Player;

public class GoldRequiredEquippable implements Equippable {
	private final Equippable equippable;
	private Player boughtBy;
	
	public GoldRequiredEquippable(final Equippable equippable) {
		this.equippable = equippable;
		this.boughtBy = null;
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
		Boolean canBuy = Integer.compare(player.getGold(), this.equippable.getPrice()) >= 0;
		
		if (canBuy.equals(Boolean.TRUE))
			this.boughtBy = player;
		
		return canBuy;
	}
	
	private void verifySelf() {
		if (boughtBy == null)
			throw new IllegalArgumentException("Not bought item can't be used.");
	}
}

