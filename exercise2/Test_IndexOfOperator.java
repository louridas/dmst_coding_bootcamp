package com.stathoula.exercise2;

import static org.junit.Assert.*;

import org.junit.Test;

public class Test_IndexOfOperator {

	@Test
	public void test() {
		Metatropes test = new Metatropes();
		int output = test.index_of_operator("34+II");
		assertEquals(2,output);
	}

}
