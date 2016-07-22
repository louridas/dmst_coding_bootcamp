package hello;

import static org.junit.Assert.*;

import org.junit.Test;

public class Test_arabic_to_greek {

	@Test
	public void test() {
			Metatropes test = new Metatropes();
			String output= test.arabic_to_greek(12);
			assertEquals("ib",output);
     }
}