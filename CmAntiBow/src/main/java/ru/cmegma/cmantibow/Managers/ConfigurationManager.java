package ru.cmegma.cmantibow.Managers;

import org.bukkit.configuration.file.FileConfiguration;
import ru.cmegma.cmantibow.CmAntiBow;
import java.util.List;

public class ConfigurationManager {
    private final CmAntiBow plugin;
    private List<String> blockedWorlds;

    public ConfigurationManager(CmAntiBow plugin) {
        this.plugin = plugin;
        reloadConfiguration();
    }

    public void reloadConfiguration() {
        plugin.saveDefaultConfig();
        FileConfiguration config = plugin.getConfig();
        blockedWorlds = config.getStringList("blocked_worlds");
    }

    public boolean isWorldBlocked(String worldName) {
        return blockedWorlds.contains(worldName);
    }
}