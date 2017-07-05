package com.app.dao;

import java.util.List;
import com.app.model.Book;

public interface BookDao {

	boolean add(Book book);
	boolean update(Book book);
	boolean delete(Long id);
	List<Book> findAll();
	
	Book findOne(Long id);
	List<Book> findByTitle(String title);
	
}
