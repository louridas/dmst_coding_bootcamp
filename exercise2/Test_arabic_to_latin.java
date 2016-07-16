package stathoula.exercise2;

import static org.junit.Assert.*;

import org.junit.Test;

public class Test_arabic_to_latin {

	@Test
	public void test() {
		Metatropes test = new Metatropes();
		String output = test.arabic_to_latin(7);
		assertEquals("VII",output);
	}

}
