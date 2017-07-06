package com.app.command;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Controller {
	// commandType is the key of map
	private Map<String, Command> supportedCommads = new HashMap<>();

	public void addCommand(Command command) {

		if (supportedCommads.containsKey(command.getCommandType()))
			throw new IllegalArgumentException();

		supportedCommads.put(command.getCommandType().toUpperCase(), command);
	}

	public void showAllSupportedCommand() {
		supportedCommads.forEach((k, v) -> System.out.println(v.getCommandDescription()));
	}

	public void execute(String unparsedUserInput) {
		// parse commandType
		try {
			String commandType = null;
			for (String type : supportedCommads.keySet()) {
				if (unparsedUserInput.toUpperCase().startsWith(type))
					commandType = type;
			}
			if (commandType == null)
				throw new IllegalArgumentException("Wrong command");

			// pass command further withot command type
			String command = unparsedUserInput
					.substring(unparsedUserInput.toUpperCase().indexOf(commandType) + commandType.length());

			supportedCommads.get(commandType).execute(command);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}

}
