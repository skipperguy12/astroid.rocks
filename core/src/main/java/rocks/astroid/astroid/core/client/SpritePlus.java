package rocks.astroid.astroid.core.client;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector3;
import rocks.astroid.astroid.physics.Body;

/**
 * Contains a sprite and a location vector that can be updated by the respective objects
 */
public class SpritePlus {
    private Sprite sprite;
    //private Vector3 location;
    private types type;
    private Body body;

    public enum types
    {
        SHIP, PROJECTILE, ASTROID
    }
    public SpritePlus(Sprite sprite,Body body,types type) {
        this.sprite = sprite;
        this.body = body;
        this.type = type;
    }
    public Sprite getSprite() {
        return sprite;
    }
    public void setSprite(Sprite sprite) {
        if(type==types.SHIP) sprite.rotate90(true);
        this.sprite = sprite;
    }
//    public Vector3 getLocation() {
//        return location;
//    }
//    public void setLocation(Vector3 location) {
//        this.location = location;
//    }
    public types getType() {
        return type;
    }
    public void setType(types type) {
        this.type = type;
    }

    public Body getBody() {
        return body;
    }

    @Override
    public String toString() {
        return "SpritePlus{" +
          //      "location=" + location +
                ", type=" + type +
                '}';
    }
}
