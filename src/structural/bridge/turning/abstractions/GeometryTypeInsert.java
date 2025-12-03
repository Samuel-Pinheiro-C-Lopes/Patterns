package structural.bridge.turning.abstractions;

public interface GeometryTypeInsert {
	void machineExternally(Double startingDiameter, Double finalDiameter, Double startingLength, Double finalLength);
	void machineInternally(Double startingDiameter, Double finalDiameter, Double startingLength, Double finalLength);
}
