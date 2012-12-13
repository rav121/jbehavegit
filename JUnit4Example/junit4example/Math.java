package junit4example;

import java.util.LinkedList;
import java.util.List;

public class Math {	
	public int sum(int value1, int value2) {
		if (value1 >= 100) {
			throw new IllegalArgumentException("The number must be lesser than 100");
		}
		return value1 + value2;
	}
	
	public List<String> getListOperations() {
		List<String> list = new LinkedList<String>();
		list.add("sum");
		list.add("subtract");
		list.add("multiplication");
		list.add("division");
		return list;
	}
}
