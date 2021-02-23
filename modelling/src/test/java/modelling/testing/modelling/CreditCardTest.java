package modelling.testing.modelling;

import static org.junit.jupiter.api.Assertions.*;

import org.javamoney.moneta.Money;
import org.junit.jupiter.api.Test;

public class CreditCardTest {

	@Test
	void shouldBeAbleTowitgdrawWhenEnoughMoney() {
	
		//given
		CreditCard creditCard = aNewCardWithInitialBalance(Money.of(100, "USD"));
		
		//when
		Result result = creditCard.withdraw(Money.of(99, "USD"));
		
		//then
		assertEquals(Money.of(1, "USD"), creditCard.avaliableLimit());
		assertEquals(Result.Success, result);
	}
	
	@Test
	void shouldNotBeAbleToWithdrawWhenNotEnoughMoney() {
		//given
		CreditCard creditCard = aNewCardWithInitialBalance(Money.of(100, "USD"));
		
		//when
		Result result = creditCard.withdraw(Money.of(101, "USD"));
		
		//then
		assertEquals(Money.of(100, "USD"), creditCard.avaliableLimit());
		assertEquals(Result.Failure, result);
	}
	
	CreditCard aNewCardWithInitialBalance(Money balance) {
		return new CreditCard(balance);
	}
}
