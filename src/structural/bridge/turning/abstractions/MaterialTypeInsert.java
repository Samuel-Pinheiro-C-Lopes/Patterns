package structural.bridge.turning.abstractions;

public interface MaterialTypeInsert {
	default void startCutting(Double ap, Double f, Double vc) {
		System.out.println(this.getClass().getSimpleName() + "started cutting with "
				+ "ap: " + ap + "f: " + f + " and vc: " + vc + ".");
	}
	
	default void stopCutting() {
		System.out.println(this.getClass().getSimpleName() + "stopped cutting.");
	}
	
	default void move(Double x, Double y) {
		System.out.println(this.getClass().getSimpleName() + "is moving to x:" + x + " and y: " + y + ".");
	}
}


