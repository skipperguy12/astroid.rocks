package rocks.astroid.astroid.core.logic.ships;

import com.badlogic.gdx.math.Vector3;
import rocks.astroid.astroid.core.client.GlobalFunctions;
import rocks.astroid.astroid.core.logic.weapons.Bullet;
import rocks.astroid.astroid.core.logic.weapons.Projectile;
import rocks.astroid.astroid.core.screens.Play;

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
                //Bullet bill =
                        new Bullet(speed, new Vector3(location.x,location.y,(location.z)%360));
                //GlobalFunctions.projectiles.add(bill);
                //System.out.println("bullet");
                break;
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

