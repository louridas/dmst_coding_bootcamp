package stathoula.exercise2;

import static org.junit.Assert.*;

import org.junit.Test;

public class Test_latin_to_arabic {

	@Test
	public void test() {
		Metatropes test = new Metatropes();
		int output = test.latin_to_arabic("XI");
		assertEquals(11,output);
	}

}
