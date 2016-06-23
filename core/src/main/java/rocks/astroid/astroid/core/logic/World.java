package rocks.astroid.astroid.core.logic;

import rocks.astroid.astroid.core.logic.ships.CombatShip;
import rocks.astroid.astroid.core.logic.ships.Ship;
import rocks.astroid.astroid.core.logic.weapons.Projectile;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class World {
    private List<Projectile> projectiles;
    private Collection<Ship> clients;
    private CombatShip player;

    public World(CombatShip player) {
        this.projectiles = new ArrayList<Projectile>();
        this.clients = new ArrayList<Ship>();
        this.player = player;
    }

    public List<Projectile> getProjectiles() {
        return projectiles;
    }

    public Collection<Ship> getClients() {
        return clients;
    }

    public void setClients(Collection<Ship> clients) {
        this.clients = clients;
    }

    public CombatShip getPlayer() {
        return player;
    }

    public void setPlayer(CombatShip player) {
        this.player = player;
    }
}
