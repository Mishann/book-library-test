package com.app.command;

import com.app.service.BookService;
import com.app.service.BookServiceImpl;

public class EditBookCommand implements Command{

private BookService bookService = new BookServiceImpl();
	
	@Override
	public void execute(String paramCommand) {
		
	}

	@Override
	public String getCommandDescription() {
		return "Show all books: show books";
	}
	
	@Override
	public String getCommandType() {
		// TODO Auto-generated method stub
		return null;
	}

}
