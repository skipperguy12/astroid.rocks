package rocks.astroid.astroid.core.logic.ships;

import rocks.astroid.astroid.core.client.GlobalFunctions;
import rocks.astroid.astroid.core.logic.weapons.Projectile;
import rocks.astroid.astroid.physics.Body;
import rocks.astroid.astroid.physics.Polygon;
import rocks.astroid.astroid.physics.Vec2;

/**
 * Fighter - the normal spaceship. Has high mobility, easy weapon (low damage, high frequency), blast ultimate to fire in all directions
 *      Can deploy “satellite” for healing teammates in a certain radius
 */
public class Fighter extends CombatShip {


    /*
    15.0,34.76
    15.0,18.0
    23.0,1.78
    28.6,12.44
    28.6,10.04
    23.0,4.68
    15.0,4.44
    15.0,-12.52
    60,11.3
     */

    /**
     * creates a fighter
     *
     * @param x
     * @param y
     * @param rotation
     */
    public Fighter(float x, float y, float rotation) {
        super(x, y, rotation, 1000, 100, Projectile.Projectiles.Bullet, 10,
                new Polygon(
                        new Vec2(15.0f,34.76f),
                        new Vec2(15.0f,18.0f),
                        new Vec2(23.0f,1.78f),
                        new Vec2(28.6f,12.44f),
                        new Vec2(28.6f,10.04f),
                        new Vec2(23.0f,4.68f),
                        new Vec2(15.0f,4.44f),
                        new Vec2(15.0f,-12.52f),
                        new Vec2(60.0f,11.3f)
                ));
    }
}