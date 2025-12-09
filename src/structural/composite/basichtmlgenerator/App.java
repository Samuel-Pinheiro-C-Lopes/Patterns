package structural.composite.basichtmlgenerator;

import java.io.PrintStream;

import structural.composite.basichtmlgenerator.implementations.HtmlBuilder;
import structural.composite.basichtmlgenerator.implementations.HtmlTag;
import structural.composite.basichtmlgenerator.implementations.IndentedPrintStream;
import structural.composite.basichtmlgenerator.interfaces.Component;

public class App {
	private static void init(final Component component) { 
		component.show();
	}
	
	public static void main(final String args[]) { 
		final PrintStream originalOut = System.out;
		
		System.setOut(new IndentedPrintStream(System.out));
		
		final HtmlTag tag = generateTag();
		
		init(tag);
		
		IndentedPrintStream.resetIdent();
		
		System.setOut(originalOut);
	}
	
	private static HtmlTag generateTag() {
		return new HtmlBuilder("body")
				.addTagAndGo("section")
					.addTagAndGo("header")
						.addTagAndGo("h1")
							.addText("first header")
							.goToParent()
						.goToParent()
					.addTagAndGo("p")
						.addText("first paragraph.")
						.goToParent()
					.addTagAndGo("p")
						.addText("second paragraph.")
						.goToRoot()
				.addTagAndGo("section")
					.addTagAndGo("section")
						.addTagAndGo("header")
							.addTagAndGo("h2")
								.addText("second header")
								.goToParent()
							.goToParent()
						.addTagAndGo("p")
							.addText("fourth paragraph")
							.goToParent()
						.addTagAndGo("section")
							.addTagAndGo("header")
								.addTagAndGo("h3")
									.addText("third header")
									.goToParent()
								.goToParent()
							.addTagAndGo("p")
								.addText("fourth paragraph")
								.goToParent()
							.goToParent()
						.addTagAndGo("section")
							.addTagAndGo("header")
							.addTagAndGo("h2")
								.addText("fourth header")
								.goToRoot()
					.addTagAndGo("footer")
						.addText("some footer")
		.build();
	}
}


