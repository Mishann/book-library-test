package com.app.command;

import com.app.service.BookService;
import com.app.service.BookServiceImpl;

public class ShowAllBooksCommand implements Command {

	private BookService bookService = new BookServiceImpl();
	
	@Override
	public void execute(String paramCommand) {
		// param command doesn't required
		bookService.findAll()
					.forEach( book -> System.out.println(book));
	}

	@Override
	public String getCommandDescription() {
		return "Show all books: show books";
	}
	@Override
	public String getCommandType() {
		return "show";
	}

}
