package me.jordyn.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import me.jordyn.DiscordBot;

public class LeaveListener implements Listener{

    private final DiscordBot plugin;
    
    public LeaveListener(DiscordBot plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent e){

        boolean enabled = this.plugin.getConfig().getBoolean("enable-leave-logger");
        if (!enabled){
            return;
        }

        Player player = e.getPlayer();
        String message = player.getName() + " has left";
        this.plugin.sendMessageToDiscordWebhook(message);
        
    }

}

