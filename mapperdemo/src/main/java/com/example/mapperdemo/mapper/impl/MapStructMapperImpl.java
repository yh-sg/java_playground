package com.example.mapperdemo.mapper.impl;

import org.springframework.stereotype.Component;

import com.example.mapperdemo.dto.UserGetDto;
import com.example.mapperdemo.entity.User;
import com.example.mapperdemo.mapper.MapStructMapper;

@Component
public class MapStructMapperImpl implements MapStructMapper {
    @Override
    public UserGetDto userToUserGetDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserGetDto userGetDto = new UserGetDto();

        userGetDto.setId( user.getId() );
        userGetDto.setEmail( user.getEmail() );
        userGetDto.setName( user.getName() );
        userGetDto.setSurname( user.getSurname() );

        return userGetDto;
    }
}
