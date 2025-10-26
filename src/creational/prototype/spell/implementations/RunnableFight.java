package creational.prototype.spell.implementations;

import creational.prototype.spell.abstractions.Fighter;

public class RunnableFight implements Runnable {
	private Fighter right;
	private Fighter left;
	private Boolean rightFirst;
	
	public RunnableFight(final Fighter right, final Fighter left) {
		this.right = right;
		this.left = left;
		this.rightFirst = Boolean.TRUE;
	}
	
	public RunnableFight(final Fighter right, final Fighter left, final Boolean rightFirst) {
		this(right, left);
		this.rightFirst = rightFirst;
	}
	
	@Override
	public void run() {
		while(right.canFight() && left.canAttack()) {
			if (rightFirst) {
				right.attack(left);
				left.attack(right);
				
				right.recoverFromSlow();
			} else {
				left.attack(right);
				right.attack(left);
				
				left.recoverFromSlow();
			} 	
			
			right.recoverFromStun();
			left.recoverFromStun();
			
			rightFirst = !rightFirst;
		}
		
		if (!right.canFight() && !left.canFight())
			System.out.println("DRAW!");
		else if (!right.canFight())
			System.out.println("RIGHT WON!");
		else if (!left.canFight())
			System.out.println("LEFT WON!");
		
		System.out.println("The fight is over...");
	}

}
