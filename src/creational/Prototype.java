package creational;

public class Prototype {
	private static interface Manipulator {
		void manipulate();
	}
	
	private static class GraphicTool implements Manipulator {
		private final Graphic graphic;
		
		public GraphicTool(Graphic graphic) {
			this.graphic = graphic;
		}
		
		@Override
		public void manipulate() {
			this.graphic.replicateSelf().draw(10);
		}
	}
	
	private static class SongTool implements Manipulator {
		private final MusicalNote note;
		
		public SongTool(final MusicalNote n) {
			this.note = n;
		}
		
		@Override
		public void manipulate() {
			this.note.play();
		}
	}
	
	private static void initGraphic(final Graphic graphic) {
		final GraphicTool tool = new GraphicTool(graphic);
		
		tool.manipulate();
	}
	
	private static void initSong(final MusicalNote note) {
		final SongTool tool = new SongTool(note);
		
		tool.manipulate();
	}
	
	public static void main(String args[]) {
		final MusicalNote note = new WholeNote();
		
		initGraphic(note);
		initSong(note);
	}
	
	private static interface Graphic {
		Graphic replicateSelf();
		default Boolean draw(Integer position) {
			System.out.println(this.getClass().getSimpleName() + " is being draw!");
			
			return Boolean.TRUE;
		}
	}
	
	
	private static interface MusicalNote extends Graphic {
		default void play() {
			System.out.println(this.getClass().getSimpleName() + " is being draw!");
		}
	}
	
	private static class WholeNote implements MusicalNote {
		public WholeNote() { }
		
		public WholeNote(WholeNote note) { }
		
		@Override
		public Graphic replicateSelf() {
			return new WholeNote(this);
		}
	}
	
	private static class HallNote implements MusicalNote {
		public HallNote() { }
		
		public HallNote(HallNote note) { }
		
		@Override
		public Graphic replicateSelf() {
			return new HallNote(this);
		}
	}
}
