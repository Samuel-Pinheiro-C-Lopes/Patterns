package structural.bridge.turning.abstractions.factories;

import java.util.List;

import structural.bridge.turning.abstractions.GeometryTypeInsert;
import structural.bridge.turning.abstractions.MaterialTypeInsert;

public interface InsertFactory {
	List<GeometryTypeInsert> getGeometriesTypes();
}

