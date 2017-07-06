package com.app.command;

import com.app.model.Book;
import com.app.service.BookService;
import com.app.service.BookServiceImpl;

public class AddBookCommand implements Command {
	private BookService bookService = new BookServiceImpl();

	// format: <author> "<title>"
	String regex = ".*\\s\".+\"";

	@Override
	public void execute(String paramCommand) {
		// parse command
		try {
			if (!paramCommand.matches(regex))
				throw new IllegalArgumentException("Wrong command!");

			paramCommand = paramCommand.trim();

			String author = paramCommand.substring(0, paramCommand.indexOf("\"")).trim();
			String title = paramCommand.substring(paramCommand.indexOf("\"")).trim();

			if(author.isEmpty() || title.isEmpty())
				throw new IllegalArgumentException("Wrong command");
		
			Book book = new Book();
			book.setAuthor(author);
			book.setTitle(title);

			// save to DB
			bookService.add(book);

			System.out.println(book + " added!");
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		}
	}

	@Override
	public String getCommandDescription() {
		return "Add new book: add <author> \"<book title>\" ";
	}
	
	@Override
	public String getCommandType() {
		return "add";
	}
}
