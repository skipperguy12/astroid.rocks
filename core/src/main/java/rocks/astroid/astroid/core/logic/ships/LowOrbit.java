package rocks.astroid.astroid.core.logic.ships;

/**
 * Low Orbit SHIP - low mobility, good weapon low firerate, ultimate: Ion cannon
 */
public class LowOrbit extends CombatShip{
    public LowOrbit(float x, float y, float rotation) {
        super(x, y, rotation, 10, 2, 1500, 200, null, 2);
    }
}
