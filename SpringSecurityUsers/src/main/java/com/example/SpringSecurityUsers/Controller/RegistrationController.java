package com.example.SpringSecurityUsers.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringSecurityUsers.Model.RegistrationRequest;
import com.example.SpringSecurityUsers.Service.RegistrationService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/registration")
public class RegistrationController {
	
    private final RegistrationService registrationService;

    @PostMapping
    public ResponseEntity<String> register(@RequestBody RegistrationRequest request) {
        String result = registrationService.register(request);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }
}
