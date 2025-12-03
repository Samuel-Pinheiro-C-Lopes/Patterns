package structural.bridge.turning;

import structural.bridge.turning.implementations.machines.Lathe;

public class Main {
	public static void latheInit(final Lathe lathe) {
		lathe.makeFlange();
		lathe.makeShaft();
		// [...]
	}
	
	public static void main(String[] args) {
		
	}
}
