package structural.composite.implementations;

import java.util.ArrayList;
import java.util.List;

import structural.composite.interfaces.Component;

public class Composite implements Component {
	private final List<Component> children;
	private final Integer cost;
	
	public Composite(final Integer cost) {
		this.children = new ArrayList<Component>();
		this.cost = cost;
	}
	
	@Override
	public Integer sum() {
		Integer sum = Integer.valueOf(0);
		
		for (final Component child : this.children)
			sum = Integer.sum(sum.intValue(), child.sum().intValue());
		
		return Integer.sum(sum.intValue(), this.cost);
	}
	
	public Composite addChild(final Component component) {
		this.children.add(component);
		return this;
	}
	
	public void removeChildren() {
		this.children.clear();
	}
	
	public List<Component> getChildren() {
		return this.children;
	}
}
