package rocks.astroid.astroid.core.logic.ships;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector3;
import rocks.astroid.astroid.core.client.GlobalFunctions;

/**
 * Abstract representation of a Ship object
 */
public abstract class Ship {
    //Ship location vector will contain: x, y, and rotation in degrees.
    protected Vector3 location;
    //Speed of ship- defaults to 1
    protected float thrust;
    //Mass of the ship- used in combination with thrust to determine acceleration
    protected float mass;

    protected float speed;

    protected float hull;

    protected float shields;

    protected Team team;

    public   enum Team{
        RED, BLUE, PURPLE
    }

    /**
     * Default constructor- should not typically be used
     */
    public Ship() {
        location = new Vector3(0f, 0f, 0f);
        thrust = 1;
        mass = 1;
        speed = 0;
        team =  Team.values()[MathUtils.random(2)];
    }

    /**
     * X, Y, Rotation values set- thrust set to default (1)
     */
    public Ship(float x, float y, float rotation) {
        location = new Vector3(x, y, rotation);
        thrust = 1;
        mass = 1;
        speed = 0;
        team =  Team.values()[MathUtils.random(2)];
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
    }

    /**
     * Takes ship location as a vector3
     */
    public Ship(Vector3 shipLocation, float thrust) {
        this.location = shipLocation;
        this.thrust = thrust;
        speed = 0;
        team =  Team.values()[MathUtils.random(2)];
    }

    public abstract void draw();

    public void update()
    {
        slow();
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

    public void slow()
    {
        if(speed>0) speed-=GlobalFunctions.friction;
        if(speed<0) speed+=GlobalFunctions.friction;
        System.out.println(speed);
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