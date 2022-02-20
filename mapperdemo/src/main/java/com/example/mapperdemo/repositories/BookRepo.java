package com.example.mapperdemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.mapperdemo.entity.Book;

@Repository
public interface BookRepo extends JpaRepository<Book, Integer> {

}
