package structural.composite.basichtmlgenerator.implementations;

import java.util.List;

import structural.composite.basichtmlgenerator.interfaces.Component;

public class Text implements Component{
	private String content;
	private Long tabulation;
	
	public Text(final String content) {
		this.content = content;
	}

	@Override
	public void add(Component component) { }

	@Override
	public void remove(Component component) { }

	@Override
	public List<Component> getChildren() {
		return null;
	}

	@Override
	public void show() {
		for(int i = 0; i < tabulation; i++)
			System.out.print("\t");
		System.out.println(this.content);
	}

	@Override
	public Component withTabulation(Long tabulation) {
		this.tabulation = tabulation;
		return this;
	}
}