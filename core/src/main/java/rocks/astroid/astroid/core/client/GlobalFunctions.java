package rocks.astroid.astroid.core.client;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import rocks.astroid.astroid.core.Interactable;
import rocks.astroid.astroid.core.logic.ships.Fighter;
import rocks.astroid.astroid.core.logic.ships.Ship;
import rocks.astroid.astroid.core.screens.Play;
import rocks.astroid.astroid.physics.Body;

import java.util.Hashtable;

public class GlobalFunctions {
    public static final float FRICTION = .003f;
    public static final float PROJECTILE_REMOVAL_SPEED = 25f;

    public static final float METERS_TO_PIXELS = 10.0f;

    public static final float PIXELS_TO_METERS = 1/METERS_TO_PIXELS;

    public static Sprite getShipSprite(Ship ship) {
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
    public static Sprite getMovingShipSprite(Ship ship) {
        Sprite sprite = null;
        if(ship instanceof Fighter) {
            if(ship.getTeam() == Ship.Team.BLUE) {
                sprite = new Sprite(new Texture("img/sprites/ships/fighter/ship_blue_fire.png"));
            } else if(ship.getTeam() == Ship.Team.RED) {
                sprite = new Sprite(new Texture("img/sprites/ships/fighter/ship_red_fire.png"));
            } else {
                sprite = new Sprite(new Texture("img/sprites/ships/fighter/ship_purple_fire.png"));
            }
        }
        return sprite;
    }
    /**
     * moves the movable either forwards or backwards based on speed
     */
//    public static void moveLaterally(Movable movable)
//    {
//        Vector3 temp = movable.getLocation();
//        temp.x+= MathUtils.cos((float)Math.toRadians(temp.z))* movable.getSpeed();
//        temp.y+= MathUtils.sin((float)Math.toRadians(temp.z))* movable.getSpeed();
//    }

    /**
     * Connects the core to the physics engine
     */
    public static class PhysicsManager {
        private static Hashtable<Interactable, Body> table = new Hashtable<Interactable, Body>();
        public static Body getBody(Interactable key) {
            return table.get(key);
        }
        public static void putBody(Interactable key, Body b) {
            table.put(key, b);
            //((Play) ((Game) Gdx.app.getApplicationListener()).getScreen()).getWorld().getPhysicsScene().add(b.shape, b.position.x, b.position.y, b.orient);
            ((Play) ((Game) Gdx.app.getApplicationListener()).getScreen()).getWorld().getPhysicsScene().add(b);//add same body so that all physics changes are updated in the Hashtable
        }
        public static void removeBody(Interactable key, Body b) {
            ((Play) ((Game) Gdx.app.getApplicationListener()).getScreen()).getWorld().getPhysicsScene().remove(b);
            table.remove(key);
        }
        public static void removeBody(Interactable key) {
            ((Play) ((Game) Gdx.app.getApplicationListener()).getScreen()).getWorld().getPhysicsScene().remove(table.get(key));
            table.remove(key);
        }
        public static void displayTable(){
            table.keySet();
        }

    }
}