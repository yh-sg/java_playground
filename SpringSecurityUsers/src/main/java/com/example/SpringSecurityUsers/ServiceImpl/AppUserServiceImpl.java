package com.example.SpringSecurityUsers.ServiceImpl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.SpringSecurityUsers.Repository.AppUserRepository;
import com.example.SpringSecurityUsers.Utils.Constants;

@Service
public class AppUserServiceImpl implements UserDetailsService {
	
	//https://blog.marcnuri.com/field-injection-is-not-recommended

	//1st method, traditional autowired...Field Injection
//	@Autowired
//	private AppUserRepository appUserRepository;
//	
//	@Autowired
//	private BCryptPasswordEncoder bCryptPassword;
	
//	@Autowired
//	private ConfirmationTokenService confirmationTokenService;
	
	//This...is the Constructor Based DI
	private final AppUserRepository appUserRepository;
	private final BCryptPasswordEncoder bCryptPassword;
	
	//This can be replaced with lombok @AllArgsConstructor
	public AppUserServiceImpl(AppUserRepository appUserRepository, BCryptPasswordEncoder bCryptPassword) {
		this.appUserRepository = appUserRepository;
		this.bCryptPassword = bCryptPassword;
	}
	
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return appUserRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(String.format(Constants.USER_NOT_FOUND_MSG, email)));
	}

}
