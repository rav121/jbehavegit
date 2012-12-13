package junit4example;

import static junit.framework.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class TestMath {
	
	//Attribute
	Math math;

	@Before
	public void setUp() throws Exception {
		math = new Math();
	}
	@Test
	public void testSumSuccessfully() {
		assertTrue(math.sum(1, 1) == 2);
		assertTrue(math.sum(5, 5) == 10);
		assertTrue(math.sum(10, 10) == 20);
	}
	@Test
	public void testSumError() {
		assertFalse(math.sum(1, 1) == 3);
	}
	@Test(expected=IllegalArgumentException.class)
	public void testSumWithException() {
		math.sum(101, 1);
	}
	@Test
	public void testGetListSuccess() {
		//--My object
		List<String> list = new LinkedList<String>();
		list.add("sum");
		list.add("subtract");
		list.add("multiplication");
		list.add("division");
		//--Getting object from method
		List<String> originalList = math.getListOperations();
		int count = 0;
		for (String operation : originalList) {
			assertEquals(operation, list.get(count));//Testing here
			count++;
		}
	}
}
