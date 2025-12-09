package structural.bridge.turning.implementations.factories;

import java.util.Arrays;
import java.util.List;

import structural.bridge.turning.abstractions.GeometryTypeInsert;
import structural.bridge.turning.abstractions.factories.InsertFactory;
import structural.bridge.turning.implementations.geometries.PMInsert;
import structural.bridge.turning.implementations.geometries.PRInsert;
import structural.bridge.turning.implementations.materials.PInsert;

public class OptimizedPInsertFactory implements InsertFactory {
	@Override
	public List<GeometryTypeInsert> getGeometriesTypes() {
		return Arrays.asList(
			new PRInsert(new PInsert()),
			new PMInsert(new PInsert())
		);
	}
}


