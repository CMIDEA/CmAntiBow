package ru.cmegma.cmantibow.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import ru.cmegma.cmantibow.CmAntiBow;

public class ReloadCommand implements CommandExecutor {
    private final CmAntiBow plugin;

    public ReloadCommand(CmAntiBow plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!sender.hasPermission("cmantibow.reload")) {
            sender.sendMessage(plugin.getMessageManager().getMessage("no_permission"));
            return true;
        }

        if (args.length == 1 && args[0].equalsIgnoreCase("reload")) {
            plugin.getConfigManager().reloadConfiguration();
            plugin.getMessageManager().reloadMessages();
            sender.sendMessage(plugin.getMessageManager().getMessage("reload_message"));
            return true;
        }

        return false;
    }
}