package structural.bridge.turning.implementations.geometries;

import structural.bridge.turning.abstractions.GeometryTypeInsert;
import structural.bridge.turning.abstractions.MaterialTypeInsert;

public class MFInsert implements GeometryTypeInsert {
	private final MaterialTypeInsert materialTypeInsert;
	
	public MFInsert(final MaterialTypeInsert materialTypeInsert) {
		this.materialTypeInsert = materialTypeInsert;
	}
	
	@Override
	public void machineExternally(Double startingDiameter, Double finalDiameter, Double startingLength,
			Double finalLength) {
		this.materialTypeInsert.stopCutting();
		
		Double currentDiameter = startingDiameter;
		Double reduceValue = (startingDiameter - finalDiameter) / 10d;
		
		do {
			this.materialTypeInsert.startCutting(30d, 30d, 35d);
			this.materialTypeInsert.move(startingLength, currentDiameter);
			this.materialTypeInsert.move(finalLength, currentDiameter);
			this.materialTypeInsert.stopCutting();
			
			currentDiameter -= reduceValue;
		} while (currentDiameter.equals(finalDiameter) == Boolean.FALSE);
	}

	@Override
	public void machineInternally(Double startingDiameter, Double finalDiameter, Double startingLength,
			Double finalLength) {
		this.materialTypeInsert.stopCutting();
		
		Double currentDiameter = startingDiameter;
		Double reduceValue = (startingDiameter - finalDiameter) / 10d;
		
		do {
			this.materialTypeInsert.startCutting(30d, 30d, 35d);
			this.materialTypeInsert.move(startingLength, currentDiameter);
			this.materialTypeInsert.move(finalLength, currentDiameter);
			this.materialTypeInsert.stopCutting();
			
			currentDiameter += reduceValue;
		} while (currentDiameter.equals(finalDiameter) == Boolean.FALSE);
	}

}
