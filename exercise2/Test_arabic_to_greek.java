package exercise2;

import static org.junit.Assert.*;

import org.junit.Test;

public class Test_arabic_to_greek {

	@Test
	public void test() {
			Metatropes test = new Metatropes();
			String output= test.arabic_to_greek(556);
			assertEquals("fnc",output);
	}

}
