package rocks.astroid.astroid.core.logic.weapons;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import rocks.astroid.astroid.core.client.GlobalFunctions;

/**
 * Simple weapon that is
 */
public class Bullet extends Projectile{
    private SpriteBatch batch;
    private Sprite bullet;
    private Vector3 location;

    public Bullet() {
        super(50, 1000, 20, 1 + GlobalFunctions.friction);
        bullet = new Sprite(new Texture("img/sprites/bullet.png"));
    }
    public Bullet(float shipSpeed, Vector3 location) {
        super(50, 1000, shipSpeed+20, 1 + GlobalFunctions.friction);
        bullet = new Sprite(new Texture("img/sprites/bullet.png"));
        this.location = location;
    }
    public void draw()
    {

    }



}
