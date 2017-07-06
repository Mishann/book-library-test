package com.app.command;

import java.util.List;
import com.app.model.Book;
import com.app.service.BookService;
import com.app.service.BookServiceImpl;

public class ShowAllBooksCommand implements Command {
	private BookService bookService = new BookServiceImpl();
	
	@Override
	public void execute(String paramCommand) {
		// paramCommand doesn't required	
		List<Book> allBooks = bookService.findAll();
		List<Book> booksSortedByTitleAsc = bookService.sortByTitleAsc(allBooks);
		
		booksSortedByTitleAsc
					.forEach( book -> System.out.println(book));
	}

	@Override
	public String getCommandDescription() {
		return "Show all books: show books";
	}
	@Override
	public String getCommandType() {
		return "show books";
	}
}
