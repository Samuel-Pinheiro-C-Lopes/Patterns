package structural.composite.basichtmlgenerator.implementations;

import java.util.ArrayList;
import java.util.List;

public class HtmlBuilder {
	private final HtmlTag rootTag;
	private HtmlTag currentTag;
	private List<HtmlTag> previousTags;
	
	public HtmlBuilder(final String rootTagName) {
		this.rootTag = new HtmlTag(rootTagName);
		this.currentTag = this.rootTag;
		this.previousTags = new ArrayList<HtmlTag>();
		this.previousTags.add(this.currentTag);
	}

	public HtmlBuilder addTagAndGo(String tag) {
		final HtmlTag toAddTag = new HtmlTag(tag);
		this.currentTag.add(toAddTag);
		this.currentTag = toAddTag;
		this.previousTags.add(this.currentTag);
		return this;
	}
	
	public HtmlBuilder addTag(String tag) {
		this.currentTag.add(new HtmlTag(tag));
		return this;
	}
	
	public HtmlBuilder addText(String text) {
		this.currentTag.add(new Text(text));
		return this;
	}
	
	public HtmlBuilder goToParent() {
		if (this.previousTags.size() > 1)
			this.previousTags.removeLast();
		
		this.currentTag = this.previousTags.getLast();
		
		return this;
	}
	
	public HtmlBuilder goToRoot() {
		this.currentTag = this.rootTag;
		return this;
	}
	
	public HtmlTag build() {
		return this.rootTag;
	}
}
