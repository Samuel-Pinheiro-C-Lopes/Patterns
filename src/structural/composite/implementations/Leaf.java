package structural.composite.implementations;

import structural.composite.interfaces.Component;

public class Leaf implements Component {
	private final Integer cost;
	
	public Leaf(final Integer cost) {
		this.cost = cost;
	}
	
	@Override
	public Integer sum() {
		return cost;
	}

}
