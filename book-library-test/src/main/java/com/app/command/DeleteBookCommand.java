package com.app.command;

import java.util.List;
import java.util.Scanner;
import com.app.model.Book;
import com.app.service.BookService;
import com.app.service.BookServiceImpl;

public class DeleteBookCommand implements Command {
	private BookService bookService = new BookServiceImpl();
	
	@Override
	public void execute(String paramCommand) {		
		try{
			String title = paramCommand.trim();
			List<Book> books =  bookService.findByTitle(title);
		
		if(books.isEmpty())
			throw new IllegalArgumentException("No book with title "+ title);
		
		else if(books.size() == 1){
			bookService.delete(books.get(0).getId());
			System.out.println(books.get(0)+" removed!");
		} else{
			// choose which one remove
			System.out.println("There are few books with the same title. Choose number");
			
			for (int i = 0; i < books.size(); i++) {
				System.out.println(i+1 + ":" +books.get(i));	
			}
			
			Scanner sc = new Scanner(System.in);
			int userChoice = sc.nextInt();
				sc.close();
			if(userChoice <= 0 || userChoice > books.size())
				throw new IllegalArgumentException("There no book in list with number " + userChoice);
			else{
				Book bookToDelete = books.get(userChoice-1);
				bookService.delete(bookToDelete.getId());
				System.out.println(books.get(0)+" removed!");
			}	
		}
			} catch (Exception e) {
			System.err.println(e.getMessage());	
		}	
	}

	@Override
	public String getCommandDescription() {
		return "Delete book: delete \"<book title>\" ";
	}

	@Override
	public String getCommandType() {
		return "delete";
	}
}
