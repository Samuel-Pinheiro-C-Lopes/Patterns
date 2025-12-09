package structural.composite.basichtmlgenerator.implementations;

import structural.composite.basichtmlgenerator.interfaces.Component;

public class Text implements Component{
	private String content;
	
	public Text(final String content) {
		this.content = content;
	}

	@Override
	public void show() {
		System.out.println(this.content);
	}
}


