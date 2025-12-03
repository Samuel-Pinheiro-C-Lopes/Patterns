package structural.bridge.turning.implementations.machines;

import structural.bridge.turning.abstractions.GeometryTypeInsert;

public class Lathe {
	private GeometryTypeInsert insert;
	
	public void makeFlange() {
		this.insert.machineExternally(null, null, null, null);
		this.insert.machineExternally(null, null, null, null);
		this.insert.machineInternally(null, null, null, null);
	}
	
	public void makeShaft() {
		this.insert.machineExternally(null, null, null, null);
		this.insert.machineExternally(null, null, null, null);
		this.insert.machineExternally(null, null, null, null);
	}
}