package com.app.dao;

import java.util.List;
import com.app.model.Book;

public interface BookDao {
	void add(Book book);
	void update(Book book);
	void delete(Long id);
	Book findOne(Long id);
	List<Book> findAll();
	List<Book> findByTitle(String title);
}
