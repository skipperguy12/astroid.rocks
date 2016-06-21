package rocks.astroid.astroid.core.logic.weapons;

import com.badlogic.gdx.math.MathUtils;

/**
 * Super class for weapons
 */
public abstract class Projectile {
    //damage dealt by impact,
    private final float damage;
    private final float range;
    private final float intialSpeed;
    private float speed;
    //decays speed
    private float resistance;
    public Projectile(float damage, float range, float intialSpeed, float resistance) {
        this.damage = damage;
        this.range = range;
        this.intialSpeed = intialSpeed;
        this.resistance = resistance;
        speed = intialSpeed;
    }
    public float getDamage() {
        return damage;
    }
    public float getRange() {
        return range;
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

    public void update()
    {
        speed-=resistance;
    }
    public abstract void draw();
}
