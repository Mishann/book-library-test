package com.app.command;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;
import com.app.model.Book;
import com.app.service.BookService;
import com.app.service.BookServiceImpl;

public class EditBookCommand implements Command {
	private BookService bookService = new BookServiceImpl();
	private String regexTitle = "\".+\"";
	private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
	private boolean isTitleMatchesRegex(String str){
		if(str.matches(regexTitle))
			return true;
		return false;
	}
	
	@Override
	public void execute(String paramCommand) {
		try {
			String title = paramCommand.trim();
			List<Book> books = bookService.findByTitle(title);

			if (books.isEmpty()) {
				throw new IllegalArgumentException("There no book with title " + title);
			}
			if (books.size() == 1) {
				System.out.println("Input new title of book inside \"\" ");
				String newTitle = reader.readLine();
				
				if(isTitleMatchesRegex(newTitle)){
					Book editedBook = books.get(0);
					editedBook.setTitle(newTitle);
					bookService.update(editedBook);
					System.out.println("Book edited!");	
				} else{
					throw new IllegalArgumentException("Wrong format of title!");
				}
				
			} else {
				// choose which one edit
				System.out.println("There are few books with the same title. Choose number");

				for (int i = 0; i < books.size(); i++) {
					System.out.println(i + 1 + ":" + books.get(i));
				}
				
				Scanner sc = new Scanner(System.in);
				Integer userChoice = sc.nextInt();
					sc.close();
				if (userChoice <= 0 || userChoice > books.size())
					throw new IllegalArgumentException("There no book in list with number " + userChoice);
				else{
					Book bookEdit = books.get(userChoice-1);
					System.out.println("Input new title of book inside \"\" ");
					String newTitle = reader.readLine();
					if(isTitleMatchesRegex(newTitle)){
						bookEdit.setTitle(newTitle);
						bookService.update(bookEdit);
					System.out.println("Book edited!");	
					} else{
						throw new IllegalArgumentException("Wrong format of title!");
					}	
				}
			}
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		}
	}

	@Override
	public String getCommandDescription() {
		return "Edit book: edit \"<book title>\"";
	}

	@Override
	public String getCommandType() {
		return "edit";
	}

}
