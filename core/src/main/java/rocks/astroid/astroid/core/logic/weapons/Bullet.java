package rocks.astroid.astroid.core.logic.weapons;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Simple weapon that is
 */
public class Bullet extends Projectile{
    private SpriteBatch batch;
    private Sprite bullet;

    public Bullet(float damage, float range, float intialSpeed, float resistance){
        super(damage, range, intialSpeed, resistance);
        bullet = new Sprite(new Texture("img/sprites/ships/fighter/ship_blue.png"));//change with different teams
    }
    public void draw()
    {

    }



}
