package rocks.astroid.astroid.core.logic.ships;

import rocks.astroid.astroid.core.logic.weapons.Projectile;

/**
 * Fighter - the normal spaceship. Has high mobility, easy weapon (low damage, high frequency), blast ultimate to fire in all directions
 *      Can deploy “satellite” for healing teammates in a certain radius
 */
public class Fighter extends CombatShip {
    /**
     * creates a fighter
     *
     * @param x
     * @param y
     * @param rotation
     */
    public Fighter(float x, float y, float rotation) {
        super(x, y, rotation, 10, 1, 1000, 100, Projectile.Projectiles.Bullet, 10);
    }
}