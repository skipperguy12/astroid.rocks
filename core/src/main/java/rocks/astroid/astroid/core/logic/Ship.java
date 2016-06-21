package rocks.astroid.astroid.core.logic;

import com.badlogic.gdx.math.Vector3;

/**
 * Abstract representation of a Ship object
 */
public abstract class Ship {
    //Ship Location vector will contain: x, y, and rotation in degrees.
    private Vector3 shipLocation;
    //Speed of ship- defaults to 1
    private float thrust;
    //Mass of the ship- used in combination with thrust to determine acceleration
    private float mass;


    /**
     * Default constructor- should not typically be used
     */
    public Ship() {
        shipLocation = new Vector3(0f, 0f, 0f);
        thrust = 1;
        mass = 1;
    }

    /**
     * X, Y, Rotation values set- thrust set to default (1)
     */
    public Ship(float x, float y, float rotation) {
        shipLocation = new Vector3(x, y, rotation);
        thrust = 1;
        mass = 1;
    }

    /**
     * This is the typical use constructor- ship location, thrust and mass
     */
    public Ship(float x, float y, float rotation, float thrust, float mass) {
        shipLocation = new Vector3(x, y, rotation);
        this.thrust = thrust;
        this.mass = mass;
    }

    /**
     * Takes ship location as a vector3
     */
    public Ship(Vector3 shipLocation, float thrust) {
        this.shipLocation = shipLocation;
        this.thrust = thrust;
    }

    public abstract void draw();

    public abstract void update();

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

    /**
     * ShipLocation stored as a Vector3- xPos, yPos, and Rotation of the ship.
     */
    public Vector3 getShipLocation() {
        return shipLocation;
    }

    public void setShipLocation(Vector3 shipLocation) {
        this.shipLocation = shipLocation;
    }
}
