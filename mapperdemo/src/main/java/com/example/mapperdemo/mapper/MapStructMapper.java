package com.example.mapperdemo.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.example.mapperdemo.dto.AuthorAllDto;
import com.example.mapperdemo.dto.AuthorDto;
import com.example.mapperdemo.dto.BookDto;
import com.example.mapperdemo.dto.BookSlimDto;
import com.example.mapperdemo.dto.UserGetDto;
import com.example.mapperdemo.entity.Author;
import com.example.mapperdemo.entity.Book;
import com.example.mapperdemo.entity.User;

@Mapper(componentModel = "spring")
public interface MapStructMapper {
    UserGetDto userToUserGetDto(User user);
    AuthorAllDto authorToAuthorAllDto(Author author);
    List<AuthorAllDto> authorsToAuthorAllDtos(List<Author> authors);
	BookSlimDto bookToBookSlimDto(Book book);
    BookDto bookToBookDto(Book book);
	AuthorDto authorToAuthorDto(Author author);
}
