package structural.dpc.composite.implementations;

import structural.dpc.composite.interfaces.Equippable;

public class Item implements Equippable{
	private Integer level = Integer.valueOf(0);
	private Integer damage = Integer.valueOf(0);
	private Integer price = Integer.valueOf(0);
	private Integer defence = Integer.valueOf(0);
	
	@Override
	public Integer getLevelNeeded() {
		return this.level;
	}

	@Override
	public Integer getDamageDealt() {
		return this.damage;
	}

	@Override
	public Integer getPrice() {
		return this.price;
	}

	@Override
	public Integer getDefenceReceived() {
		return defence;
	}

}
