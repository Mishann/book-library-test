package com.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.app.command.AddBookCommand;
import com.app.command.Command;
import com.app.command.Controller;
import com.app.command.DeleteBookCommand;
import com.app.command.EditBookCommand;
import com.app.command.ShowAllBooksCommand;
import com.app.utils.WrapperScanner;

public class Main {
	private static Controller controller = new Controller();
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
