package dev._2lstudios.jelly.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import dev._2lstudios.jelly.JellyPlugin;
import dev._2lstudios.jelly.player.PluginPlayer;

public class CommandContext {

    private final CommandArguments arguments;
    private final JellyPlugin plugin;
    private final CommandSender sender;

    private final boolean isPlayer;

    private PluginPlayer pluginPlayer;

    public CommandContext(final JellyPlugin plugin, final CommandSender sender, final CommandArguments arguments) {
        this.arguments = arguments;
        this.plugin = plugin;
        this.sender = sender;

        this.isPlayer = sender instanceof Player;

        if (plugin.getPluginPlayerManager() != null && this.isExecutedByPlayer()) {
            this.pluginPlayer = plugin.getPluginPlayerManager().getPlayer(this.getPlayer());
        }
    }

    public CommandArguments getArguments() {
        return this.arguments;
    }

    public boolean isExecutedByPlayer() {
        return this.isPlayer;
    }

    public Player getPlayer() {
        if (this.isExecutedByPlayer()) {
            return (Player) this.sender;
        } else {
            return null;
        }
    }

    public PluginPlayer getPluginPlayer() {
        return this.pluginPlayer;
    }

    public JellyPlugin getPlugin() {
        return this.plugin;
    }

    public CommandSender getSender() {
        return this.sender;
    }
}
