/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.jamy.teambattle;

import org.bukkit.plugin.java.JavaPlugin;
import be.jamy.teambattle.TeamBattleConfig;
import be.jamy.teambattle.commands.TeamBattleCommandListener;
import java.util.logging.Logger;
import org.bukkit.Bukkit;

/**
 *
 * @author Jamy, Joby
 */
public class TeamBattle extends JavaPlugin {
    public static Logger log = Bukkit.getLogger();
    
    private TeamBattleCommandListener command;

    @Override
    public void onEnable() {
        if (getServer().getPluginManager().getPlugin("tagAPI").isEnabled()) {
            log.info("tagAPI found enabling!");
            //RegistertagAPI();
        }
        command = new TeamBattleCommandListener(this);
        this.getServer().getPluginManager().registerEvents(new TeamBattleListener(this), this);
        try {
        getCommand("tb").setExecutor(command);
        getCommand("tbadmin").setExecutor(command);
        } catch (Exception e) {
            
        }
        log.info("TeamBattle has been enabled!");
    }
    
    @Override
    public void onDisable() {
        log.info("TeamBattle has been disabled!");
    }
}
