package practice.jpa.jpademo;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.boot.CommandLineRunner;

import practice.jpa.jpademo.entity.User;
import practice.jpa.jpademo.service.UserRepository;

@Component
public class UserRepositoryCommandLineRunner implements CommandLineRunner {
	private static final Logger log = 
			LoggerFactory.getLogger(UserDaoServiceCommandLineRunner.class);
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... arg0) throws Exception{
		User user = new User("Jill", "Admin");
		userRepository.save(user);
		log.info("New User is created : " + user);
		
		Optional<User> userWithIdOne = userRepository.findById(1L);
		log.info("User is retrived : " + userWithIdOne);
		
		List<User> users = userRepository.findAll();
		log.info("All Users : " + users);
		
		
	}
}
