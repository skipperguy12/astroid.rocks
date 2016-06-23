package rocks.astroid.astroid.core.client;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import rocks.astroid.astroid.core.screens.Play;

import java.util.ArrayList;

/**
 * Display sprites in proper positioning
 */
public class SpriteDisplay
{
    private SpriteBatch batch;
    private ArrayList<SpritePlus> imgs;
    private Sprite sprite;
    private Vector3 location;
    private SpritePlus.types type;
    public SpriteDisplay()
    {
        imgs = new ArrayList<SpritePlus>();
        batch = Play.getSpriteBatch();
    }
    public boolean removeSpritePlus(SpritePlus spritePlus){
        return imgs.remove(spritePlus);
    }
    /**
     * Adds sprite and location to list of things to render
     * Use for sprites that need location updated so that the SpritePlus object can be kept in the class of creation
     * @param img
     */
    public void addSpritePlus(SpritePlus img){
        img.getSprite().rotate90(true);
       // img.getSprite().setScale(.3f, .3f);
        imgs.add(img);
    }
    public void addSpritePlus(SpritePlus img, boolean isShip){
        if(isShip)
            img.getSprite().rotate90(true);
        //img.getSprite().rotate(90);

        //img.getSprite().setScale(.3f, .3f);
        imgs.add(img);
    }

    /**
     * Adds sprite and location to list of things to render
     * Use for sprites that will not be updated
     * @param sprite
     * @param location
     */
    public void addSpritePlus(Sprite sprite, Vector3 location, SpritePlus.types type){imgs.add(new SpritePlus(sprite,location,type));}
    public ArrayList<SpritePlus> getSpritePluses() {
        return imgs;
    }
    public void setSprites(ArrayList<SpritePlus> imgs) {
        this.imgs = imgs;
    }

    public void render()
    {
        batch.begin();
        for(SpritePlus spr: imgs)
        {
            sprite = spr.getSprite();
            location = spr.getLocation();
            type = spr.getType();
            if(type== SpritePlus.types.Projectile) sprite.setRotation((location.z+270)%360);
            else sprite.setRotation(location.z);
            sprite.setX(location.x-sprite.getWidth()/2);
            sprite.setY(location.y-sprite.getHeight()/2);

            sprite.draw(batch);
        }
        batch.end();
    }
    public void dispose()
    {
        batch.dispose();
    }

}
