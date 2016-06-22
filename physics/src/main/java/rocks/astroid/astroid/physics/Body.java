package rocks.astroid.astroid.physics;

import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

import java.util.ArrayList;

public abstract class Body {
    protected float xPos, yPos;
    protected float tempXPos, tempYPos;
    protected float mass;
    protected Vector3 velocity;
    protected Polygon fixtures;
    protected Vector3 momentum;


    /**
     *
     * @param xPos duh
     * @param yPos duh
     * @param fixtures Polygon representing the shape the body should take in the physics simulation
     */
    public Body(float xPos, float yPos, float mass, Vector3 velocity, Polygon fixtures) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.fixtures = fixtures;
        this.momentum = new Vector3(0f, 0f, 0f);
    }

    abstract void update(Vector2 gravity);

    public void applyUpdate() {
        xPos = tempXPos;
        yPos = tempYPos;
    }
}
