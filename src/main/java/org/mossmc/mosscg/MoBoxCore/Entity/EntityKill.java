package org.mossmc.mosscg.MoBoxCore.Entity;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;

import java.util.ArrayList;
import java.util.List;

public class EntityKill {
    public static List<EntityType> killList = new ArrayList<>();

    public static void killAllWorldTargetEntity() {
        Bukkit.getWorlds().forEach(EntityKill::killWorldTargetEntity);
    }

    public static void killAllWorldAllEntity() {
        Bukkit.getWorlds().forEach(EntityKill::killWorldAllEntity);
    }

    public static void killWorldTargetEntity(World world) {
        world.getEntities().forEach(entity -> {
            if (killList.contains(entity.getType())) {
                entity.remove();
            }
        });
    }

    public static void killWorldAllEntity(World world) {
        world.getEntities().forEach(Entity::remove);
    }

    public static void addKillList(EntityType type) {
        if (!killList.contains(type)) {
            killList.add(type);
        }
    }

    public static void clearKillList() {
        killList.clear();
    }

    public static void removeKillList(EntityType type) {
        killList.remove(type);
    }
}
