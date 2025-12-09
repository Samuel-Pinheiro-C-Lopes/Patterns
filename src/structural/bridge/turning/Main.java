package structural.bridge.turning;

import java.util.List;
import java.util.concurrent.TimeUnit;

import structural.bridge.turning.abstractions.GeometryTypeInsert;
import structural.bridge.turning.abstractions.factories.InsertFactory;
import structural.bridge.turning.implementations.factories.OptimizedPInsertFactory;
import structural.bridge.turning.implementations.machines.SimpleLathe;

public class Main {
	private static volatile boolean keepRunning = true;
	
	public static void init(final SimpleLathe lathe) {
		while (keepRunning == true) {
			lathe.makeFlange();
			waitFor(1l);
			lathe.makeShaft();
			waitFor(1l);
		}
	}
	
	public static void preinit(final SimpleLathe lathe, final InsertFactory insertFactory) throws InterruptedException {
		List<GeometryTypeInsert> geometries = insertFactory.getGeometriesTypes();
		
		Thread thread = new Thread(() -> init(lathe));
		thread.start();
		
		for (int i = 0; i < 3; i++) {
			lathe.changeGeometryType(geometries.get(i % geometries.size()));
			waitFor(2l);
		}
		
		keepRunning = false;
		thread.join();
	}
	
	public static void main(String[] args) throws InterruptedException {
		final SimpleLathe lathe = new SimpleLathe();
		preinit(lathe, new OptimizedPInsertFactory());
	}
	
	private static void waitFor(Long seconds) {
		try {
			TimeUnit.SECONDS.sleep(seconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
