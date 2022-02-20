package com.example.mapperdemo.service.impl;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mapperdemo.entity.User;
import com.example.mapperdemo.repositories.UserRepo;
import com.example.mapperdemo.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepo userRepository;

	@Override
	public User getOneUser(int id) {
		
		Optional<User> user = userRepository.findById(id);
		
		if(user.isEmpty())
			throw new NoSuchElementException("No such user avaliable!");
		
		return user.get();
	}
}
