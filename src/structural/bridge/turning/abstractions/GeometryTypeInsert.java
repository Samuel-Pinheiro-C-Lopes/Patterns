package structural.bridge.turning.abstractions;

import structural.bridge.turning.enums.MachiningType;

public interface GeometryTypeInsert {
	void machine(
		MachiningType machiningType,
		Double startingDiameter, 
		Double finalDiameter, 
		Double startingLength, 
		Double finalLength
	);
}

