package com.example.SpringSecurityUsers.ServiceTest;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.SpringSecurityUsers.Entity.AppUser;
import com.example.SpringSecurityUsers.Repository.AppUserRepository;
import com.example.SpringSecurityUsers.Service.ServiceImpl.AppUserServiceImpl;
import com.example.SpringSecurityUsers.Utils.AppUserRole;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class) 
public class AppUserServiceTest {
	
	@Mock 
	private AppUserRepository appUserRepository;
	
	@Mock
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Captor
	private ArgumentCaptor<AppUser> userArgumentCaptor;
	
	@InjectMocks 
	private AppUserServiceImpl appUserService;
	
	// given
	String invalidEmail = "test@test.com";
	String validEmail = "mamaSaren@test.com";
	AppUser saren = new AppUser("Saren","Sasaki",validEmail,"test",AppUserRole.USER);
	
	@Test
	void itShouldFailToGetAnEmail() {
		// given
		
		// when
		when(appUserRepository.findByEmail(invalidEmail)).thenReturn(Optional.empty());

		// then
        assertThatThrownBy(()->appUserService.loadUserByUsername(invalidEmail))
    	.isInstanceOf(UsernameNotFoundException.class)
    	.hasMessage("User with email test@test.com is not found!");
		
	}
	
	@Test
	void itShouldGetAnEmail() {
		// given
		
		// when
		when(appUserRepository.findByEmail(validEmail)).thenReturn(Optional.of(saren));

		// then
		assertEquals(appUserService.loadUserByUsername(validEmail), saren);
		
	}
	
	@Test
	void itShouldNotBeAbleToSignUpUser() {
		// given
		
		// when
		when(appUserRepository.findByEmail(validEmail)).thenReturn(Optional.of(saren));

		// then
        assertThatThrownBy(()->appUserService.signUpUser(saren))
    	.isInstanceOf(IllegalStateException.class)
    	.hasMessage("Email already taken");
		
	}
	
	@Test
	void itShouldBeAbleToSignUpUser() {
		// given
		
		// when
		when(appUserRepository.findByEmail(validEmail)).thenReturn(Optional.empty());

		// then
		appUserService.signUpUser(saren);
		
		verify(appUserRepository).save(userArgumentCaptor.capture());
		AppUser userArgumentCaptorValue = userArgumentCaptor.getValue();
		log.info(userArgumentCaptorValue.toString());
		log.info(saren.toString());
		assertEquals(saren,userArgumentCaptorValue);
		
	}
	
}
