package rocks.astroid.astroid.core.client;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector3;

/**
 * Contains a sprite and a location vector that can be updated by the respective objects
 */
public class SpritePlus {
    private Sprite sprite;
    private Vector3 location;
    private types type;
    public enum types
    {
        Ship, Projectile
    }
    public SpritePlus(Sprite sprite, Vector3 location,types type) {
        this.sprite = sprite;
        this.location = location;
        this.type = type;
    }
    public Sprite getSprite() {
        return sprite;
    }
    public void setSprite(Sprite sprite) {
        this.sprite = sprite;
    }
    public Vector3 getLocation() {
        return location;
    }
    public void setLocation(Vector3 location) {
        this.location = location;
    }
    public types getType() {
        return type;
    }
    public void setType(types type) {
        this.type = type;
    }
}
