package net.envexus.playertaghider;

import org.bukkit.plugin.java.JavaPlugin;

public final class PlayerTagHider extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new JoinLeaveEvents(this), this);

    }

}
