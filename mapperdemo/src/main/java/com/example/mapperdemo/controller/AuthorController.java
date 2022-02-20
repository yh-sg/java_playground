package com.example.mapperdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mapperdemo.dto.AuthorAllDto;
import com.example.mapperdemo.mapper.MapStructMapper;
import com.example.mapperdemo.repositories.AuthorRepo;

@RestController
@RequestMapping("/authors")
public class AuthorController {
	
	@Autowired
    private MapStructMapper mapstructMapper;

	@Autowired
    private AuthorRepo authorRepository;

    @GetMapping()
    public ResponseEntity<List<AuthorAllDto>> getAll() {
        return new ResponseEntity<>(mapstructMapper.authorsToAuthorAllDtos(authorRepository.findAll()),HttpStatus.OK);
    }
}
