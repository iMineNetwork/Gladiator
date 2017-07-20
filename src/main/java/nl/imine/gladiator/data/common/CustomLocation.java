package nl.imine.gladiator.data.common;

import org.bukkit.Bukkit;
import org.bukkit.Location;

import java.io.Serializable;
import java.util.UUID;

public class CustomLocation implements Serializable {

    private UUID uuid;
    private double x;
    private double y;
    private double z;
    private float yaw;
    private float pitch;

    public CustomLocation() {
    }

    public CustomLocation(UUID uuid, double x, double y, double z, float yaw, float pitch) {
        this.uuid = uuid;
        this.x = x;
        this.y = y;
        this.z = z;
        this.yaw = yaw;
        this.pitch = pitch;
    }

    public Location toBukkitLocation() {
        return new Location(Bukkit.getWorld(uuid),
                x,
                y,
                z,
                yaw,
                pitch
        );
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public float getYaw() {
        return yaw;
    }

    public void setYaw(float yaw) {
        this.yaw = yaw;
    }

    public float getPitch() {
        return pitch;
    }

    public void setPitch(float pitch) {
        this.pitch = pitch;
    }

    @Override
    public String toString() {
        return "CustomLocation{" +
                "uuid=" + uuid +
                ", x=" + x +
                ", y=" + y +
                ", z=" + z +
                ", yaw=" + yaw +
                ", pitch=" + pitch +
                '}';
    }
}
