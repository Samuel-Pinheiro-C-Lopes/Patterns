package structural.proxy.implementations;

import java.util.ArrayList;
import java.util.List;

import structural.proxy.interfaces.Component;

/* Adds log to the request */
public class LoggedCalculatorProxy implements Component {
	private final Calculator calculator;
	private final List<Integer> logs;
	
	public LoggedCalculatorProxy(final Calculator calculator) {
		this.logs = new ArrayList<Integer>();
		this.calculator = calculator;
	}
	
	@Override
	public Integer sum(Integer x, Integer y) {
		final Integer sum = this.calculator.sum(x, y);
		this.logs.add(sum);
		return sum;
	}
	
	public void printLogs() {
		System.out.println(logs.toString());
	}
}
