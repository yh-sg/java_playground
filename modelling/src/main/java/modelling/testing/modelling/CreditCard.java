package modelling.testing.modelling;

import java.util.UUID;

import org.javamoney.moneta.Money;

public class CreditCard {
	
	UUID id = UUID.randomUUID();
	
	Result withdraw(Money withdrawalAmount) {
		return Result.Success;
	}
	
	Result repay(Money repaymentAmount) {
		return Result.Success;
	}
	
	Result avaliableLimit(){
		return null;
	}
	
}

enum Result{
		Failure, Success;
}