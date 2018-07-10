package com.vinh.vaadin.allinone;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;

import java.time.Duration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

//@Disabled // disable all test
class StringTest {
	
	private String str;
	
	@Nested
	class EmptyStringTest {
		@BeforeEach
		void setToEmpty() {
			System.out.println("EMPTY str");
			str = "";
		}
		
		@Test
		void lengthIsZero() {
			assertTrue(str.length() == 0);
		}
		
		@Test
		void upperCaseIsEmpty() {
			assertEquals("",str.toUpperCase());
		}
		
	}
	
	@BeforeAll
	static void testDataBase() {
		System.out.println("Before all tests");
	}
	
	@AfterAll
	static void closeDataBase() {
		System.out.println("Close all tests");
	}
	
	@BeforeEach
	void beforeEach(TestInfo info) {
		System.out.println("Initialize for " + info.getDisplayName());
	}
	
	@AfterEach
	void afterEach(TestInfo info) {
		System.out.println("Clean up test data for " + info.getDisplayName());
	}

	@Test
	@RepeatedTest(10)
	void length_basic() {
		assertEquals(4, "ABCD".length());
	}
	
	@Test
	@DisplayName("When string is null, throw an exception")
	void length_exception() {
		String str = null;
		assertThrows(NullPointerException.class, () -> {			
			int length = str.length();
		});
	}
	
	@Test
	@Disabled //not run at all
	void toUpperCase() {
		assertEquals("ABCD", "abcd".toUpperCase());
		assertNotNull("abcd".toUpperCase());
	}
	
	@Test
	void contains_basic() {
		assertEquals(false,  "abcdefgh".contains("swag"));
	}
	
	@Test
	void split_basic() {
		String str = "abc def ghi";
		String result[] = str.split(" ");
		String expectedResult[] = new String[] {"abc", "def", "ghi"};
		assertArrayEquals(expectedResult, result);
	}
	
	@ParameterizedTest //Use this when a same test is needed for different values 
					   //without writing assert method for each of them
	@ValueSource(strings = {"ABCD", "A", "SWAGGER"})
	void length_greater_than_zero(String str) {
		assertTrue(str.length()>0);
	}
	
	@ParameterizedTest(name = "{0} upper Case {1}") 
	@CsvSource(value= {"abc, ABC", "defg, DEFG", "'',''"})
	void upperCase(String world, String capWorld) {
		assertEquals(capWorld, world.toUpperCase());
	}
	
	@Test
//	@RepeatedTest(10)
	void performanceTest() {
		assertTimeout(Duration.ofSeconds(3), () -> {
			for(int i = 0; i < 10; i++) {
				System.out.println(i);
			}
		});
	}
	
}



































