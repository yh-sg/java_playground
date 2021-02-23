package modelling.testing.modelling;

import org.javamoney.moneta.Money;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ModellingApplication {

	public static void main(String[] args) {
		SpringApplication.run(ModellingApplication.class, args);
		CreditCard cc = new CreditCard(Money.of(100, "USD"));
		cc.withdraw(Money.of(99, "USD"));
		System.out.println(cc.avaliableLimit());
	}

}
