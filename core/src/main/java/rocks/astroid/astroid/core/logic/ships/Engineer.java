package rocks.astroid.astroid.core.logic.ships;

/**
 *  Engineer - picks up metal from dead players to repurpose into shields for players to pick up.
 */
public class Engineer extends Ship {
    public Engineer(float x, float y, float rotation) {
        super(x, y, rotation, 8, 1.5f, 700, 150);
    }
    @Override
    public void draw() {

    }
}
