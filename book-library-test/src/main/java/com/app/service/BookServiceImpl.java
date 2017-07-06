package com.app.service;

import java.util.List;

import com.app.comparator.BookTitleComparator;
import com.app.dao.BookDao;
import com.app.dao.BookDaoImpl;
import com.app.model.Book;

public class BookServiceImpl implements BookService {
	private BookDao bookDao = new BookDaoImpl();
	
	@Override
	public void add(Book book) {
		bookDao.add(book);
	}
	@Override
	public void update(Book book) {
		bookDao.update(book);	
	}
	@Override
	public void delete(Long id) {
		bookDao.delete(id);
	}
	@Override
	public List<Book> findAll() {
		return bookDao.findAll();
	}
	@Override
	public Book findOne(Long id) {
		return bookDao.findOne(id);
	}
	@Override
	public List<Book> findByTitle(String title) {
		return bookDao.findByTitle(title);
	}
	@Override
	public List<Book> sortByTitleAsc(List<Book> books) {
		 books.sort(new BookTitleComparator());
		 return books;
	}
}
