package me.jordyn.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import me.jordyn.DiscordBot;

public class ChatListener implements Listener {

    private final DiscordBot plugin;

    public ChatListener(DiscordBot plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {

        boolean enabled = this.plugin.getConfig().getBoolean("enable-chat-logger");
        if (!enabled){
            return;
        }
        
        String message = e.getPlayer().getName() + ": " + e.getMessage();
        this.plugin.sendMessageToDiscordWebhook(message);

    }

}