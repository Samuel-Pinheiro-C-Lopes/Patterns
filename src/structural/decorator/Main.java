package structural.decorator;

import structural.decorator.implementations.ConcreteComponent;
import structural.decorator.implementations.RemoveABCDecorator;
import structural.decorator.implementations.UpperCaseDecorator;
import structural.decorator.implementations.WithoutVowelsDecorator;
import structural.decorator.interfaces.Component;

public class Main {
	private static void init(final Component component) {
		String text = "my test text!";
		System.out.println(text);
		System.out.println(component.alterText(text));
	}
	
	public static void main(final String[] args) {
		Component component = new ConcreteComponent();
		
		component = new RemoveABCDecorator(component);
		component = new WithoutVowelsDecorator(component);
		component = new UpperCaseDecorator(component);
		
		init(component);
	}
}
