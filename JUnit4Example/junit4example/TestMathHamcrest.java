package junit4example;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.junit.Before;
import org.junit.Test;

public class TestMathHamcrest {	
	private Math math;
	@Before
	public void setUp() throws Exception {
		math = new Math();
	}
	
	@Test
	public void testSumSuccessfully() {
		assertThat(math.sum(1, 1),equalTo(2));		
	}	

	@Test
	public void testSumError() {
		assertThat(math.sum(1, 1), not(equalTo(3)));
	}
	
	@Test
	public void testGetListSuccess() {
		assertThat(math.getListOperations(), hasItems("sum","subtract","multiplication","division"));
	}

}
