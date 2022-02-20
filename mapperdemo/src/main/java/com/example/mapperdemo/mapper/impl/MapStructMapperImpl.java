package com.example.mapperdemo.mapper.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.example.mapperdemo.dto.AuthorAllDto;
import com.example.mapperdemo.dto.AuthorDto;
import com.example.mapperdemo.dto.BookDto;
import com.example.mapperdemo.dto.BookSlimDto;
import com.example.mapperdemo.dto.UserGetDto;
import com.example.mapperdemo.entity.Author;
import com.example.mapperdemo.entity.Book;
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

	@Override
	public AuthorAllDto authorToAuthorAllDto(Author author) {
        if ( author == null ) {
            return null;
        }

        AuthorAllDto authorAllDto = new AuthorAllDto();

        authorAllDto.setId( author.getId() );
        authorAllDto.setName( author.getName() );
        authorAllDto.setSurname( author.getSurname() );
        authorAllDto.setBirthDate( author.getBirthDate() );
        authorAllDto.setBooks( bookSetToBookSlimDtoSet( author.getBooks() ) );

        return authorAllDto;
	}

	@Override
	public List<AuthorAllDto> authorsToAuthorAllDtos(List<Author> authors) {
        if ( authors == null ) {
            return null;
        }

        List<AuthorAllDto> list = new ArrayList<AuthorAllDto>( authors.size() );
        for ( Author author : authors ) {
            list.add( authorToAuthorAllDto( author ) );
        }

        return list;
	}
	
    @Override
    public BookSlimDto bookToBookSlimDto(Book book) {
        if ( book == null ) {
            return null;
        }

        BookSlimDto bookSlimDto = new BookSlimDto();

        bookSlimDto.setId( book.getId() );
        bookSlimDto.setTitle( book.getTitle() );

        return bookSlimDto;
    }
    
	@Override
	public BookDto bookToBookDto(Book book) {
        if ( book == null ) {
            return null;
        }

        BookDto bookDto = new BookDto();

        bookDto.setId( book.getId() );
        bookDto.setTitle( book.getTitle() );
        bookDto.setReleaseDate( book.getReleaseDate() );
        bookDto.setAuthors( authorSetToAuthorDtoSet( book.getAuthors() ) );

        return bookDto;
	}
	
    @Override
    public AuthorDto authorToAuthorDto(Author author) {
        if ( author == null ) {
            return null;
        }

        AuthorDto authorDto = new AuthorDto();

        authorDto.setId( author.getId() );
        authorDto.setName( author.getName() );
        authorDto.setSurname( author.getSurname() );
        authorDto.setBirthDate( author.getBirthDate() );

        return authorDto;
    }
	
    protected Set<BookSlimDto> bookSetToBookSlimDtoSet(Set<Book> set) {
        if ( set == null ) {
            return null;
        }

        Set<BookSlimDto> set1 = new HashSet<>();
        for ( Book book : set ) {
            set1.add( bookToBookSlimDto( book ) );
        }

        return set1;
    }
    
    protected Set<AuthorDto> authorSetToAuthorDtoSet(Set<Author> set) {
        if ( set == null ) {
            return null;
        }

        Set<AuthorDto> set1 = new HashSet<AuthorDto>();
        for ( Author author : set ) {
            set1.add( authorToAuthorDto( author ) );
        }

        return set1;
    }


}
