package me.jordyn.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

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
        sendChatToDiscord(message);

    }

    private void sendChatToDiscord(String message) {
        try {
            String webhook = this.plugin.getConfig().getString("webhook-url");
            if (webhook == null || webhook == ""){
                return;
            }

            URL url = new URL(webhook);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);
    
            String jsonPayload = "{\"content\": \"" + message + "\"}";
    
            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = jsonPayload.getBytes("utf-8");
                os.write(input, 0, input.length);
            }
    
            connection.getInputStream();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    

}