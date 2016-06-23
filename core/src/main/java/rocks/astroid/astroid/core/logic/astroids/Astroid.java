package rocks.astroid.astroid.core.logic.astroids;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
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

    public Astroid(Astroids type, Vector3 location)
    {
        this.type = type;
        this.location = location;
        ((Play)((Game) Gdx.app.getApplicationListener()).getScreen()).getSpriteDisplay().addSpritePlus(spritePlus);
        ((Play)((Game) Gdx.app.getApplicationListener()).getScreen()).getWorld().getAstroids().add(this);
    }
    public  void onCollide(){

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

}
