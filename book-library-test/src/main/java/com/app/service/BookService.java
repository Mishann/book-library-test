package com.app.service;

import java.util.List;
import com.app.model.Book;

public interface BookService {
	void add(Book book);
	void update(Book book);
	void delete(Long id);
	List<Book> findAll();
	Book findOne(Long id);
	List<Book> findByTitle(String title);	
	List<Book> sortByTitleAsc(List<Book> books);
}
