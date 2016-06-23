package rocks.astroid.astroid.core.logic.ships;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import rocks.astroid.astroid.core.client.GlobalFunctions;
import rocks.astroid.astroid.core.client.SpriteDisplay;
import rocks.astroid.astroid.core.client.SpritePlus;
import rocks.astroid.astroid.core.logic.weapons.Bullet;
import rocks.astroid.astroid.core.logic.weapons.Projectile;
import rocks.astroid.astroid.core.screens.Play;

/**
 * Fighter - the normal spaceship. Has high mobility, easy weapon (low damage, high frequency), blast ultimate to fire in all directions
 *      Can deploy “satellite” for healing teammates in a certain radius
 */
public class Fighter extends CombatShip {
    private SpritePlus spritePlus;

    /**
     * creates a fighter
     * The server version of a fighter would not use the SpritePlus
     *
     * @param x
     * @param y
     * @param rotation
     */
    public Fighter(float x, float y, float rotation) {
        super(x, y, rotation, 10, 1, 1000, 100, Projectile.Projectiles.Bullet, 5);
        this.spritePlus = new SpritePlus(GlobalFunctions.getSprite(this), location);
        Play.getSpriteDisplay().addSpritePlus(spritePlus);
    }

    @Override
    public void update() {
        super.update();
        spritePlus.setLocation(this.location);
    }
}