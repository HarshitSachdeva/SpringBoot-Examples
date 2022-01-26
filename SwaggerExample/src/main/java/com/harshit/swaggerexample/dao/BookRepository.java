package com.harshit.swaggerexample.dao;

import com.harshit.swaggerexample.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Integer> {
}
