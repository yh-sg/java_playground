package com.example.mapperdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mapperdemo.dto.BookDto;
import com.example.mapperdemo.mapper.MapStructMapper;
import com.example.mapperdemo.repositories.BookRepo;

@RestController
@RequestMapping("/books")
public class BookController {

	@Autowired
    private MapStructMapper mapstructMapper;

	@Autowired
    private BookRepo bookRepository;
	
    @GetMapping("/{id}")
    public ResponseEntity<BookDto> getById(@PathVariable(value = "id") int id) {
        return new ResponseEntity<>(mapstructMapper.bookToBookDto(bookRepository.findById(id).get()),HttpStatus.OK);
    }
	
}
