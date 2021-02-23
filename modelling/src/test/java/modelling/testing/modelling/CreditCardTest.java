package modelling.testing.modelling;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.IntStream;

import org.javamoney.moneta.Money;
import org.junit.jupiter.api.Test;

public class CreditCardTest {

	@Test
	void shouldBeAbleTowitgdrawWhenEnoughMoney() {
	
		//given
		CreditCard creditCard = aNewCardWithInitialBalance(Money.of(100, "SGD"));
		
		//when
		Result result = creditCard.withdraw(Money.of(99, "SGD"));
		
		//then
		assertEquals(Money.of(1, "SGD"), creditCard.avaliableLimit());
		assertEquals(Result.Success, result);
	}
	
	@Test
	void shouldNotBeAbleToWithdrawWhenNotEnoughMoney() {
		//given
		CreditCard creditCard = aNewCardWithInitialBalance(Money.of(100, "SGD"));
		
		//when
		Result result = creditCard.withdraw(Money.of(101, "SGD"));
		
		//then
		assertEquals(Money.of(100, "SGD"), creditCard.avaliableLimit());
		assertEquals(Result.Failure, result);
	}
	
	@Test
	void shouldBeAbleToWithdrawAfterRepayment() {
		//given
		CreditCard creditCard = aNewCardWithInitialBalance(Money.of(100, "SGD"));
		//and
		creditCard.withdraw(Money.of(10, "SGD"));
		//and
		creditCard.repay(Money.of(10, "SGD"));
		
		//when
		Result result = creditCard.withdraw(Money.of(100, "SGD"));
		
		//then
		assertEquals(Money.of(0, "SGD"), creditCard.avaliableLimit());
		assertEquals(Result.Success, result);
	}
	
	@Test
	void shouldNotBeAbleToWithdrawAfter45WithdrawalsInOneCycle() {
		//given
		CreditCard creditCard = aNewCardWithInitialBalance(Money.of(100, "SGD"));
		//and
		IntStream.range(0, 45).forEach(i->creditCard.withdraw(Money.of(1, "SGD")));
		
		//when
		Result result = creditCard.withdraw(Money.of(1, "SGD"));
		
		//then
		assertEquals(Money.of(55, "SGD"), creditCard.avaliableLimit());
		assertEquals(Result.Failure, result);
	}
	
	CreditCard aNewCardWithInitialBalance(Money balance) {
		return new CreditCard(balance);
	}
}
