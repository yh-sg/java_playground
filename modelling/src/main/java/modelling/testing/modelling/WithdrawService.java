package modelling.testing.modelling;

import java.util.UUID;

import org.javamoney.moneta.Money;

public class WithdrawService {
	
	private final CreditCardRepository creditCardRepository;
	
	public WithdrawService(CreditCardRepository creditCardRepository) {
		this.creditCardRepository = creditCardRepository;
	}
	
	public Result withdraw(Money amount, UUID card) {
		//load card
		CreditCard creditCard = creditCardRepository.getOne(card);
		//withdraw
			//rules
		Result result = creditCard.withdraw(amount);
		//save back to the databases
		creditCardRepository.save(creditCard);
		return result;
	}
}
