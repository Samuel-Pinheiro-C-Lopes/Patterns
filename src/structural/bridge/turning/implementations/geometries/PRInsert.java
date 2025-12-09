package structural.bridge.turning.implementations.geometries;

import structural.bridge.turning.abstractions.GeometryTypeInsert;
import structural.bridge.turning.abstractions.MaterialTypeInsert;
import structural.bridge.turning.enums.MachiningType;

public class PRInsert implements GeometryTypeInsert {
	private final MaterialTypeInsert materialTypeInsert;
	
	public PRInsert(final MaterialTypeInsert materialTypeInsert) {
		this.materialTypeInsert = materialTypeInsert;
	}

	@Override
	public void machine(
		MachiningType machiningType,
		Double startingDiameter, 
		Double finalDiameter, 
		Double startingLength,
		Double finalLength
	) {
		this.materialTypeInsert.stopCutting();
		
		Double currentDiameter = startingDiameter;
		Double reduceValue = Math.abs(startingDiameter - finalDiameter) / 10d;
		
		do {
			this.materialTypeInsert.startCutting(30d, 30d, 35d);
			this.materialTypeInsert.move(startingLength, currentDiameter);
			this.materialTypeInsert.move(finalLength, currentDiameter);
			this.materialTypeInsert.stopCutting();
			
			currentDiameter += machiningType.equals(MachiningType.INTERNAL) ? 
					reduceValue : reduceValue * -1;
		} while (tolerantEquals(currentDiameter, finalDiameter).equals(Boolean.FALSE));
	}
	
	private Boolean tolerantEquals(Double d1, Double d2) {
		final double tolerance = 1e-5;
		
		return Boolean.valueOf(Math.abs(d1 - d2) < tolerance);
	}
}



