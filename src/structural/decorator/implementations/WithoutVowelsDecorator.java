package structural.decorator.implementations;

import structural.decorator.interfaces.Component;
import structural.decorator.interfaces.Decorator;

/* removes vowels */
public class WithoutVowelsDecorator extends Decorator {
	public WithoutVowelsDecorator(Component component) {
		super(component);
	}

	@Override
	public String alterText(String text) {
		return this.component.alterText(text).replaceAll("[AEIOUaeiou]", "");
	}
}
