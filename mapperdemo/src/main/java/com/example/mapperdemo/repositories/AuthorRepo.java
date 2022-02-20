package com.example.mapperdemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mapperdemo.entity.Author;

public interface AuthorRepo extends JpaRepository<Author, Integer> {

}
