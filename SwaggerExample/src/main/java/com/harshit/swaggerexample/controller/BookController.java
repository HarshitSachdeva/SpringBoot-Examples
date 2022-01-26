package com.harshit.swaggerexample.controller;

import com.harshit.swaggerexample.model.Book;
import com.harshit.swaggerexample.service.BookService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    @ApiOperation(value = "Saving Books")
    public String saveBook(@RequestBody Book book) {
        return bookService.saveBook(book);
    }

    @GetMapping("/searchBook/{bookId}")
    public Book getBook(@PathVariable int bookId) {
        return bookService.getBook(bookId);
    }

    @DeleteMapping("/deleteBook/{bookId}")
    public List<Book> deleteBook(@PathVariable int bookId) {
        return bookService.removeBook(bookId);
    }
}
