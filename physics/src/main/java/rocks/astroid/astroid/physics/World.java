package rocks.astroid.astroid.physics;

import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;

public class World {
    private int height;
    private int width;
    private boolean wrapAround;
    private Vector2 gravity;
    private ArrayList<Body> bodies;
    /**
     *
     * @param height This is the height of the world
     * @param width This is the width of the world
     */
    public World(int height, int width, Vector2 gravity) {
        this.height = height;
        this.width = width;
        this.gravity = gravity;
    }

    /**
     * Used to update the world and the objects inside the world
     * @param tickCount Updates bodies in world the given number of ticks in time- usually one.
     */
    public void update(int tickCount) {
        if(tickCount <= 0)
            return;
        for(int i = 0; i < tickCount; i++) {
            for(Body body : bodies) {
                body.update(gravity);
            }
            for(Body body : bodies) {
                body.applyUpdate();
            }
        }
    }
}
