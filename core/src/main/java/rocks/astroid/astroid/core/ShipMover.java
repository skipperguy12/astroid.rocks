package rocks.astroid.astroid.core;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector3;
import rocks.astroid.astroid.core.logic.Ship;

/**
 * Contains a ship and moves it based on input
 */
public class ShipMover extends ApplicationAdapter {
    private Ship ship;
    private float speed;

    public ShipMover(Ship ship)
    {
        this.ship = ship;
        speed = 0;
    }

    /**
     * moves the ship either fowards or backwards based on speed
     */
    private void moveLaterally()
    {
        Vector3 temp = ship.getShipLocation();
        ship.setShipLocation(new Vector3(
                (int) (temp.x+ (Math.cos(temp.z)*this.speed)),
                (int) (temp.y+ (Math.sin(temp.z)*this.speed)),
                temp.z)
        );
    }
    public void render() {

        ship.update();
        ship.draw();
    }
    public void update()
    {
        input();
        moveLaterally();
        render();
    }

    /**
     * accepts arrow key input and alters the ships properties
     */
    public void input()
    {
        float mobility = ship.getThrust()/ship.getMass();
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) speed+=mobility;
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) speed-=mobility;
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) ship.getShipLocation().z+=mobility;
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) ship.getShipLocation().z-=mobility;
    }
}
