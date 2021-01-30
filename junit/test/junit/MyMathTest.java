package junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MyMathTest {
	
	MyMath myMath = new MyMath();
	
	//JUNIT 5 use before -> beforeeach , afterclass -> afterAll
	
	@BeforeEach
	public void before() {
		System.out.println("Before");
	}
	
	@BeforeAll
	public static void beforeClass() {
		System.out.println("Before Class");
	}
	
	@AfterEach
	public void after() {
		System.out.println("After");
	}
	
	@AfterAll
	public static void afterClass() {
		System.out.println("After Class");
	}

	@Test
	public void sum_with3numbers() {
		System.out.println("Test1");
		//MyMath.sum
		// 1,2,3 => 6
		int result = myMath.sum(new int[] {1,2,3});
		assertEquals(6, result);
		//Absence of failure/assertEquals is success
		//fail("Not yet implemented");
	}
	
	@Test
	public void sum_with1number() {
		System.out.println("Test2");
		int result = myMath.sum(new int[] {3});
		
		assertEquals(3, result);
	}

}
