package com.example.mapperdemo.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

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
	
	MapStructMapper INSTANCE = Mappers.getMapper( MapStructMapper.class );
	
    UserGetDto userToUserGetDto(User user);
//	@Mappings({
//		@Mapping(target="id", source="author.id"),
//	})
    AuthorAllDto authorToAuthorAllDto(Author author);
	List<AuthorAllDto> authorsToAuthorAllDtos(List<Author> authors);
	BookSlimDto bookToBookSlimDto(Book book);
    BookDto bookToBookDto(Book book);
    List<BookSlimDto> bookToBookSlimAllDto(List<Book> book);
	AuthorDto authorToAuthorDto(Author author);
}
