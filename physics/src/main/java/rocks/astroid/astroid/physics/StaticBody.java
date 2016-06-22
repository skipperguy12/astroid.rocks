package rocks.astroid.astroid.physics;

import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

public class StaticBody extends Body{

    public StaticBody(float xPos, float yPos, float mass, Vector3 velocity, Polygon fixtures) {
        super(xPos, yPos, mass, velocity, fixtures);
    }


    @Override
    void update(Vector2 gravity) {
        //It's a static body durr-hurr- no movement
    }
}
