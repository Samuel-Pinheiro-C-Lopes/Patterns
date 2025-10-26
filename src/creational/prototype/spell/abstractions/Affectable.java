package creational.prototype.spell.abstractions;

public interface Affectable {
	void takeStun();
	void takeDamage(Integer damage);
	void takeBurn(Integer damage);
	void takeSlow();
	void recoverFromSlow();
	void recoverFromStun();
}