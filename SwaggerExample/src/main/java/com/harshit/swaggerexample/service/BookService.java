package com.harshit.swaggerexample.service;

import com.harshit.swaggerexample.dao.BookRepository;
import com.harshit.swaggerexample.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public String saveBook(Book book) {
        bookRepository.save(book);
        return "Book saved" + book.getBookId();
    }

    public Book getBook(int bookId) {
        return bookRepository.findById(bookId).get();
    }

    public List<Book> removeBook(int bookId) {
        bookRepository.deleteById(bookId);
        return bookRepository.findAll();
    }
}
