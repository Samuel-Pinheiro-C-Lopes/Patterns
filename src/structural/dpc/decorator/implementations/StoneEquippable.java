package structural.dpc.decorator.implementations;

import structural.dpc.composite.interfaces.Equippable;

public class StoneEquippable implements Equippable {
	private final Equippable equippable;
	
	public StoneEquippable(final Equippable equippable) {
		this.equippable = equippable;
	}
	
	@Override
	public Integer getLevelNeeded() {
		return this.equippable.getLevelNeeded();
	}

	@Override
	public Integer getDamageDealt() {
		return this.equippable.getDamageDealt() / 2;
	}

	@Override
	public Integer getDefenceReceived() {
		return this.equippable.getDefenceReceived() * 2;
	}

	@Override
	public Integer getPrice() {
		return this.equippable.getPrice() / 2;
	}
}


