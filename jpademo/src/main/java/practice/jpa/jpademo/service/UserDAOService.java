package practice.jpa.jpademo.service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import practice.jpa.jpademo.entity.User;

@Repository
@Transactional
public class UserDAOService {
	
	/*
	 User jack = new User("Jack", "Admin");
	 User mary = new User("Mary", "Admin");
	 
	 entityManager.persist(jack)
	 
	 //Persistence Context
	 
	 jack.setRole("User");
	 jill.setRole("User");
	 
	 */
	
	
	
	private EntityManager entityManager; //save|retrieve user
	
	public long insert(User user) {
		//open transaction
		entityManager.persist(user);
		//close transaction
		return user.getId();
	}
}
