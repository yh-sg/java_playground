package com.example.SpringSecurityUsers.Service;

import com.example.SpringSecurityUsers.Model.RegistrationRequest;

public interface RegistrationService {
	
	String register(RegistrationRequest request);
	String confirmToken(String token);
	String buildEmail(String name, String link);
}
