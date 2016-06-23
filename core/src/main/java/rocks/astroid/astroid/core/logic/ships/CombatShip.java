package rocks.astroid.astroid.core.logic.ships;

import rocks.astroid.astroid.core.client.GlobalFunctions;
import rocks.astroid.astroid.core.logic.weapons.Bullet;
import rocks.astroid.astroid.core.logic.weapons.Projectile;

/**
 * A ship that has a mounted weapon
 */
public abstract class CombatShip extends Ship{
    protected final Projectile.Projectiles projectileType;
    //number of times projectile is fired per second
    protected float fireRate;

    public CombatShip(float x, float y, float rotation, float thrust, float mass, float hull, float shields, Projectile.Projectiles projectileType, float fireRate) {
        super(x, y, rotation, thrust, mass, hull, shields);
        this.projectileType = projectileType;
        this.fireRate=fireRate;
    }
    public void fire() {
        switch (projectileType)
        {
            case Bullet:
                GlobalFunctions.projectiles.add(new Bullet(speed, getLocation()));
        }
    }
    public Projectile.Projectiles getProjectileType() {
        return projectileType;
    }
    public float getFireRate() {
        return fireRate;
    }
    public void setFireRate(float fireRate) {
        this.fireRate = fireRate;
    }
}

