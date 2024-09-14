package me.jordyn;

import java.util.logging.Logger;
import org.bukkit.plugin.java.JavaPlugin;
import me.jordyn.listeners.ChatListener;
import me.jordyn.listeners.JoinListener;
import me.jordyn.listeners.LeaveListener;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class DiscordBot extends JavaPlugin {
  private static final Logger LOGGER=Logger.getLogger("DiscordBot");

  public void onEnable() {
    LOGGER.info("DiscordBot enabled");
    this.saveDefaultConfig();
    getServer().getPluginManager().registerEvents(new ChatListener(this), this);
    getServer().getPluginManager().registerEvents(new JoinListener(this), this);
    getServer().getPluginManager().registerEvents(new LeaveListener(this), this);
  }

  public void onDisable() {
    LOGGER.info("DiscordBot disabled");
  }

  public void sendMessageToDiscordWebhook(String message) {
    try {
        String webhook = this.getConfig().getString("webhook-url");
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