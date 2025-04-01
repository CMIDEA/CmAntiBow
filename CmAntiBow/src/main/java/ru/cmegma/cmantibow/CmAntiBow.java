package ru.cmegma.cmantibow;

import org.bukkit.plugin.java.JavaPlugin;
import org.bstats.bukkit.Metrics;
import ru.cmegma.cmantibow.Commands.ReloadCommand;
import ru.cmegma.cmantibow.Listeners.BowRestrictionListener;
import ru.cmegma.cmantibow.Managers.ConfigurationManager;
import ru.cmegma.cmantibow.Managers.MessageManager;

public class CmAntiBow extends JavaPlugin {
    private ConfigurationManager configManager;
    private MessageManager messageManager;

    @Override
    public void onEnable() {
        new Metrics(this, 25158);
        saveDefaultConfig();
        saveResource("messages.yml", false);

        configManager = new ConfigurationManager(this);
        messageManager = new MessageManager(this);

        getCommand("cmantibow").setExecutor(new ReloadCommand(this));
        getServer().getPluginManager().registerEvents(new BowRestrictionListener(configManager, messageManager), this);
    }

    public ConfigurationManager getConfigManager() {
        return configManager;
    }

    public MessageManager getMessageManager() {
        return messageManager;
    }
}