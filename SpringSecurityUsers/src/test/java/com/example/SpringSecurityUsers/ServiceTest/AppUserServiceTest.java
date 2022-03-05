package com.example.SpringSecurityUsers.ServiceTest;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.SpringSecurityUsers.Entity.AppUser;
import com.example.SpringSecurityUsers.Repository.AppUserRepository;
import com.example.SpringSecurityUsers.ServiceImpl.AppUserServiceImpl;
import com.example.SpringSecurityUsers.Utils.AppUserRole;

@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class) 
public class AppUserServiceTest {
	
	@Mock 
	private AppUserRepository appUserRepository;
	
	@InjectMocks 
	private AppUserServiceImpl appUserService;
	
	@Test
	void itShouldFailToGetAnEmail() {
		// given
		String email = "test@test.com";
		
		// when
		when(appUserRepository.findByEmail(email)).thenReturn(Optional.empty());

		// then
        assertThatThrownBy(()->appUserService.loadUserByUsername(email))
    	.isInstanceOf(UsernameNotFoundException.class)
    	.hasMessage("User with email test@test.com is not found!");
		
	}
	
	@Test
	void itShouldGetAnEmail() {
		// given
		String email = "mamaSaren@test.com";
		AppUser saren = new AppUser("Saren","Sasaki","mamaSaren@sarendia.com","test",AppUserRole.USER);
		
		// when
		when(appUserRepository.findByEmail(email)).thenReturn(Optional.of(saren));

		// then
		assertEquals(appUserService.loadUserByUsername(email), saren);
		
	}
	
}
