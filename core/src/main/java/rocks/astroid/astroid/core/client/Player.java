package rocks.astroid.astroid.core.client;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import rocks.astroid.astroid.core.logic.Ship;

public class Player {
    private Ship ship;

    public Player(Ship ship)
    {
        this.ship = ship;

    }

    /**
     * moves the ship either forwards or backwards based on speed
     */
//    private void moveLaterally()
//    {
//        Vector3 temp = ship.getShipLocation();
//        ship.setShipLocation(new Vector3(
//                (int) (temp.x+ (MathUtils.cos((float)Math.toRadians(temp.z))*speed)),
//                (int) (temp.y+ (MathUtils.sin((float)Math.toRadians(temp.z))*speed)),
//                temp.z)
//        );
//    }


    public void render() {
        ship.update();
        ship.draw();
    }
    public void update()
    {
        input();
        //moveLaterally();
        render();
    }
    public Ship getShip()
    {
        return ship;
    }
    /**
     * accepts arrow key input and alters the ships properties
     */
    public void input()
    {
        float mobility = ship.getThrust()/ship.getMass();
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) //speed+=mobility * Gdx.graphics.getDeltaTime();
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) //speed-=mobility * Gdx.graphics.getDeltaTime();
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) ship.getShipLocation().z+=mobility * Gdx.graphics.getDeltaTime()*10;
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) ship.getShipLocation().z-=mobility * Gdx.graphics.getDeltaTime()*10;
        ship.getShipLocation().z= (ship.getShipLocation().z + 360)%360;
    }
}
