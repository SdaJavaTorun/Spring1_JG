package com.example.bookstore.service;

import com.example.bookstore.model.Book;
import com.example.bookstore.model.BookListing;
import com.example.bookstore.repository.BookRepository;
import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;


@RunWith(SpringRunner.class)
@SpringBootTest
public class BookService2Test {

    @Autowired    // wstrzykujemy instancje dwoch klas w testach mozemy olac konstruktor
    BookRepository bookRepository;
    @Autowired
    BookService bookService;

    @Before
    public void setUp(){
        // bookReposirtory.delateAll();  // powinnismy wyzerowac instancje przed kazdym testem
        bookRepository.save(new Book("ksiazka 1", "autor 1"));
        bookRepository.save(new Book("ksiazka 2", "autor 2"));
    }

    @Test
    public void getListeningData() throws Exception {
        //given  ?(w przypadku gdy findAll da poniższy rezultat
        // moze byc puste bo wsrzyknelismy i stwozylismy ksiazki

        //when  (po czym odpalimy poniższą metodę
        BookListing bookListing = bookService.getListeningData();

        //then  (to wyniki będzie następujący)
        assertEquals(
                new BookListing(
                        Lists.newArrayList(new Book("ksiazka 1", "autor 1"),
                                new Book("ksiazka 2", "autor 2")
                        ), 2
                ),
                bookListing);

    }

}
