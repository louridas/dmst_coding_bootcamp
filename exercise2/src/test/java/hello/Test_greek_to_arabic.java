package hello;

import static org.junit.Assert.*;

import org.junit.Test;

public class Test_greek_to_arabic {

	@Test
	public void test() {
		Metatropes test = new Metatropes();
		int output = test.greek_to_arabic("ia");
		assertEquals(11,output);
	}

}
