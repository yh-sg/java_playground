package mockito.mockitodemo;

public class BusinessLogic {
	private DataService dataService;
	
	
	
	public BusinessLogic(DataService dataService) {
		super();
		this.dataService = dataService;
	}



	int findTheGreatestFromAllData() {
		int[] data = dataService.retrieveAllData();
		int greatest = Integer.MIN_VALUE;
		for (int value : data) {
			if(value>greatest)
			{
				greatest = value;
			}
		}
		return greatest;
	}
}

