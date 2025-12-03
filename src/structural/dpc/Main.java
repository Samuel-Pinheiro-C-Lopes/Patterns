package structural.dpc;

import structural.dpc.composite.implementations.Item;
import structural.dpc.composite.implementations.Slot;
import structural.dpc.composite.interfaces.Equippable;
import structural.dpc.decorator.implementations.DoubleDamageEquippable;
import structural.dpc.decorator.implementations.StoneEquippable;
import structural.dpc.proxy.implementations.LevelRequiredEquippable;

public class Main {
	private static void init(Equippable equippable) {
		System.out.println(equippable.getDamageDealt());
		System.out.println(equippable.getDefenceReceived());
		System.out.println(equippable.getLevelNeeded());
		System.out.println(equippable.getPrice());
	}
	
	// #TODO inicializar atributos de modo parametrizável...
	public static void main(final String[] args) {
		final Slot gauntlet = new Slot();
		final Equippable shield = new StoneEquippable(new Item());
		final Equippable spikes = new DoubleDamageEquippable(new Item());
		gauntlet.addEquippable(shield).addEquippable(spikes);
		final Slot ring = new Slot();
		gauntlet.addEquippable(ring);
		final Equippable fireShard = new Item();
		final Equippable magicOrb = new DoubleDamageEquippable(new Item());
		ring.addEquippable(fireShard).addEquippable(magicOrb);
		
		init(new LevelRequiredEquippable(gauntlet));
	}
}
