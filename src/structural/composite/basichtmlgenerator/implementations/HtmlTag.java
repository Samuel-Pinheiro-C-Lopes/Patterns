package structural.composite.basichtmlgenerator.implementations;

import java.util.ArrayList;
import java.util.List;

import structural.composite.basichtmlgenerator.interfaces.Component;

public class HtmlTag implements Component {
	private List<Component> childs;
	private String tag;
	
	public HtmlTag(final String tag) {
		this.tag = tag;
		this.childs = new ArrayList<Component>();
	}
	
	@Override
	public void show() {
		System.out.println("<" + this.tag + ">");
		
		IndentedPrintStream.incrementIndent();
		
		for (final Component component : this.childs) 
			component.show();
		
		IndentedPrintStream.decrementIdent();
		
		System.out.println("</" + this.tag + ">");
	}

	public void add(Component component) { this.childs.add(component); }
	public void remove(Component component) { this.childs.remove(component); }
	public List<Component> getChildren() { return this.childs; }
}

