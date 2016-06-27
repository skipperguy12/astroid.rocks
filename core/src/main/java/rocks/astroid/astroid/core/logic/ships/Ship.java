package rocks.astroid.astroid.core.logic.ships;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector3;
import rocks.astroid.astroid.core.Movable;
import rocks.astroid.astroid.core.client.GlobalFunctions;
import rocks.astroid.astroid.core.client.SpritePlus;
import rocks.astroid.astroid.core.screens.Play;

/**
 * Abstract representation of a SHIP object
 */
public abstract class Ship implements Movable {
    //SHIP location vector will contain: x, y, and rotation in degrees.
    protected Vector3 location;
    //Speed of ship- defaults to 1
    protected float thrust;
    //Mass of the ship- used in combination with thrust to determine acceleration
    protected float mass;

    protected float speed;

    protected float hull;

    protected float shields;

    protected SpritePlus spritePlus;

    protected Team team;

    public   enum Team{
        RED, BLUE, PURPLE
    }

    /**
     * This is the typical use constructor- location, thrust and mass
     */
    public Ship(float x, float y, float rotation, float thrust, float mass, float hull, float shields) {
        location = new Vector3(x, y, rotation);
        this.thrust = thrust;
        this.mass = mass;
        speed = 0;
        team =  Team.values()[MathUtils.random(2)];
        this.hull = hull;
        this.shields = shields;
        this.spritePlus = new SpritePlus(GlobalFunctions.getShipSprite(this), location, SpritePlus.types.SHIP);
        ((Play)((Game) Gdx.app.getApplicationListener()).getScreen()).getSpriteDisplay().addSpritePlus(spritePlus);
    }

    public void update()
    {
        slow();
        spritePlus.setLocation(this.location);
    }

    public float getThrust() {
        return thrust;
    }
    public void setThrust(float thrust) {
        this.thrust = thrust;
    }
    public float getMass() {
        return mass;
    }
    public void setMass(float mass) {
        this.mass = mass;
    }
    @Override
    public float getSpeed() {
        return speed;
    }
    public void setSpeed(float speed) {
        this.speed = speed;
    }
    public Team getTeam() {
        return team;
    }
    public void setTeam(Team team) {
        this.team = team;
    }
    public float getHull() {
        return hull;
    }
    public void setHull(float hull) {
        this.hull = hull;
    }
    public float getShields() {
        return shields;
    }
    public void setShields(float shields) {
        this.shields = shields;
    }
    public SpritePlus getSpritePlus() {
        return spritePlus;
    }
    public void setSpritePlus(SpritePlus spritePlus) {
        this.spritePlus = spritePlus;
    }

    public void slow()
    {
        if(speed>0) speed-=GlobalFunctions.FRICTION;
        if(speed<0) speed+=GlobalFunctions.FRICTION;
      }

    /**
     * location stored as a Vector3- xPos, yPos, and Rotation of the ship.
     */
    public Vector3 getLocation() {
        return location;
    }

    public void setLocation(Vector3 location) {
        this.location = location;
    }
}