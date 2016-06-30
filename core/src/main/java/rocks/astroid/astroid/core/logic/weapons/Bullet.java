package rocks.astroid.astroid.core.logic.weapons;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector3;
import rocks.astroid.astroid.core.client.GlobalFunctions;
import rocks.astroid.astroid.core.client.SpritePlus;
import rocks.astroid.astroid.core.screens.Play;
import rocks.astroid.astroid.physics.Polygon;
import rocks.astroid.astroid.physics.Vec2;

/**
 * Simple weapon that is
 */
public class Bullet extends Projectile{
    public Bullet(Vec2 initialPosition, float orienation, Vec2 shipVelocity) {
        super(initialPosition, orienation, 5, 20000,shipVelocity,new Sprite(new Texture("img/sprites/bullet.png")),new Polygon(
                100f,
//                new Vec2(0f,0f),
//                new Vec2(3f,0f),
//                new Vec2(3.5f,.55f),
//                new Vec2(3f,1.1f),
//                new Vec2(0f,1.1f)
                new Vec2(0f,0f),
                new Vec2(30f,0f),
                new Vec2(35f,5.5f),
                new Vec2(30f,11f),
                new Vec2(0f,11f)
        ));
    }
}
