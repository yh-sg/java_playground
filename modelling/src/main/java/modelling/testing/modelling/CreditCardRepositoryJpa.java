package modelling.testing.modelling;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface CreditCardRepositoryJpa extends JpaRepository<CreditCard, UUID>{
	
}
