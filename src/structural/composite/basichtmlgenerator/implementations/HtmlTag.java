package structural.composite.basichtmlgenerator.implementations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import structural.composite.basichtmlgenerator.interfaces.Component;

public class HtmlTag implements Component {
	private List<Component> childs;
	private String tag;
	private Long tabulation;
	
	public HtmlTag() {
		this.tabulation = 0l;
		this.tag = "div";
		this.childs = new ArrayList<Component>();
	}
	
	public HtmlTag(final String tag) {
		this();
		this.tag = tag;
	}
	
	public HtmlTag(final Component... childs) {
		this();
		this.childs = Arrays.asList(childs);
	}
	
	public HtmlTag(final List<Component> childs) {
		this();
		this.childs = childs;
	}
	
	public HtmlTag(final String tag, final List<Component> childs) {
		this(tag);
		this.childs = childs;
	}
	
	public HtmlTag(final String tag, final Component... childs) {
		this(tag);
		this.childs = Arrays.asList(childs);
	}
	
	public HtmlTag(final String tag, final Long tabulation) {
		this(tag);
		this.tabulation = tabulation;
	}
	
	@Override
	public void show() {
		for(int i = 0; i < tabulation; i++)
			System.out.print("\t");
		System.out.println("<" + this.tag + ">");
		for (final Component component : this.childs) {
			component.withTabulation(tabulation + 1);
			component.show();
		}
		for(int i = 0; i < tabulation; i++)
			System.out.print("\t");
		System.out.println("</" + this.tag + ">");
	}

	@Override
	public void add(Component component) {
		this.childs.add(component);
	}

	@Override
	public void remove(Component component) {
		this.childs.remove(component);
	}

	@Override
	public List<Component> getChildren() {
		return this.childs;
	}

	@Override
	public Component withTabulation(Long tabulation) {
		this.tabulation = tabulation;
		return this;
	}
}