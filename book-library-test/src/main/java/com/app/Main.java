package com.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import com.app.command.AddBookCommand;
import com.app.command.BookController;
import com.app.command.DeleteBookCommand;
import com.app.command.EditBookCommand;
import com.app.command.ShowAllBooksCommand;


public class Main {
	private static BookController controller = new BookController();
	private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
	private static void init() {
		controller.addCommand(new AddBookCommand());
		controller.addCommand(new EditBookCommand());
		controller.addCommand(new DeleteBookCommand());
		controller.addCommand(new ShowAllBooksCommand());
	}

	public static void main(String[] args) throws IOException {
		init();
		controller.showAllSupportedCommand();
		while (true) {
			String userInput = reader.readLine();
			controller.execute(userInput);
		}
	}
}
