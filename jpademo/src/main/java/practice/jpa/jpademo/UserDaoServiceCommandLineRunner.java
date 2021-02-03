package practice.jpa.jpademo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import practice.jpa.jpademo.entity.User;
import practice.jpa.jpademo.service.UserDAOService;

//Call the userDAOservice
@Component
public class UserDaoServiceCommandLineRunner implements CommandLineRunner {
	
	private static final Logger log = 
			LoggerFactory.getLogger(UserDaoServiceCommandLineRunner.class);
	
	@Autowired
	private UserDAOService userDaoService;
	
	@Override
	public void run(String... arg0) throws Exception{
		User user = new User("Jack", "Admin");
		//New User is created : User [id=1, name=Jack, role=Admin]
		long insert = userDaoService.insert(user);
		log.info("New User is created : " + user);
	}
}

//Where is the database created? In Memory - Using H2
//What schema is used to create the tables? - Created based on the entities defined
//Where are the tables created? - Above two answers
//Where can I see the data in the database? - http://localhost:8080/h2-console | use db url jdbc:h2:mem:testdb
//Where is Hibernate coming in from? - Through Spring Data JPA starter
//How is a datasource created? - Through Spring Boot Auto Configuration
