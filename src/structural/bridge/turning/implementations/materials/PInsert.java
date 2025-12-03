package structural.bridge.turning.implementations.materials;

import structural.bridge.turning.abstractions.MaterialTypeInsert;

public class PInsert implements MaterialTypeInsert {
	@Override
	public void startCutting(Double ap, Double f, Double vc) {
		// start cutting for the specified material
	}

	@Override
	public void stopCutting() {
		// stops cutting
	}

	@Override
	public void move(Double x, Double y) {
		// moves to the specific position
	}

}
