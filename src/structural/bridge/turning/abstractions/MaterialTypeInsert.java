package structural.bridge.turning.abstractions;

public interface MaterialTypeInsert {
	void startCutting(Double ap, Double f, Double vc);
	void stopCutting();
	void move(Double x, Double y);
}
