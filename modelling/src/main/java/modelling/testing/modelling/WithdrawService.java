package modelling.testing.modelling;

import java.util.UUID;

import org.javamoney.moneta.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class WithdrawService {
	
	@Autowired
	private final CreditCardRepository creditCardRepository;
	
	public WithdrawService(@Qualifier("CreditDao")CreditCardRepository creditCardRepository) {
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
