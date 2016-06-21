package rocks.astroid.astroid.core.logic;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import rocks.astroid.astroid.core.logic.Ship;

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
     * @param thrust
     * @param mass
     * @param hull
     * @param shields
     */
    public Fighter(float x, float y, float rotation, float thrust, float mass, float hull, float shields)
    {
        super(x,y,rotation,thrust,mass,hull,shields);
        batch = new SpriteBatch();
        ship = new Sprite(new Texture("img/sprites/ships/fighter/ship_blue.png"));//change with different teams
        ship.setScale(.1f, .1f);
        ship.rotate90(true);
    }

    /**
     * renders the ship with its orientation
     */
    @Override
    public void draw() {
        Vector3 temp = getShipLocation();
        ship.setRotation(temp.z);
        ship.setX(temp.x);
        ship.setY(temp.y);

        batch.begin();
        ship.draw(batch);
        batch.end();
    }

    @Override
    public void update() {
    }
}