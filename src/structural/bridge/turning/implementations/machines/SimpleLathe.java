package structural.bridge.turning.implementations.machines;

import structural.bridge.turning.abstractions.GeometryTypeInsert;
import structural.bridge.turning.enums.MachiningType;

public class SimpleLathe {
	private GeometryTypeInsert insert;
	
	public SimpleLathe(GeometryTypeInsert insert) {
		this.insert = insert;
	}
	
	public SimpleLathe() {
		this.insert = null;
	}
	
	public void makeFlange() {
		if (this.insert == null)
			return;
		
		this.insert.machine(MachiningType.EXTERNAL, 100d, 60d, 0d, 40d);
		this.insert.machine(MachiningType.EXTERNAL, 100d, 80d, 40d, 100d);
		this.insert.machine(MachiningType.INTERNAL, 0d, 20d, 0d, 30d);
	}
	
	public void makeShaft() {
		if (this.insert == null)
			return;
		
		this.insert.machine(MachiningType.EXTERNAL, 120d, 80d, 0d, 50d);
		this.insert.machine(MachiningType.EXTERNAL, 120d, 100d, 50d, 100d);
		this.insert.machine(MachiningType.EXTERNAL, 120d, 80d, 100d, 150d);
	}
	
	public void changeGeometryType(GeometryTypeInsert insert) {
		this.insert = insert;
	}
}