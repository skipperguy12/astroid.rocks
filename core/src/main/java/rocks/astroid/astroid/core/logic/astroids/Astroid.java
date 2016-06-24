package rocks.astroid.astroid.core.logic.astroids;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector3;
import rocks.astroid.astroid.core.client.SpritePlus;
import rocks.astroid.astroid.core.screens.Play;

/**
 * powerup pickup
 */
public class Astroid {
    protected SpritePlus spritePlus;
    protected Vector3 location;
    protected Astroids type;
    public enum Astroids
    {
        RED, GREEN, BLUE
    }

    /**
     * Creates an Astroid with a random type at location
     * @param location
     */
    public Astroid(Vector3 location)
    {
        this.type = Astroids.values()[MathUtils.random(2)];
        this.location = location;
        this.spritePlus = new SpritePlus(getSprite(),location, SpritePlus.types.ASTROID);
        ((Play)((Game) Gdx.app.getApplicationListener()).getScreen()).getSpriteDisplay().addSpritePlus(spritePlus);
        ((Play)((Game) Gdx.app.getApplicationListener()).getScreen()).getWorld().getAstroids().add(this);
    }

    /**
     * creates an Astroid of type at location
     * @param location
     * @param type
     */
    public Astroid(Vector3 location, Astroids type)
    {
        if (type==null) this.type = Astroids.values()[MathUtils.random(2)];
        else this.type = type;

        this.location = location;
        this.spritePlus = new SpritePlus(getSprite(),location, SpritePlus.types.ASTROID);
        ((Play)((Game) Gdx.app.getApplicationListener()).getScreen()).getSpriteDisplay().addSpritePlus(spritePlus);
        ((Play)((Game) Gdx.app.getApplicationListener()).getScreen()).getWorld().getAstroids().add(this);
    }

    /**
     * When a ship touches the astroid
     */
    public void onCollide(){
        if(type==null)
            return;
        switch (type)
        {
            case RED:
                ;
                break;
            case BLUE:
                ;
                break;
            case GREEN:
                ;
                break;
            default: return;
        }
        ((Play)((Game) Gdx.app.getApplicationListener()).getScreen()).getSpriteDisplay().removeSpritePlus(spritePlus);
        ((Play)((Game) Gdx.app.getApplicationListener()).getScreen()).getWorld().getAstroids().remove(this);
    }
    private Sprite getSprite()
    {
        if(type==null)
            return null;
        switch (type)
        {
            case RED:
                return new Sprite (new Texture("img/sprites/red-astroid.png"));
            case BLUE:
                return new Sprite (new Texture("img/sprites/blue-astroid.png"));
            case GREEN:
                return new Sprite (new Texture("img/sprites/green-astroid.png"));
            default: return null;
        }
    }
    public void update() {

    }
}
