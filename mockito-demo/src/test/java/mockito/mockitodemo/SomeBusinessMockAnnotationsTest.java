package mockito.mockitodemo;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class SomeBusinessMockAnnotationsTest {
	
	@Mock
	DataService dataServiceMock;
	
	@InjectMocks
	BusinessLogic businessImpl;

	@Test
	void testFindTheGreatestFromAllData() {
		//Due to @mock
		//DataService dataServiceMock = mock(DataService.class);
		//dataServiceMock.retrieveAllData() => new int[] {1,2,3,4,5,6,7,8};
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {1,2,3,4,5,6,7,8});
		
		//Due to InjectMocks
		//BusinessLogic businessImpl = new BusinessLogic(dataServiceMock);
		int result = businessImpl.findTheGreatestFromAllData();
		assertEquals(8, result);
	}
	
	@Test
	void testFindOneValue() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {2});
		int result = businessImpl.findTheGreatestFromAllData();
		assertEquals(2, result);
	}
	
	@Test
	void testFindNoValue() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {});
		int result = businessImpl.findTheGreatestFromAllData();
		assertEquals(Integer.MIN_VALUE, result);
	}
}
