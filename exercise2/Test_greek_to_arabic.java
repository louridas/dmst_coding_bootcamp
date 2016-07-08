package exercise2;

import static org.junit.Assert.*;

import org.junit.Test;

public class Test_greek_to_arabic {

	@SuppressWarnings("deprecation")
	@Test
	public void test() {
		Metatropes test = new Metatropes();
		double output = test.greek_to_arabic("ia");
		assertEquals(11.0,output);
	}

}
