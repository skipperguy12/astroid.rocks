package rocks.astroid.astroid.core.logic.weapons;

import com.badlogic.gdx.math.Vector3;
import rocks.astroid.astroid.core.client.GlobalFunctions;

/**
 * launches projectiles
 */
public class Turret {
    private Projectile.Projectiles type;

    /**
     * makes a turret that fires a certain type of Projectile
     * @param type
     */
    public Turret(Projectile.Projectiles type) {
        this.type = type;
    }

    /**
     *
     * @param origin
     */
    public void fire(Vector3 origin) {
        switch (type)
        {
            case Bullet:
                GlobalFunctions.projectiles.add(new Bullet());
        }
    }
}
