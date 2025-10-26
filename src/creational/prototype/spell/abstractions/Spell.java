package creational.prototype.spell.abstractions;

public interface Spell extends Cloneable {
	void cast(Affectable target);
	Spell clone();
}
