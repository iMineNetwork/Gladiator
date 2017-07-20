package nl.imine.gladiator.enemy;

import nl.imine.gladiator.data.common.CustomAttribute;
import nl.imine.gladiator.data.common.CustomLocation;
import org.bukkit.entity.EntityType;

import java.io.Serializable;

public class Enemy implements Serializable {

    private String customName;
    private EntityType entityType;
    private CustomLocation spawnLocation;
    private Equipment equipment;
    private CustomAttribute attribute;

    public Enemy() {
    }

    public Enemy(String customName, EntityType entityType, CustomLocation spawnLocation, Equipment equipment, CustomAttribute attribute) {
        this.customName = customName;
        this.entityType = entityType;
        this.spawnLocation = spawnLocation;
        this.equipment = equipment;
        this.attribute = attribute;
    }

    public String getCustomName() {
        return customName;
    }

    public void setCustomName(String customName) {
        this.customName = customName;
    }

    public EntityType getEntityType() {
        return entityType;
    }

    public void setEntityType(EntityType entityType) {
        this.entityType = entityType;
    }

    public CustomLocation getSpawnLocation() {
        return spawnLocation;
    }

    public void setSpawnLocation(CustomLocation spawnLocation) {
        this.spawnLocation = spawnLocation;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public CustomAttribute getAttribute() {
        return attribute;
    }

    public void setAttribute(CustomAttribute attribute) {
        this.attribute = attribute;
    }

    @Override
    public String toString() {
        return "Enemy{" +
                "customName='" + customName + '\'' +
                ", entityType=" + entityType +
                ", spawnLocation=" + spawnLocation +
                ", equipment=" + equipment +
                ", attribute=" + attribute +
                '}';
    }
}
