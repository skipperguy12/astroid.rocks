package rocks.astroid.astroid.core.logic.ships;

import rocks.astroid.astroid.core.logic.weapons.Projectile;

/**
 *  Engineer - picks up metal from dead players to repurpose into shields for players to pick up.
 */
public class Engineer extends CombatShip {
    public Engineer(float x, float y, float rotation) {
        super(x, y, rotation, 8, 1.5f, 700, 150, Projectile.Projectiles.Bullet,3,null);
    }

}
