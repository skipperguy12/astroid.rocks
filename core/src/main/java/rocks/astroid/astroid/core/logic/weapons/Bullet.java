package rocks.astroid.astroid.core.logic.weapons;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import rocks.astroid.astroid.core.client.GlobalFunctions;
import rocks.astroid.astroid.core.client.SpritePlus;
import rocks.astroid.astroid.core.screens.Play;

/**
 * Simple weapon that is
 */
public class Bullet extends Projectile{
    private Vector3 location;
    private SpritePlus spritePlus;

    public Bullet(float shipSpeed, Vector3 location) {
        super(50, shipSpeed+40, .3f + GlobalFunctions.friction);
        this.location = location;
        spritePlus = new SpritePlus(new Sprite(new Texture("img/sprites/bullet.png")), location, SpritePlus.types.Projectile);
        Play.getSpriteDisplay().addSpritePlus(spritePlus,false);
        GlobalFunctions.projectiles.add(this);
    }

    @Override
    public void update() {
        super.update();
        if (speed == 0)
            Play.getSpriteDisplay().removeSpritePlus(spritePlus);
       // System.out.println(location.z);

        GlobalFunctions.moveLaterally(this);
        spritePlus.setLocation(location);
    }
    public Vector3 getLocation() {
        return location;
    }
    public void setLocation(Vector3 location) {
        this.location = location;
    }



}
