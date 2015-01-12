package se.fredsfursten.plugintools;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;

public class Misc {
	public static Block getFirstBlockOfMaterial(Material material, Location location, int maxDistance) {
		// Set one corner of the cube to the given location.
		// Uses getBlockN() instead of getN() to avoid casting to an int later.
		int x1 = location.getBlockX(); 
		int y1 = location.getBlockY();
		int z1 = location.getBlockZ();

		World world = location.getWorld();

		for (int distance = 0; distance < maxDistance; distance++) {
			for (int xPoint = x1-distance; xPoint <= x1+distance; xPoint++) {
				int currentDistance = Math.abs(xPoint-x1);
				for (int yPoint = y1-distance; yPoint <= y1+distance; yPoint++) {
					currentDistance += Math.abs(yPoint-y1);
					if (currentDistance > distance) continue;
					for (int zPoint = z1-distance; zPoint <= z1+distance; zPoint++) {
						currentDistance += Math.abs(zPoint-z1);
						if (currentDistance != distance) continue;

						Block currentBlock = world.getBlockAt(xPoint, yPoint, zPoint);
						if (currentBlock.getType() == material) return currentBlock;
					}
				}
			}
		}

		return null;
	}
}
