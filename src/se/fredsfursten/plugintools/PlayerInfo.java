package se.fredsfursten.plugintools;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.entity.Player;

public class PlayerInfo<T> {
	private HashMap<UUID, T> playerInfo = null;

	public PlayerInfo() {
		this.playerInfo = new HashMap<UUID, T>();
	}
	
	public void put(Player player, T info) {
		UUID id = player.getUniqueId();
		put(id, info);
	}

	private void put(UUID id, T info) {
		this.playerInfo.put(id, info);
	}
	
	public T get(Player player) {
		UUID id = player.getUniqueId();
		return get(id);
	}

	private T get(UUID id) {
		return this.playerInfo.get(id);
	}
	
	public boolean hasInformation(Player player) {
		UUID id = player.getUniqueId();
		return hasInformation(id);
	}

	private boolean hasInformation(UUID id) {
		return this.playerInfo.containsKey(id);
	}
	
	public void remove(Player player) {
		UUID id = player.getUniqueId();
		this.playerInfo.remove(id);
	}
}