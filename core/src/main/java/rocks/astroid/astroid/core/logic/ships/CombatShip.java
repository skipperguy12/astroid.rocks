package rocks.astroid.astroid.core.logic.ships;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Timer;
import rocks.astroid.astroid.core.client.GlobalFunctions;
import rocks.astroid.astroid.core.logic.weapons.Bullet;
import rocks.astroid.astroid.core.logic.weapons.Projectile;
import rocks.astroid.astroid.core.screens.Play;
import rocks.astroid.astroid.physics.Polygon;

/**
 * A ship that has a mounted weapon
 */
public abstract class CombatShip extends Ship {

    protected final Projectile.Projectiles projectileType;
    //number of times projectile is fired per second
    protected float fireRate;
    protected float timer = 0;

    public CombatShip(float x, float y, float rotation, float hull, float shields, Projectile.Projectiles projectileType, float fireRate, Polygon shape) {
        super(x, y, rotation,  hull, shields,shape);
        this.projectileType = projectileType;
        this.fireRate = fireRate;
    }

    public void fire(float delta) {
        this.timer += delta;

        if (timer < 1.0f / getFireRate() || !Gdx.input.isKeyPressed(Input.Keys.SPACE))
            return;

        switch (projectileType) {
            case Bullet:
                //TODO: UPDATE THIS BULLET REFERENCE
                new Bullet(body.getPosition(),body.getOrient(),body.getVelocity());
                break;
        }
        timer = 0;
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

