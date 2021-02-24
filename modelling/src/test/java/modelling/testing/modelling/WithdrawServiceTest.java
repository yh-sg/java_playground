package modelling.testing.modelling;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.javamoney.moneta.Money;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class WithdrawServiceTest {
	
//	CreditCardRepository creditCardRepository = new InMemoryRepo();
//	WithdrawService withdrawService = new WithdrawService(creditCardRepository);
	@Autowired
	CreditCardRepository creditCardRepository;
	@Autowired
	WithdrawService withdrawService;
	
	@Test
	void shouldBeAbleTowitgdrawWhenEnoughMoney() {
	
		//given
		CreditCard creditCard = aNewCardWithInitialBalance(Money.of(100, "SGD"));
		
		//when
		Result result = withdrawService.withdraw(Money.of(99, "SGD"),creditCard.id);
		
		//then
		assertEquals(Result.Success, result);
	}
	
	CreditCard aNewCardWithInitialBalance(Money balance) {
		CreditCard creditCard = new CreditCard(balance);
		return creditCardRepository.save(creditCard);
	}
}
