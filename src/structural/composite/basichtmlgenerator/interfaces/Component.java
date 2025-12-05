package structural.composite.basichtmlgenerator.interfaces;

import java.util.List;

public interface Component { 
	void add(Component component);
	void remove(Component component);
	List<Component> getChildren();
	void show();
	Component withTabulation(Long tabulation);
}
