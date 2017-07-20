package nl.imine.gladiator.enemy;

import nl.imine.gladiator.data.common.CustomAttribute;
import nl.imine.gladiator.data.common.CustomLocation;
import org.bukkit.entity.EntityType;

import java.io.Serializable;
import java.util.List;

public class Enemy implements Serializable {

    private String customName;
    private int count;
    private EntityType entityType;
    private CustomLocation spawnLocation;
    private Equipment equipment;
    private List<CustomAttribute> attributes;

    public Enemy() {
    }

    public Enemy(String customName, int count, EntityType entityType, CustomLocation spawnLocation, Equipment equipment, List<CustomAttribute> attributes) {
        this.customName = customName;
        this.count = count;
        this.entityType = entityType;
        this.spawnLocation = spawnLocation;
        this.equipment = equipment;
        this.attributes = attributes;
    }

    public String getCustomName() {
        return customName;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
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

    public List<CustomAttribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<CustomAttribute> attributes) {
        this.attributes = attributes;
    }

    @Override
    public String toString() {
        return "Enemy{" +
                "customName='" + customName + '\'' +
                ", entityType=" + entityType +
                ", spawnLocation=" + spawnLocation +
                ", equipment=" + equipment +
                ", attribute=" + attributes +
                '}';
    }
}
