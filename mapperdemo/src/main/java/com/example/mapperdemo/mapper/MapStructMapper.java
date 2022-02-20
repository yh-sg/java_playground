package com.example.mapperdemo.mapper;

import org.mapstruct.Mapper;

import com.example.mapperdemo.dto.UserGetDto;
import com.example.mapperdemo.entity.User;

@Mapper(componentModel = "spring")
public interface MapStructMapper {
    UserGetDto userToUserGetDto(User user);
}
