package me.jordyn;

import java.util.logging.Logger;
import org.bukkit.plugin.java.JavaPlugin;
import me.jordyn.listeners.ChatListener;
;
public class DiscordBot extends JavaPlugin {
  private static final Logger LOGGER=Logger.getLogger("DiscordBot");

  public void onEnable() {
    LOGGER.info("DiscordBot enabled");
    getServer().getPluginManager().registerEvents(new ChatListener(), this);
  }

  public void onDisable() {
    LOGGER.info("DiscordBot disabled");
  }
}