package rocks.astroid.astroid.core.client;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector3;
import rocks.astroid.astroid.core.Movable;
import rocks.astroid.astroid.core.logic.ships.Fighter;
import rocks.astroid.astroid.core.logic.ships.Ship;
import rocks.astroid.astroid.core.logic.weapons.Projectile;

import java.util.ArrayList;

public class GlobalFunctions {
    public static final float FRICTION = .003f;
    public static final float PROJECTILE_REMOVAL_SPEED = 15f;
    public static Sprite getSprite(Ship ship) {
        Sprite sprite = null;
        if(ship instanceof Fighter) {
            if(ship.getTeam() == Ship.Team.BLUE) {
                sprite = new Sprite(new Texture("img/sprites/ships/fighter/ship_blue.png"));
            } else if(ship.getTeam() == Ship.Team.RED) {
                sprite = new Sprite(new Texture("img/sprites/ships/fighter/ship_red.png"));
            } else {
                sprite = new Sprite(new Texture("img/sprites/ships/fighter/ship_purple.png"));
            }
        }
        return sprite;
    }
    /**
     * moves the movable either forwards or backwards based on speed
     */
    public static void moveLaterally(Movable movable)
    {
        Vector3 temp = movable.getLocation();
        temp.x+= MathUtils.cos((float)Math.toRadians(temp.z))* movable.getSpeed();
        temp.y+= MathUtils.sin((float)Math.toRadians(temp.z))* movable.getSpeed();
    }
}