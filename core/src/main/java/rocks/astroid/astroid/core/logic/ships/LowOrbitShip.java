package rocks.astroid.astroid.core.logic.ships;

/**
 * Low Orbit Ship - low mobility, good weapon low firerate, ultimate: Ion cannon
 */
public class LowOrbitShip extends Ship{
    public LowOrbitShip(float x, float y, float rotation, float thrust, float mass, float hull, float shields) {
        super(x, y, rotation, 10, 2, 1500, 200);
    }
    @Override
    public void draw() {

    }
}
