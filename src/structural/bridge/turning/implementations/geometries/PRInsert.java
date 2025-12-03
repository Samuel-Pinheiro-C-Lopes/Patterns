package structural.bridge.turning.implementations.geometries;

import structural.bridge.turning.abstractions.GeometryTypeInsert;
import structural.bridge.turning.abstractions.MaterialTypeInsert;

public class PRInsert implements GeometryTypeInsert {
	private final MaterialTypeInsert materialTypeInsert;
	
	public PRInsert(final MaterialTypeInsert materialTypeInsert) {
		this.materialTypeInsert = materialTypeInsert;
	}

	@Override
	public void machineExternally(Double startingDiameter, Double finalDiameter, Double startingLength,
			Double finalLength) {
		final double firstCutDiameter = finalDiameter + ((startingDiameter - finalDiameter) / 2);
		
		this.materialTypeInsert.stopCutting();
		this.materialTypeInsert.move(startingLength, startingDiameter + 1);
		this.materialTypeInsert.startCutting(10d, 20d, 30d);
		this.materialTypeInsert.move(startingLength, firstCutDiameter);
		this.materialTypeInsert.move(finalLength, firstCutDiameter);
		
		this.materialTypeInsert.stopCutting();
		this.materialTypeInsert.move(startingLength, firstCutDiameter);
		this.materialTypeInsert.startCutting(15d, 25d, 35d);
		this.materialTypeInsert.move(startingLength, finalDiameter);
		this.materialTypeInsert.move(finalLength, finalDiameter);
		
		this.materialTypeInsert.stopCutting();
	}

	@Override
	public void machineInternally(Double startingDiameter, Double finalDiameter, Double startingLength,
			Double finalLength) {
		final double firstCutDiameter = finalDiameter + ((finalDiameter - startingDiameter) / 2);
		
		this.materialTypeInsert.stopCutting();
		this.materialTypeInsert.move(startingLength, startingDiameter - 1);
		this.materialTypeInsert.startCutting(10d, 20d, 30d);
		this.materialTypeInsert.move(startingLength, firstCutDiameter);
		this.materialTypeInsert.move(finalLength, firstCutDiameter);
		
		this.materialTypeInsert.stopCutting();
		this.materialTypeInsert.move(startingLength, firstCutDiameter);
		this.materialTypeInsert.startCutting(15d, 25d, 35d);
		this.materialTypeInsert.move(startingLength, finalDiameter);
		this.materialTypeInsert.move(finalLength, finalDiameter);
		
		this.materialTypeInsert.stopCutting();
	}



}
