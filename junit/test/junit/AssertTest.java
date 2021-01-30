package junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class AssertTest {

	@Test
	void test() {
		boolean condn = true;
		assertEquals(false,condn); //check if LHS and RHS are different or not.
		assertTrue(condn);
		assertFalse(condn);
		assertNotNull(condn);
	}

}
