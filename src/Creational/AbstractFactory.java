package Creational;

public class AbstractFactory {
	
	public static void main (String args[]) {
		// Defining the factory
		init(new LightFactory());
		/*
		init(new DarkFactory());
		init(new SolarizedFactory()); 
		*/
	}
	
	// Client
	
	private static void init(final UIFactory factory) {
		final Window window = factory.createWindow();
		final Scrollbar scrollbar = factory.createScrollbar();
		final Button button = factory.createButton();
		
		window.show();
		scrollbar.scroll();
		button.click();
	}
	
	// Interfaces
	
	public interface Window { 
		default void show() {
			System.out.println(this.getClass().getSimpleName() + " is being showed!");
		}
	}
	
	public interface Scrollbar {
		default void scroll() {
			System.out.println(this.getClass().getSimpleName() + " is being scrolled!");
		}
	}
	
	public interface Button {
		default void click() {
			System.out.println(this.getClass().getSimpleName() + " is being clicked!");
		}
	}
	
	public interface UIFactory {
		Window createWindow();
		Scrollbar createScrollbar();
		Button createButton();
	}
	
	// Solarized flavor
	
	private static class SolarizedWindow implements Window { }
	
	private static class SolarizedScrollbar implements Scrollbar { }
	
	private static class SolarizedButton implements Button { }
	
	private static class SolarizedFactory implements UIFactory {
		@Override
		public Window createWindow() {
			return new SolarizedWindow();
		}

		@Override
		public Scrollbar createScrollbar() {
			return new SolarizedScrollbar();
		}

		@Override
		public Button createButton() {
			return new SolarizedButton();
		}
	}
	
	// Dark flavor
	
	private static class DarkWindow implements Window { }
	
	private static class DarkScrollbar implements Scrollbar { }
	
	private static class DarkButton implements Button { }
	
	private static class DarkFactory implements UIFactory {
		@Override
		public Window createWindow() {
			return new DarkWindow();
		}

		@Override
		public Scrollbar createScrollbar() {
			return new DarkScrollbar();
		}

		@Override
		public Button createButton() {
			return new DarkButton();
		}
	}	
	
	// Light flavor
	private static class LightWindow implements Window { }
	
	private static class LightScrollbar implements Scrollbar { }
	
	private static class LightButton implements Button { }
	
	private static class LightFactory implements UIFactory {
		@Override
		public Window createWindow() {
			return new LightWindow();
		}

		@Override
		public Scrollbar createScrollbar() {
			return new LightScrollbar();
		}

		@Override
		public Button createButton() {
			return new LightButton();
		}
	}
}
