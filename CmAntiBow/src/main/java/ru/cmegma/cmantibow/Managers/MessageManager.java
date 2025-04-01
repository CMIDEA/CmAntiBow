package ru.cmegma.cmantibow.Managers;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import ru.cmegma.cmantibow.CmAntiBow;

import java.io.File;

public class MessageManager {
    private final CmAntiBow plugin;
    private FileConfiguration messages;

    public MessageManager(CmAntiBow plugin) {
        this.plugin = plugin;
        reloadMessages();
    }

    public void reloadMessages() {
        File messagesFile = new File(plugin.getDataFolder(), "messages.yml");
        if (!messagesFile.exists()) {
            plugin.saveResource("messages.yml", false);
        }
        messages = YamlConfiguration.loadConfiguration(messagesFile);
    }

    public String getMessage(String key) {
        String rawMessage = messages.getString(key, "&cСообщение не найдено: &f" + key);
        return ChatColor.translateAlternateColorCodes('&', rawMessage);
    }
}