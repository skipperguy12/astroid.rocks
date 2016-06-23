package rocks.astroid.astroid.core.logic.weapons;

import rocks.astroid.astroid.core.Movable;

/**
 * Super class for weapons
 */
public abstract class Projectile implements Movable {
    public enum Projectiles
    {
        Bullet
    }

    //damage dealt by impact,
    protected final float damage;
    //in number of renders
    protected final float intialSpeed;
    protected float speed;
    //decays speed
    protected float resistance;
    public Projectile(float damage,  float intialSpeed, float resistance) {
        this.damage = damage;
        this.intialSpeed = intialSpeed;
        this.resistance = resistance;
        speed = intialSpeed;
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

    public void update()
    {
        if(speed>0) speed-=resistance;
        else speed=0;
    }
}
