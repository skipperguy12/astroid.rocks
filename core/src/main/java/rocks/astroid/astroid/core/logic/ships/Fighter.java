package rocks.astroid.astroid.core.logic.ships;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

/**
 * Fighter - the normal spaceship. Has high mobility, easy weapon (low damage, high frequency), blast ultimate to fire in all directions
 *      Can deploy “satellite” for healing teammates in a certain radius
 */
public class Fighter extends Ship {
    private SpriteBatch batch;
    private Sprite ship;

    /**
     * creates a fighter and intializes texture
     * @param x
     * @param y
     * @param rotation
     */
    public Fighter(SpriteBatch batch, float x, float y, float rotation)
    {
        super(x,y,rotation,10,1,1000,100);
        this.batch = batch;
        ship = new Sprite(new Texture("img/sprites/ships/fighter/ship_blue.png"));
        ship.setScale(.1f, .1f);
        ship.rotate90(true);
    }

    /**
     * renders the ship with its orientation
     */
    @Override
    public void draw() {
        Vector3 temp = getLocation();
        ship.setRotation(temp.z);
        ship.setX(temp.x);
        ship.setY(temp.y);

        batch.begin();
        ship.draw(batch);
        batch.end();
        //System.out.println("x = " + temp.x + "  y = " + temp.y + "  z = " + temp.z);
    }

    @Override
    public void update() {
        super.update();
    }
}