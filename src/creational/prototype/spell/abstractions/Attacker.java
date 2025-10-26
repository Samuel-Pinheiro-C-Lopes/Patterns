package creational.prototype.spell.abstractions;

public interface Attacker {
	void attack(Affectable target);
	Boolean canAttack();
}
