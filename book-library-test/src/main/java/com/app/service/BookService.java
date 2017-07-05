package com.app.service;

import java.util.List;
import com.app.model.Book;

public interface BookService {

	boolean add(Book book);
	boolean update(Book book);
	boolean delete(Long id);
	List<Book> findAll();
	
	Book findOne(Long id);
	List<Book> findByName(String name);	
}
