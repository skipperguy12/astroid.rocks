package rocks.astroid.astroid.core;

import com.badlogic.gdx.math.Vector3;

/**
 * Has speed and can be moved
 */
public interface Movable {
    public float getSpeed();
    public void setSpeed(float speed);
    public Vector3 getLocation();
    public void setLocation(Vector3 location);
}
