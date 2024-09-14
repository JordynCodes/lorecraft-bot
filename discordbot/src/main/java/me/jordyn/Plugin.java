package me.jordyn;

import java.util.logging.Logger;
import org.bukkit.plugin.java.JavaPlugin;

/*
 * discordbot java plugin
 */
public class Plugin extends JavaPlugin
{
  private static final Logger LOGGER=Logger.getLogger("discordbot");

  public void onEnable()
  {
    LOGGER.info("discordbot enabled");
  }

  public void onDisable()
  {
    LOGGER.info("discordbot disabled");
  }
}
