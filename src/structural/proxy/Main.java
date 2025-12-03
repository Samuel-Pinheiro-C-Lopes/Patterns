package structural.proxy;

import structural.proxy.implementations.Calculator;
import structural.proxy.implementations.LoggedCalculatorProxy;
import structural.proxy.interfaces.Component;

public class Main {
	private static void init(final Component component) {
		System.out.println(component.sum(Integer.valueOf(Integer.MAX_VALUE), Integer.MIN_VALUE));
		System.out.println(component.sum(Integer.valueOf(Integer.valueOf(100)), Integer.MIN_VALUE));
		System.out.println(component.sum(Integer.valueOf(Integer.valueOf(100)), Integer.valueOf(150)));
		System.out.println(component.sum(Integer.valueOf(Integer.MAX_VALUE), Integer.valueOf(-100)));
	}
	
	public static void main(final String[] args) {
		final Calculator calculator = new Calculator();
		final LoggedCalculatorProxy calculatorProxy = new LoggedCalculatorProxy(calculator);
		
		init(calculatorProxy);
		
		calculatorProxy.printLogs();
	}
}
