package creational;

public class FactoryMethod {
	private static void init(final Application app) { 
		final String previousContent = app.readFromDocument();
		app.AppendToDocument("Lorem ipsum dolor sit amet, consectetur adipiscing elit.");
		final String newContent = app.readFromDocument();
	}
	
	public static void main (String args[]) {
		init(new XMLApplication());
		init(new TextApplication());
		init(new JSONApplication());
	}
	
	private static interface Document {
		default void open() {
			System.out.println(this.getClass().getSimpleName() + " is being open!");
		}
		
		default void close() {
			System.out.println(this.getClass().getSimpleName() + " is being closed!");
		}
		
		default void write(String text) {
			System.out.println(this.getClass().getSimpleName() + " is being written!"
					+ " Content: " + text + ".");
		}
		
		default String read() {
			System.out.println(this.getClass().getSimpleName() + " is being read!");
			return new String();
		}
	}
	
	private static class Application {
		private final Document document;
		
		protected Application() {
			this.document = this.createDocument();
		}
		
		Document createDocument() {
			return new TextDocument();
		}
		
		public void AppendToDocument(String toAppend) {
			this.document.open();
			this.document.write(toAppend);
			this.document.close();
		}
		
		public String readFromDocument() {
			final String content;
			
			this.document.open();
			content = this.document.read();
			this.document.close();
			
			return content;
		}
	}
	
	private static class XMLDocument implements Document { }
	
	private static class TextDocument implements Document { }
	
	private static class JSONDocument implements Document { }
	
	private static class XMLApplication extends Application {
		@Override
		Document createDocument() {
			return new XMLDocument();
		}
	}
	
	private static class TextApplication extends Application {
		@Override
		Document createDocument() {
			return new TextDocument();
		}
	}
	
	private static class JSONApplication extends Application {
		@Override
		Document createDocument() {
			return new JSONDocument();
		}
	}
}
