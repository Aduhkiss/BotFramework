package me.atticuszambrana.discord.command;

import org.javacord.api.event.message.MessageCreateEvent;

public abstract class Command {
	
	private String name;
	private String description;
	private boolean consoleOnly;
	
	public Command(String name, String description) {
		this.name = name;
		this.description = description;
	}
	
	public Command(String name, String description, boolean consoleOnly) {
		this.name = name;
		this.description = description;
		this.consoleOnly = consoleOnly;
	}
	
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public boolean isConsoleOnly() {
		return consoleOnly;
	}
	
	public abstract void execute(String[] args, MessageCreateEvent event);

}
