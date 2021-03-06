package com.gmail.Jacob6816.SCBReborn.commands;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import com.gmail.Jacob6816.SCBReborn.arenas.Arena;
import com.gmail.Jacob6816.SCBReborn.arenas.ArenaManager;
import com.gmail.Jacob6816.SCBReborn.utilities.MessageManager;

public class CommandEnableArena extends SCBRCommand {

	public CommandEnableArena() {
		super("Enable", "/SCBReborn Enable (Game)", "en");
	}

	@Override
	public void onCommand(Player player, String... args) {
		if (args.length == 0) {
			MessageManager.messageRecipient(player, getUsage());
			return;
		}
		Arena arena = ArenaManager.getAM().getArena(args[0]);
		if (arena == null) {
			MessageManager.messageRecipient(player, ChatColor.RED + "That arena does not exist");
			return;
		}
		if (arena.tryEnable()) MessageManager.messageRecipient(player, "Arena enabled");
		else MessageManager.messageRecipient(player, ChatColor.RED + "Failed to enable arena");
	}

}
