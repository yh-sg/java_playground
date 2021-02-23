package modelling.testing.modelling;

import java.math.BigDecimal;
import java.util.UUID;

import org.javamoney.moneta.Money;

public class CreditCard {
	
	UUID id = UUID.randomUUID();
	
	private BigDecimal balance;
	private String currency;
	private int withdrawals;
	
	public CreditCard(Money balance) {
		this.balance = balance.getNumberStripped();
		this.currency = balance.getCurrency().getCurrencyCode();
	}

	Result withdraw(Money withdrawalAmount) {
		if(notEnoughMoneyToWithdraw(withdrawalAmount)) return Result.Failure;
		
		if (tooManyWithdrawalsInCycle()) return Result.Failure;
		
		balance = balance.subtract(withdrawalAmount.getNumberStripped());
		withdrawals++;
		return Result.Success;
	}
	
	private boolean tooManyWithdrawalsInCycle() {
		return withdrawals >= 45;
	}
	
	private boolean notEnoughMoneyToWithdraw(Money withdrawalAmount) {
		return withdrawalAmount.getNumberStripped().compareTo(balance) > 0;
	}
	
	Result repay(Money repaymentAmount) {
		balance = balance.add(repaymentAmount.getNumberStripped());
		return Result.Success;
	}
	
	Money avaliableLimit(){
		return Money.of(balance, currency);
	}
	
}

enum Result{
		Failure, Success;
}