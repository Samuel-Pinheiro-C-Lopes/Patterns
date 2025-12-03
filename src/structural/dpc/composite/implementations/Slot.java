package structural.dpc.composite.implementations;

import java.util.ArrayList;
import java.util.List;

import structural.dpc.composite.interfaces.Equippable;

public class Slot implements Equippable {
	private final List<Equippable> equippables;
	private Integer level = Integer.valueOf(0);
	private Integer price = Integer.valueOf(0);
	
	public Slot() {
		this.equippables = new ArrayList<Equippable>();
	}

	public Slot addEquippable(final Equippable equippable) {
		this.equippables.add(equippable);
		return this;
	}
	
	@Override
	public Integer getLevelNeeded() {
		Integer level = this.level;
		
		for (final Equippable equippable : this.equippables)
			level += equippable.getLevelNeeded();
		
		return level;
	}

	@Override
	public Integer getPrice() {
		Integer price = this.price;
		
		for (final Equippable equippable : this.equippables)
			price += equippable.getPrice();
		
		return price;
	}
	
	@Override
	public Integer getDamageDealt() {
		Integer damage = this.level;
		
		for (final Equippable equippable : this.equippables)
			damage += equippable.getDamageDealt();
		
		return damage;
	}

	@Override
	public Integer getDefenceReceived() {
		Integer defence = this.level;
		
		for (final Equippable equippable : this.equippables)
			defence += equippable.getDefenceReceived();
		
		return defence;
	}

}
