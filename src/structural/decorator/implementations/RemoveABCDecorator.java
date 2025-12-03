package structural.decorator.implementations;

import structural.decorator.interfaces.Component;
import structural.decorator.interfaces.Decorator;

/* removes all occurrences of A, B, C and D */
public class RemoveABCDecorator extends Decorator {
	public RemoveABCDecorator(Component component) {
		super(component);
	}

	@Override
	public String alterText(String text) {
		return this.component.alterText(text).replaceAll("[ABCD]", "");
	}

}
