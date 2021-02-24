package modelling.testing.modelling;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Repository;

@Repository("CreditDao")
public class InMemoryRepo implements CreditCardRepository {
	
	private final Map<UUID, CreditCard> cards = new HashMap<>();

	@Override
	public CreditCard getOne(UUID id) {
		return cards.get(id);
	}

	@Override
	public CreditCard save(CreditCard creditCard) {
		cards.put(creditCard.id, creditCard);
		return creditCard;
	}

}
