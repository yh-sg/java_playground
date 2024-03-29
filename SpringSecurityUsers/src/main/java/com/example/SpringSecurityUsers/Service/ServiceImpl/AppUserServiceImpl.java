package com.example.SpringSecurityUsers.Service.ServiceImpl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.SpringSecurityUsers.Entity.AppUser;
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
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	
	//This can be replaced with lombok @AllArgsConstructor
	public AppUserServiceImpl(AppUserRepository appUserRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.appUserRepository = appUserRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return appUserRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(String.format(Constants.USER_NOT_FOUND_MSG, email)));
	}
	
	public String signUpUser(AppUser appUser) {
		
		boolean userExists = appUserRepository
				.findByEmail(appUser.getEmail())
				.isPresent();

        if (userExists) 
            throw new IllegalStateException("Email already taken");
		
        String encodedPassword = bCryptPasswordEncoder
                .encode(appUser.getPassword());

        appUser.setPassword(encodedPassword);

        appUserRepository.save(appUser);
        
        return "User saved";
	}

}
