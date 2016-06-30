package rocks.astroid.astroid.core.logic.ships;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.MathUtils;
import rocks.astroid.astroid.core.Interactable;
import rocks.astroid.astroid.core.client.GlobalFunctions;
import rocks.astroid.astroid.core.client.SpritePlus;
import rocks.astroid.astroid.core.screens.Play;
import rocks.astroid.astroid.physics.Body;
import rocks.astroid.astroid.physics.Polygon;

/**
 * Abstract representation of a SHIP object
 */
public abstract class Ship implements Interactable {
    protected float hull;

    protected float shields;

    protected SpritePlus spritePlus;

    protected Body body;

    protected Team team;

    public   enum Team{
        RED, BLUE, PURPLE
    }

    public Ship(float x, float y, float rotation, float hull, float shields, Polygon shape) {

        team =  Team.values()[MathUtils.random(2)];
        this.hull = hull;
        this.shields = shields;

        body = new Body(shape, x, y, (float)(StrictMath.toRadians(rotation)));
        GlobalFunctions.PhysicsManager.putBody(this,body);

        this.spritePlus = new SpritePlus(GlobalFunctions.getShipSprite(this), body, SpritePlus.types.SHIP);
        ((Play)((Game) Gdx.app.getApplicationListener()).getScreen()).getSpriteDisplay().addSpritePlus(spritePlus);
    }

//    public void update()
//    {
//        spritePlus.setLocation(this.location);
//    }

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

    public Body getBody() {
        return body;
    }

}