package com.example.mapperdemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.mapperdemo.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

}
