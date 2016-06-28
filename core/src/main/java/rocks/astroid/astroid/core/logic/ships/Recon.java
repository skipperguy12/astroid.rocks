package rocks.astroid.astroid.core.logic.ships;

/**
 * Recon SHIP- medium rate of fire low baseDamage, cloaking- can’t shoot while cloaked and can’t be damaged while cloaked for 30 seconds.  Ultimate: Open a portal to an end location in friendly territory
 */
public class Recon extends CombatShip{
    public Recon(float x, float y, float rotation) {
        super(x, y, rotation, 500, 100, null,4,null);
    }
}
