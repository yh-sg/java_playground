package practice.jpa.jpademo.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
	
	@PersistenceContext
	private EntityManager entityManager; //save|retrieve user
	
	public long insert(User user) {
		//open transaction
		entityManager.persist(user);
		//close transaction
		return user.getId();
	}
}

//This will causes big trouble if there are many entity!!!
//Resolve? Use Spring Data - Just define your interface and spring data will provide implementation for it

//public class SomeEntityDAOService {
//	
//	
//	@PersistenceContext
//	private EntityManager entityManager;
//	
//	public long insert(User user) {
//		entityManager.persist(user);
//		return user.getId();
//	}