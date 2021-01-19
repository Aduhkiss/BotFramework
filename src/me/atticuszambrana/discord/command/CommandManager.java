package me.atticuszambrana.discord.command;

import java.util.HashMap;
import java.util.Map;

import org.javacord.api.entity.user.User;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

import me.atticuszambrana.discord.command.impl.HelpCommand;
import me.atticuszambrana.discord.util.StringUtil;

public class CommandManager implements MessageCreateListener {
	
	public static Map<String, Command> Commands = new HashMap<>();
	public static String Prefix = "//";
	
	public static void register() {
		add(new HelpCommand());
	}

	private static void add(Command cmd) {
		Commands.put(cmd.getName(), cmd);
	}
	
    @Override
    public void onMessageCreate(MessageCreateEvent event) {
		
		if(event.getMessageContent().startsWith(Prefix)) {
			for(Map.Entry<String, Command> ent : Commands.entrySet()) {
				String name = ent.getKey();
				Command cmd = ent.getValue();
				
				if(event.getMessageContent().startsWith(Prefix + name)) {
					User author = event.getMessageAuthor().asUser().get();
					cmd.execute(StringUtil.toArrayWithoutFirst(event.getMessageContent()), event);
					System.out.println("[{SHARD " + event.getApi().getCurrentShard() + "} COMMAND] " + author.getDiscriminatedName() + " has run " + Prefix + name);
				}
			}
		}
    	
    }
}
