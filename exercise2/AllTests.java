package com.stathoula.exercise2;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ Test_arabic_to_greek.class, Test_arabic_to_latin.class, Test_greek_to_arabic.class,
		Test_IndexOfOperator.class, Test_latin_to_arabic.class })
public class AllTests {

}
