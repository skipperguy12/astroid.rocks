package rocks.astroid.astroid.core.logic;

import com.badlogic.gdx.math.Vector3;

/**
 * Created by Matthew on 6/20/2016.
 */
public abstract class Ship {
    //Ship Location vector will contain: x, y, and rotation in degrees.
    private Vector3 shipLocation;
    //Speed of ship- defaults to 1
    private float speed;


    //Default constructor- should not typically be used
    public Ship() {
        shipLocation = new Vector3(0f, 0f, 0f);
        speed = 1;
    }

    //X, Y, Rotation values set- speed set to default (1)
    public Ship(float x, float y, float rotation) {
        shipLocation = new Vector3(x, y, rotation);
        speed = 1;
    }

    //This is the typical use constructor- ship location and speed
    public Ship(float x, float y, float rotation, float speed) {
        shipLocation = new Vector3(x, y, rotation);
        this.speed = speed;
    }

    //Takes ship location as a vector3
    public Ship(Vector3 shipLocation, float speed) {
        this.shipLocation = shipLocation;
        this.speed = speed;
    }

    public abstract void draw();

    public abstract void update();

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    //ShipLocation stored as a Vector3- xPos, yPos, and Rotation of the ship.
    public Vector3 getShipLocation() {
        return shipLocation;
    }

    public void setShipLocation(Vector3 shipLocation) {
        this.shipLocation = shipLocation;
    }
}
