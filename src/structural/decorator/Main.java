package structural.decorator;

import structural.decorator.implementations.ConcreteComponent;
import structural.decorator.implementations.RemoveABCDecorator;
import structural.decorator.implementations.UpperCaseDecorator;
import structural.decorator.implementations.WithoutVowelsDecorator;
import structural.decorator.interfaces.Component;

public class Main {
	private static void init(final Component component) {
		String text = ""
				+ "Lorem ipsum dolor sit amet, "
				+ "consectetur adipiscing elit. "
				+ "Nullam vulputate vel arcu sit "
				+ "amet feugiat. Integer ac urna "
				+ "sed elit suscipit facilisis";
		System.out.println(text);
		System.out.println(component.alterText(text));
	}
	
	public static void main(final String[] args) {
		Component initialComponent = new ConcreteComponent();
		
		Component componentA1 = new UpperCaseDecorator(initialComponent);
		Component componentA2 = new RemoveABCDecorator(componentA1);
		Component componentA3 = new WithoutVowelsDecorator(componentA2);
		init(componentA3);
		
		Component componentB1 = new WithoutVowelsDecorator(initialComponent);
		Component componentB2 = new UpperCaseDecorator(componentB1);
		init(componentB2);
		
		Component componentC1 = new RemoveABCDecorator(initialComponent);
		init(componentC1);
	}
}
