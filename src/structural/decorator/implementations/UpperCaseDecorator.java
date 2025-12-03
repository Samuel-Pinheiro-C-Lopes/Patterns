package structural.decorator.implementations;

import structural.decorator.interfaces.Component;
import structural.decorator.interfaces.Decorator;

/* changes all text to upper case */
public class UpperCaseDecorator extends Decorator {
	public UpperCaseDecorator(Component component) {
		super(component);
	}

	@Override
	public String alterText(String text) {
		return this.component.alterText(text).toUpperCase();
	}	
}
