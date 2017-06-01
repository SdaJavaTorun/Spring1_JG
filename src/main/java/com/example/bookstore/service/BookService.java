package com.example.bookstore.service;


import com.example.bookstore.model.Book;
import com.example.bookstore.model.BookListing;
import com.example.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sun.misc.Contended;

import java.util.List;

@Component
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }
    public BookListing getListeningData() {
        List<Book> books = bookRepository.findAll();

        return new BookListing(books, books.size());
    }

    public void addBook(Book book){
        bookRepository.save(book);
    }
    public void deleteBook(int i){
        bookRepository.delete(i);
    }


}
