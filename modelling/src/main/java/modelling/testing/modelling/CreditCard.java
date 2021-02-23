package modelling.testing.modelling;

import java.util.UUID;

import org.javamoney.moneta.Money;

public class CreditCard {
	
	UUID id = UUID.randomUUID();
	
	private Money balance;
	
	public CreditCard(Money balance) {
		this.balance = balance;
	}

	Result withdraw(Money withdrawalAmount) {
		if(notEnoughMoneyToWithdraw(withdrawalAmount)) return Result.Failure;
		
		balance = balance.subtract(withdrawalAmount);
		return Result.Success;
	}
	
	private boolean notEnoughMoneyToWithdraw(Money withdrawalAmount) {
		return withdrawalAmount.isGreaterThan(balance);
	}
	
	Result repay(Money repaymentAmount) {
		return Result.Success;
	}
	
	Money avaliableLimit(){
		return balance;
	}
	
}

enum Result{
		Failure, Success;
}