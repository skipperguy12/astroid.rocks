package rocks.astroid.astroid.core.logic.weapons;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector3;
import rocks.astroid.astroid.core.Interactable;
import rocks.astroid.astroid.core.client.GlobalFunctions;
import rocks.astroid.astroid.core.client.SpritePlus;
import rocks.astroid.astroid.core.screens.Play;
import rocks.astroid.astroid.physics.Body;
import rocks.astroid.astroid.physics.Polygon;
import rocks.astroid.astroid.physics.Vec2;

/**
 * Super class for weapons
 */
public abstract class Projectile implements Interactable {
    protected Vec2 initialPosition;
    protected SpritePlus spritePlus;
    protected Body body;

    //baseDamage dealt by impact,
    protected final float baseDamage;

    //protected final float initialSpeed;

    public enum Projectiles
    {
        Bullet
    }

    public Projectile(Vec2 initialPosition, float orientation, float damage, float baseSpeed, Vec2 shipVelocity, Sprite sprite, Polygon shape) {
        this.initialPosition = initialPosition;
        this.baseDamage = damage;
        //this.initialSpeed = baseSpeed+shipVelocity.length();
        Vec2 baseMovementVec = new Vec2(MathUtils.cos(orientation)*baseSpeed*GlobalFunctions.PIXELS_TO_METERS,MathUtils.sin(orientation)*baseSpeed*GlobalFunctions.PIXELS_TO_METERS);//get rid of pixels to meters?

        body = new Body(shape, initialPosition.x, initialPosition.y, orientation,baseMovementVec.add(shipVelocity));
        //body = new Body(shape, initialPosition.x, initialPosition.y, orientation,shipVelocity.extendNew(baseSpeed));
        GlobalFunctions.PhysicsManager.putBody(this,body);
        spritePlus = new SpritePlus(sprite,body,SpritePlus.types.PROJECTILE);

        ((Play)((Game)Gdx.app.getApplicationListener()).getScreen()).getSpriteDisplay().addSpritePlus(spritePlus);
        ((Play)((Game)Gdx.app.getApplicationListener()).getScreen()).getWorld().getProjectiles().add(this);
    }

    /**
     * @param velocity: velocity of other object in collision
     * @return relative speed of impact multipied by the baseDamage of the projectile
     */
    public float getDamage(Vec2 velocity) {
        return velocity.add(body.getVelocity()).length() * baseDamage;
    }
    public Body getBody(){return body;}
    public SpritePlus getSpritePlus(){return spritePlus;}


//    public void update()
//    {
//        if(speed>0) speed-=resistance;
//        else speed=0;
//
//        if (speed<=GlobalFunctions.PROJECTILE_REMOVAL_SPEED) {
//            ((Play) ((Game) Gdx.app.getApplicationListener()).getScreen()).getSpriteDisplay().removeSpritePlus(spritePlus);
//            //System.out.println(speed);
//            //((Play) ((Game) Gdx.app.getApplicationListener()).getScreen()).addToProjectileRemove(this);//TODO: USED IN projectileRemove() IN Play
//        }
//        GlobalFunctions.moveLaterally(this);
//        spritePlus.setLocation(location);
//    }
}
