package structural.decorator.implementations;

import structural.decorator.interfaces.Component;

/* will just remove white spaces */
public class ConcreteComponent implements Component {
	@Override
	public String alterText(String text) {
		return text.replaceAll("\\s", "");
	}
}

