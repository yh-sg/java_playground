package com.example.SpringSecurityUsers.ServiceTest;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;

import com.example.SpringSecurityUsers.Entity.AppUser;
import com.example.SpringSecurityUsers.Model.RegistrationRequest;
import com.example.SpringSecurityUsers.Service.ServiceImpl.AppUserServiceImpl;
import com.example.SpringSecurityUsers.Service.ServiceImpl.RegistrationServiceImpl;
import com.example.SpringSecurityUsers.Utils.AppUserRole;
import com.example.SpringSecurityUsers.Utils.EmailValidator;

@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class) 
public class RegistrationServiceTest {

	@Mock 
	private AppUserServiceImpl appUserService;
	
	@Mock 
	private EmailValidator emailValidator;
	
	@InjectMocks
	private RegistrationServiceImpl registrationService;
	
	@Test
	void itShouldFailToSignUpUser() {
		// given
		String invalidEmail = "testtest.com";
		RegistrationRequest request = new RegistrationRequest("test", "lastTest", invalidEmail ,"testpw");
		AppUser appUser = new AppUser(
                request.getFirstName(),
                request.getLastName(),
                request.getEmail(),
                request.getPassword(),
                AppUserRole.USER
        );
		
		// when
		when(emailValidator.test(invalidEmail)).thenReturn(false);

		// then
		assertThatThrownBy(()->registrationService.register(request))
		.isInstanceOf(IllegalStateException.class).hasMessage("Email not valid");
		
		verify(appUserService, times(0)).signUpUser(appUser);
	}
	
	@Test
	void itShouldSignUpUser() {
		// given
		String validEmail = "test@test.com";
		RegistrationRequest request = new RegistrationRequest("test", "lastTest", validEmail ,"testpw");
		AppUser appUser = new AppUser(
                request.getFirstName(),
                request.getLastName(),
                request.getEmail(),
                request.getPassword(),
                AppUserRole.USER
        );
		
		// when
		when(emailValidator.test(validEmail)).thenReturn(true);
		
		// then
		registrationService.register(request);
		verify(appUserService, times(1)).signUpUser(appUser);
	}
}
