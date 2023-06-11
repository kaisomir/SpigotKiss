package io.github.kaisomir;

import org.bukkit.Bukkit;
import org.bukkit.Particle;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class SpigotKiss extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
        // getLogger().info("onEnable is called!");
    }
    @Override
    public void onDisable() {
        // getLogger().info("onDisable is called!");
    }

    @EventHandler
    public void PlayerInteractEntityEvent(PlayerInteractEntityEvent event)
    {
        Player p = event.getPlayer();
        Entity interacted = event.getRightClicked();
        if (interacted.getType().equals(EntityType.PLAYER) && p.isSneaking())
        {
            p.getWorld().spawnParticle(Particle.HEART, interacted.getLocation().add(Math.random()-0.5,1.8+Math.random()*0.5-0.25,Math.random()-0.5),1);
        }
    }
}