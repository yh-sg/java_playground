package mockito.mockitodemo;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

class SomeBusinessMockTest {

	@Test
	void test() {
		DataService dataServiceMock = mock(DataService.class);
		//dataServiceMock.retrieveAllData() => new int[] {1,2,3,4,5,6,7,8};
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {1,2,3,4,5,6,7,8});
		
		BusinessLogic businessImpl = new BusinessLogic(dataServiceMock);
		int result = businessImpl.findTheGreatestFromAllData();
		assertEquals(8, result);
	}

}
