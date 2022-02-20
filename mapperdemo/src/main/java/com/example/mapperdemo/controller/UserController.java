package com.example.mapperdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mapperdemo.dto.UserGetDto;
import com.example.mapperdemo.mapper.MapStructMapper;
import com.example.mapperdemo.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
    private MapStructMapper mapstructMapper;

	@Autowired
    private UserService userService;
	
    @GetMapping("/{id}")
    public ResponseEntity<UserGetDto> getById(@PathVariable(value = "id") int id) {
        return new 
        		ResponseEntity<>(mapstructMapper.userToUserGetDto(userService.getOneUser(id)),HttpStatus.OK);
    }
}
