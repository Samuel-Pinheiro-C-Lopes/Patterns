package structural.bridge.turning.implementations.geometries;

import structural.bridge.turning.abstractions.GeometryTypeInsert;
import structural.bridge.turning.abstractions.MaterialTypeInsert;
import structural.bridge.turning.enums.MachiningType;

public class PMInsert implements GeometryTypeInsert {
	private final MaterialTypeInsert materialTypeInsert;
	
	public PMInsert(final MaterialTypeInsert materialTypeInsert) {
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
		final double firstCutDiameterOffset = machiningType.equals(MachiningType.EXTERNAL) ? 
				startingDiameter - finalDiameter : finalDiameter - startingDiameter;
		
		final double firstCutDiameter = finalDiameter + (firstCutDiameterOffset / 2);
		
		this.materialTypeInsert.stopCutting();
		this.materialTypeInsert.move(startingLength, startingDiameter);
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


