package modelling.testing.modelling;

import static org.junit.jupiter.api.Assertions.*;

import org.javamoney.moneta.Money;
import org.junit.jupiter.api.Test;

public class CreditCardTest {

	@Test
	void shouldBeAbleTowitgdrawWhenEnoughMoney() {
	
		//given
		
		
		//then
		assertEquals(Money.of(1, "USD"), creditCard.avaiableLimit());
		assertEquals(Result.Success, result);
	}
}
