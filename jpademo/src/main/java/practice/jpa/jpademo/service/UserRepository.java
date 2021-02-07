package practice.jpa.jpademo.service;

import org.springframework.data.jpa.repository.JpaRepository;

import practice.jpa.jpademo.entity.User;

//User and primary key generic
public interface UserRepository extends JpaRepository<User, Long>{

}
