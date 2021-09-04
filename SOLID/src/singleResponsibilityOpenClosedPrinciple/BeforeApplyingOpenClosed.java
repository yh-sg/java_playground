package singleResponsibilityOpenClosedPrinciple;

public class BeforeApplyingOpenClosed {
	private final int RETIREMENT_TAX_PERCENTAGE = 10;
	private final int INCOME_TAX_PERCENTAGE = 16;
	private final int BASE_HEALTH_INSURANCE = 100;
	
//	public double calculate(Employee employee) {
//		return BASE_HEALTH_INSURANCE + (employee.getMonthlyIcome()*RETIREMENT_TAX_PERCENTAGE) / 100 + (employee.getMonthlyIcome()*INCOME_TAX_PERCENTAGE);
//	}
	
	
	
//	v2
//	public double calculate(Employee employee) {
	
//	int monthlyIncome = employee.getMonthlyIcome
	
//	if(employee instanceof FullTimeEmployee){
//		return BASE_HEALTH_INSURANCE + (employee.getMonthlyIcome()*RETIREMENT_TAX_PERCENTAGE) / 100 + (employee.getMonthlyIcome()*INCOME_TAX_PERCENTAGE);
//	}
	
//	if(employee instanceof PartTimeEmployee){
//	return BASE_HEALTH_INSURANCE + (employee.getMonthlyIcome()*RETIREMENT_TAX_PERCENTAGE) / 100 + (employee.getMonthlyIcome()*INCOME_TAX_PERCENTAGE);
//}
	
//	if(employee instanceof PartTimeEmployee){
//	return ;
//}
	
//	if(employee instanceof Intern){
//	return ;
//}
	
//}
}

//Business requirement v1
//Taxes for employees are calculated like this:
//Fixed $100 amount for base health insurance
//16% income tax
//10% retirement tax

//Business requirement v2
//1)Taxes for full-time-employees are calculated like this:
//Fixed $100 amount for base health insurance
//16% income tax
//10% retirement tax
//
//2)Taxes for part-time-employees are calculated like this:
//Fixed $100 amount for base health insurance
//16% income tax
//5% retirement tax

//3)For interns:
//Income < 350 = 0
//Else only 16% income tax