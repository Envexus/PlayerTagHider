package net.envexus.playertaghider;

import jdk.jfr.internal.Logger;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class JoinLeaveEvents implements Listener {

    private final PlayerTagHider plugin;


    public JoinLeaveEvents(PlayerTagHider plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        Scoreboard scoreboard = Bukkit.getScoreboardManager().getMainScoreboard();

        Team team = scoreboard.getTeam("hideNames");

        if(team == null) {
            team = scoreboard.registerNewTeam("hideNames");
        }

        team.setOption(Team.Option.NAME_TAG_VISIBILITY, Team.OptionStatus.NEVER);
        team.addEntry(player.getName());
        plugin.getLogger().info(player.getName() + "was added to the 'hideNames' Team");
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        Scoreboard scoreboard = Bukkit.getScoreboardManager().getMainScoreboard();
        Team team = scoreboard.getTeam("hideNames");

        if (team != null) {
            team.removeEntry(player.getName());
        }
    }

}
