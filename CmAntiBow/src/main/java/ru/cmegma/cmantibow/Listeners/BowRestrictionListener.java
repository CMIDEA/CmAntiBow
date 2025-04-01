package ru.cmegma.cmantibow.Listeners;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;
import ru.cmegma.cmantibow.Managers.ConfigurationManager;
import ru.cmegma.cmantibow.Managers.MessageManager;

public class BowRestrictionListener implements Listener {
    private final ConfigurationManager configManager;
    private final MessageManager messageManager;

    public BowRestrictionListener(ConfigurationManager configManager, MessageManager messageManager) {
        this.configManager = configManager;
        this.messageManager = messageManager;
    }

    @EventHandler
    public void onBowUsage(EntityShootBowEvent event) {
        Entity entity = event.getEntity();

        if (!(entity instanceof Player)) {
            return;
        }

        Player player = (Player) entity;
        String currentWorld = player.getWorld().getName();

        if (configManager.isWorldBlocked(currentWorld)) {
            if (!player.hasPermission("cmantibow.bypass")) {
                event.setCancelled(true);
                player.sendMessage(messageManager.getMessage("denial_message"));
            }
        }
    }
}