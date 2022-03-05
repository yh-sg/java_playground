package com.example.SpringSecurityUsers.Service.ServiceImpl;

import org.springframework.stereotype.Service;

import com.example.SpringSecurityUsers.Entity.AppUser;
import com.example.SpringSecurityUsers.Model.RegistrationRequest;
import com.example.SpringSecurityUsers.Service.RegistrationService;
import com.example.SpringSecurityUsers.Utils.AppUserRole;
import com.example.SpringSecurityUsers.Utils.EmailValidator;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RegistrationServiceImpl implements RegistrationService {
	
	private final AppUserServiceImpl appUserService;
	private final EmailValidator emailValidator;

	@Override
	public String register(RegistrationRequest request) {
		
        boolean isValidEmail = emailValidator.test(request.getEmail());

        if (!isValidEmail) 
            throw new IllegalStateException("Email not valid");
		
        return appUserService.signUpUser(
                new AppUser(
                        request.getFirstName(),
                        request.getLastName(),
                        request.getEmail(),
                        request.getPassword(),
                        AppUserRole.USER
                )
        );
	}

	@Override
	public String confirmToken(String token) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String buildEmail(String name, String link) {
		// TODO Auto-generated method stub
		return null;
	}

}
