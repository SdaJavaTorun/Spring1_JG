package com.example.bookstore.service;

import com.example.bookstore.model.Book;
import com.example.bookstore.model.BookListing;
import com.example.bookstore.repository.BookRepository;
import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class BookServiceTest {
    @Test
    public void getListeningData1() throws Exception {
    }

    BookRepository bookRepository;
    BookService bookService;

    @Before
    public void setUp() {
        bookRepository = mock(BookRepository.class); //mockujemy klase ktorej nie chcemy testowac
        bookService = new BookService(bookRepository);
    }
    @Test
    public void getListeningData() throws Exception {
        //given  ?(w przypadku gdy findAll da poniższy rezultat
        when(bookRepository.findAll()).thenReturn(Lists.newArrayList(
                new Book("title1", "autor1"),
                new Book("title2", "autor2")
                )
        );
        //when  (po czym odpalimy poniższą metodę
        BookListing bookListing = bookService.getListeningData();

        //then  (to wyniki będzie następujący)
        assertEquals(
                new BookListing(
                        Lists.newArrayList(new Book("title1", "autor1"),
                                new Book("title2", "autor2")
                        ), 2
                ),
                bookListing);

    }


}

