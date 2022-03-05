package com.example.SpringSecurityUsers.UtilTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.SpringSecurityUsers.Utils.EmailValidator;

@ExtendWith(MockitoExtension.class) 
public class EmailValidationTest {

	//given
	private EmailValidator emailValidator = new EmailValidator();
	
	//when
	@ParameterizedTest
	@CsvSource({
		"somethingsome.com,false",
		"johndoe,false",
		"something@some.com,true",
	})
	
	//then
	void phoneNumValidatorTest(String email, boolean expected) {
		boolean result = emailValidator.test(email);
		assertEquals(result,expected);
	}
}
