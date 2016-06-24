package rocks.astroid.astroid.core.logic.weapons;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector3;
import rocks.astroid.astroid.core.Movable;
import rocks.astroid.astroid.core.client.GlobalFunctions;
import rocks.astroid.astroid.core.client.SpritePlus;
import rocks.astroid.astroid.core.screens.Play;

/**
 * Super class for weapons
 */
public abstract class Projectile implements Movable {
    protected Vector3 location;
    protected SpritePlus spritePlus;

    //damage dealt by impact,
    protected final float damage;
    //in number of renders
    protected final float intialSpeed;
    protected float speed;
    //decays speed
    protected float resistance;

    public enum Projectiles
    {
        Bullet
    }

    public Projectile(float damage,  float initialSpeed, float resistance, float shipSpeed, Vector3 location, SpritePlus spritePlus) {
        this.damage = damage;
        this.intialSpeed = initialSpeed+shipSpeed;
        this.resistance = resistance+GlobalFunctions.FRICTION;
        speed = initialSpeed;
        this.location = location;
        this.spritePlus = spritePlus;
        ((Play)((Game)Gdx.app.getApplicationListener()).getScreen()).getSpriteDisplay().addSpritePlus(spritePlus);
        ((Play)((Game)Gdx.app.getApplicationListener()).getScreen()).getWorld().getProjectiles().add(this);
    }

    /**
     * TODO: find relative speed of projectile and multiply damage by the relative speed on impact
     * @return
     *
     */
    public float getDamage() {
        return damage;
    }
    public float getintialSpeed() {
        return intialSpeed;
    }
    public float getResistance() {
        return resistance;
    }
    public float getSpeed(){
        return speed;
    }
    public void setSpeed(float speed){this.speed=speed;};
    public Vector3 getLocation() {
        return location;
    }
    public void setLocation(Vector3 location) {
        this.location = location;
    }

    public void update()
    {
        if(speed>0) speed-=resistance;
        else speed=0;

        if (speed<=GlobalFunctions.PROJECTILE_REMOVAL_SPEED) {
            ((Play) ((Game) Gdx.app.getApplicationListener()).getScreen()).getSpriteDisplay().removeSpritePlus(spritePlus);
            System.out.println(speed);
            ((Play) ((Game) Gdx.app.getApplicationListener()).getScreen()).addToProjectileRemove(this);//TODO: USED IN projectileRemove() IN Play
        }

        GlobalFunctions.moveLaterally(this);
        spritePlus.setLocation(location);
    }
}
