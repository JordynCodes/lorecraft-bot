package me.jordyn.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import me.jordyn.DiscordBot;

public class JoinListener implements Listener{

    private final DiscordBot plugin;
    
    public JoinListener(DiscordBot plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){

        boolean enabled = this.plugin.getConfig().getBoolean("enable-join-logger");
        if (!enabled){
            return;
        }

        Player player = e.getPlayer();
        String message = player.getName() + " has joined";
        this.plugin.sendMessageToDiscordWebhook(message);
        
    }

}