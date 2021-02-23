package modelling.testing.modelling;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.javamoney.moneta.Money;
import org.junit.jupiter.api.Test;

public class WithdrawServiceTest {
	
	CreditCardRepository creditCardRepository = new InMemoryRepo();
	WithdrawService withdrawService = new WithdrawService(creditCardRepository);
	
	@Test
	void shouldBeAbleTowitgdrawWhenEnoughMoney() {
	
		//given
		CreditCard creditCard = aNewCardWithInitialBalance(Money.of(100, "SGD"));
		
		//when
		Result result = creditCard.withdraw(Money.of(99, "SGD"));
		
		//then
		assertEquals(Result.Success, result);
	}
	
	CreditCard aNewCardWithInitialBalance(Money balance) {
		CreditCard creditCard = new CreditCard(balance);
		return creditCardRepository.save(creditCard);
	}
}
