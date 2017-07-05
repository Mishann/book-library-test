package com.app.command;

import java.util.Map;
import java.util.TreeMap;

public class Controller {
	// commandType is the key of map
	private Map<String, Command> supportedCommads = new TreeMap<>();
	
	public void addCommand(Command command) {
		
		if(supportedCommads.containsKey(command.getCommandType()))
			throw new IllegalArgumentException();
		
		supportedCommads.put(command.getCommandType().toUpperCase(), command);
	}

	
	public void showAllSupportedCommand(){
		supportedCommads.
			forEach((k,v) -> System.out.println(v.getCommandDescription()));
	}

	public void execute(String unparsedUserInput){
		try{
	// get key
		int indexOfWhiteSpace = unparsedUserInput.indexOf(" ");
			if(indexOfWhiteSpace == -1)
				throw new IllegalArgumentException();
			
		String key = unparsedUserInput.substring(0,indexOfWhiteSpace);
		
		if(!supportedCommads.containsKey(key.toUpperCase()))
			throw new IllegalArgumentException("Unknown command");
	
		// without command type
		String command = unparsedUserInput.substring(unparsedUserInput.indexOf(key)+ key.length());
		
		supportedCommads.get(key.toUpperCase()).execute(command);
		} catch (Exception e) {
			System.err.println("Wrong command! Try again!");
		}
		
		
	}
	
}
