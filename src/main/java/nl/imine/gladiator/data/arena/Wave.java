package nl.imine.gladiator.data.arena;

import nl.imine.gladiator.enemy.Enemy;

import java.io.Serializable;
import java.util.List;

public class Wave implements Serializable {

    private List<Enemy> enemySpawns;

    public Wave() {
    }

    public Wave(List<Enemy> enemySpawns) {
        this.enemySpawns = enemySpawns;
    }

    public List<Enemy> getEnemySpawns() {
        return enemySpawns;
    }

    public void setEnemySpawns(List<Enemy> enemySpawns) {
        this.enemySpawns = enemySpawns;
    }

    @Override
    public String toString() {
        return "Wave{" +
                "enemySpawns=" + enemySpawns +
                '}';
    }
}
