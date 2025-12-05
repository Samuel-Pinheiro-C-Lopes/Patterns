package structural.composite.basichtmlgenerator;

import structural.composite.basichtmlgenerator.implementations.HtmlTag;
import structural.composite.basichtmlgenerator.interfaces.Component;
import structural.composite.basichtmlgenerator.implementations.Text;

public class App {
	private static void init(final Component component) { 
		component.show();
	}
	
	public static void main(final String args[]) { 
		init(
			new HtmlTag("div",
					new HtmlTag(
						"p", new Text("FUNCIONA")
					),
					new HtmlTag(
						"section",	
						new HtmlTag(
							"p", new Text("FUNCIONA")
						)),
					new HtmlTag(
						new HtmlTag(
								"p", new Text("FUNCIONA")
							),
						new HtmlTag(
							"section",	
							new HtmlTag(
								"p", new Text("FUNCIONA")
							))
					),
					new HtmlTag(
						"div",
						new HtmlTag(
							"p", new Text("FUNCIONA")
						)	
					)
			)
				
				
		);
	}
}