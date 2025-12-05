package structural.composite.summable;

import structural.composite.summable.implementations.Composite;
import structural.composite.summable.implementations.Leaf;
import structural.composite.summable.interfaces.Component;

public class Main {
	private static void init(final Component component) {
		System.out.println("Sum: " + component.sum().toString() + ".");
	}
	
	public static void main(final String args[]) {
		final Composite A1 = new Composite(10);
		final Composite B1 = new Composite(5);
		final Composite B2 = new Composite(15);
		final Leaf B3 = new Leaf(20);
		A1.addChild(B1).addChild(B2).addChild(B3);
		
		final Leaf C1 = new Leaf(10);
		final Leaf C2 = new Leaf(15);
		B1.addChild(C1).addChild(C2);
		
		final Leaf D1 = new Leaf(20);
		final Composite D2 = new Composite(5);
		B2.addChild(D1).addChild(D2);
		
		final Leaf E1 = new Leaf(5);
		D2.addChild(E1);
		
		init(A1);
		init(B1);
		init(E1);
	}
}
