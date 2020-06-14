package de.marvinleiers.servermonitor;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import java.text.DecimalFormat;

public final class ServerMonitor extends JavaPlugin
{

    @Override
    public void onEnable()
    {
        this.getCommand("t").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        DecimalFormat decimalFormat = new DecimalFormat("##.##");

        double tps = Bukkit.getServer().getTPS()[0];

        String color = "§a";

        if (tps <= 8)
            color = "§4";
        else if (tps <= 12)
            color = "§c";
        else if (tps <= 16)
            color = "§e";

        if (tps > 20)
            tps = 20;

        sender.sendMessage(color + "TPS: " + decimalFormat.format(tps));

        return true;
    }

    @Override
    public void onDisable()
    {
    }
}
