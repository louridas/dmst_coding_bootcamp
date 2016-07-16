package stathoula.exercise2;

import org.junit.Test;

import junit.framework.TestCase;

public class Test_arabic_to_greek extends TestCase {
	
	@Test
	public void test() {
			Metatropes test = new Metatropes();
			String output= test.arabic_to_greek(12);
			assertEquals("ib",output);
     }
}