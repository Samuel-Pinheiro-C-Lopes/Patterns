package creational;

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
	
	///
	/////////////////////////////////////////////////
	// ABSTRACT FACTORY com elementos gráficos de UI
	/////////////////////////////////////////////////
	///
	public static void init1(final DisplayFactory factory) {
		final Mouse mouse = factory.createMouse();
		final Window window = factory.createWindow();
		mouse.click();
		window.show();
	}
	
	public static void main1(String[] args) {
		// aqui a gente coloca a factory certa...
		//init(new MotifFactory()); 
		init1(new BMFactory());
	}
	
	
	private static interface Window1 {
		default void show() {
			System.out.println(this.getClass().getSimpleName() + " is showing!");
		}
	}
	
	private static interface Mouse {
		default void click() {
			System.out.println(this.getClass().getSimpleName() + " is clicking!");
		}
	}
	
	private static interface DisplayFactory {
		Window createWindow();
		Mouse createMouse();
	}
	
	private static class MotifWindow implements Window { }
	
	private static class MotifMouse implements Mouse { }
	
	private static class BMWindow implements Window { }
	
	private static class BMMouse implements Mouse { }
	
	private static class MotifFactory implements DisplayFactory {
		@Override
		public Window createWindow() {
			return new MotifWindow();
		}
		
		@Override
		public Mouse createMouse() {
			return new MotifMouse();
		}
	}
	
	private static class BMFactory implements DisplayFactory {
		@Override
		public Window createWindow() {
			return new BMWindow();
		}
		
		@Override
		public Mouse createMouse() {
			return new BMMouse();
		}
	}
	///
	/////////////////////////////////////////////////
	// ABSTRACT FACTORY com drivers
	/////////////////////////////////////////////////
	///
	
	private static void init2(final DriverFactory factory) {
		final AudioDriver audio = factory.provideAudioDriver();
		final VideoDriver video = factory.provideVideoDriver();
		audio.provideAudio();
		video.provideVideo();
	}
	
	public static void main2(String args[]) {
		AbstractFactory.init2(new LowRequerimentDriverFactory());
	}
	
	// DRIVERS INTERFACE
	
	private static interface AudioDriver {
		default void provideAudio() {
			System.out.println(this.getClass().getSimpleName() + " is being used for AUDIO!");
		}
	}
	
	private static interface VideoDriver {
		default void provideVideo() {
			System.out.println(this.getClass().getSimpleName() + " is being used for VIDEO!");
		}
		
	}
	
	// FACTORY INTERFACE
	
	private static interface DriverFactory {
		public abstract AudioDriver provideAudioDriver();
		public abstract VideoDriver provideVideoDriver();
	}
	
	// DRIVERS IMPLEMENTATIONS
	
	private static class HighQualityAudioDriver implements AudioDriver { }
	
	private static class HighQualityVideoDriver implements VideoDriver { }
	
	private static class LowQualityAudioDriver implements AudioDriver { }
	
	private static class LowQualityVideoDriver implements VideoDriver { }
	
	// FACTORY IMPLEMENTATIONS
	
	private static class LowRequerimentDriverFactory implements DriverFactory {
		@Override
		public AudioDriver provideAudioDriver() {
			return new LowQualityAudioDriver();
		}
		
		@Override
		public VideoDriver provideVideoDriver() {
			return new LowQualityVideoDriver();
		}
	}
	
	private static class HighRequerimentDriverFactory implements DriverFactory {
		@Override
		public AudioDriver provideAudioDriver() {
			return new HighQualityAudioDriver();
		}
		
		@Override
		public VideoDriver provideVideoDriver() {
			return new HighQualityVideoDriver();
		}
	}
}
