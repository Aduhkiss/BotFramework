package me.atticuszambrana.discord.command.impl;

import java.awt.Color;
import java.util.Map;

import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.event.message.MessageCreateEvent;

import me.atticuszambrana.discord.command.Command;
import me.atticuszambrana.discord.command.CommandManager;

public class HelpCommand extends Command {

	public HelpCommand() {
		super("help", "Display commands you can use :)");
	}

	@Override
	public void execute(String[] args, MessageCreateEvent event) {
		//event.getChannel().sendMessage("Hello World!");
		
		EmbedBuilder embed = new EmbedBuilder();
		
		embed.setColor(Color.pink);
		embed.setTitle("Now Listing Commands");
		
		for(Map.Entry<String, Command> entry : CommandManager.Commands.entrySet()) {
			embed.addField(CommandManager.Prefix + entry.getKey(), entry.getValue().getDescription());
		}
		
		event.getMessageAuthor().asUser().get().sendMessage(embed);
		event.getChannel().sendMessage("I have DM'ed you a list of my commands! <@" + event.getMessageAuthor().getIdAsString() + ">");
	}

}
