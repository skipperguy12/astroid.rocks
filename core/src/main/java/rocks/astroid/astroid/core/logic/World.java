package rocks.astroid.astroid.core.logic;

import rocks.astroid.astroid.core.logic.astroids.Astroid;
import rocks.astroid.astroid.core.logic.ships.CombatShip;
import rocks.astroid.astroid.core.logic.ships.Ship;
import rocks.astroid.astroid.core.logic.weapons.Projectile;
import rocks.astroid.astroid.physics.PhysicsScene;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class World {
    private Collection<Astroid> astroids;
    private List<Projectile> projectiles;
    private Collection<Ship> clients;
    private CombatShip player;
    private PhysicsScene physicsScene;

    public World(CombatShip player) {
        this.projectiles = new ArrayList<Projectile>();
        this.clients = new ArrayList<Ship>();
        this.player = player;
        this.astroids = new ArrayList<Astroid>();
        this.physicsScene = new PhysicsScene(0f, 0);
    }

    public List<Projectile> getProjectiles() {
        return projectiles;
    }

    public Collection<Ship> getClients() {
        return clients;
    }

    public Collection<Astroid> getAstroids() {
        return astroids;
    }

    public void setClients(Collection<Ship> clients) {
        this.clients = clients;
    }

    public void setAstroids(Collection<Astroid> astroids) {
        this.astroids = astroids;
    }
    public void setProjectiles(List<Projectile> projectiles) {
        this.projectiles = projectiles;
    }

    public CombatShip getPlayer() {
        return player;
    }

    public void setPlayer(CombatShip player) {
        this.player = player;
    }


}
