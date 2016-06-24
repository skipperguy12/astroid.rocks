package rocks.astroid.astroid.core.logic.weapons;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector3;
import rocks.astroid.astroid.core.client.GlobalFunctions;
import rocks.astroid.astroid.core.client.SpritePlus;
import rocks.astroid.astroid.core.screens.Play;

/**
 * Simple weapon that is
 */
public class Bullet extends Projectile{
    public Bullet(float shipSpeed, Vector3 location) {
        super(5, 40, .3f ,shipSpeed,location,new SpritePlus(new Sprite(new Texture("img/sprites/bullet.png")), location, SpritePlus.types.PROJECTILE));
    }




}
