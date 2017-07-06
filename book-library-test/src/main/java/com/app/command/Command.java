package com.app.command;

public interface Command {
	void execute(String paramCommand);
	String getCommandType();
	String getCommandDescription();
}
