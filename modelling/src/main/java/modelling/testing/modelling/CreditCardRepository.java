package modelling.testing.modelling;

import java.util.UUID;

public interface CreditCardRepository {
	
	CreditCard getOne(UUID id);
	
	CreditCard save(CreditCard creditCard);
}
