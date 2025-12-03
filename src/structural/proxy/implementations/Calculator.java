package structural.proxy.implementations;

import structural.proxy.interfaces.Component;

public class Calculator implements Component {
	@Override
	public Integer sum(Integer x, Integer y) {
		return Integer.sum(x.intValue(), y.intValue());
	}
}
