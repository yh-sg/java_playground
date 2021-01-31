package mockito.mockitodemo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SomeBusinessStubTest {

	@Test
	public void testFindTheGreatestFromAllData() {
		BusinessLogic businessImpl = new BusinessLogic(new DataServiceStub());
		int result = businessImpl.findTheGreatestFromAllData();
		assertEquals(8, result);
	}

}

class DataServiceStub implements DataService{

	@Override
	public int[] retrieveAllData() {
		// TODO Auto-generated method stub
		return new int[] {4,6,1,7,8};
	}
	
}