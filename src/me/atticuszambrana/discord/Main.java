package me.atticuszambrana.discord;

import java.util.Scanner;

import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.util.logging.ExceptionLogger;

import me.atticuszambrana.discord.command.CommandManager;


public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String TOKEN = null;
		
		if(args.length == 0 || args == null) {
			System.out.println("Please Enter Discord API Token to use: ");
			TOKEN = sc.nextLine();
		} else {
			TOKEN = args[0];
		}
		
		new DiscordApiBuilder()
        .setToken(TOKEN)
        .setRecommendedTotalShards().join()
        .loginAllShards()
        .forEach(shardFuture -> shardFuture
            .thenAccept(Main::onShardLogin)
            .exceptionally(ExceptionLogger.get())
        );
		
		// Start the Command Manager for both in-discord and console
		CommandManager.register();
	}
	
	private static void onShardLogin(DiscordApi api) {
        // Tell Console that we are starting this shard, then actually start everything
		System.out.println("[Bot] Starting Shard: " + api.getCurrentShard());
		api.addListener(new CommandManager());
    }

}
