package rocks.astroid.astroid.core.client;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
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
    //private ArrayList<SpritePlus> imgs;
    private ArrayList<SpritePlus> ships;
    private ArrayList<SpritePlus> projectiles;
    private ArrayList<SpritePlus> astroids;
    private Sprite sprite;
    private Vector3 location;
    private SpritePlus.types type;
    public SpriteDisplay()
    {
        //imgs = new ArrayList<SpritePlus>();
        ships = new ArrayList<SpritePlus>();
        projectiles = new ArrayList<SpritePlus>();
        astroids = new ArrayList<SpritePlus>();
        batch =  ((Play)((Game) Gdx.app.getApplicationListener()).getScreen()).getSpriteBatch();
    }

    /**
     * Adds sprite and location to list of things to render
     * Use for sprites that need location updated so that the SpritePlus object can be kept in the class of creation
     * @param img
     */
    public void addSpritePlus(SpritePlus img){
        //img.getSprite().setScale(.3f, .3f);
        switch(img.getType())
        {
            case SHIP:
                img.getSprite().rotate90(true);
                ships.add(img);
                break;
            case PROJECTILE:
                projectiles.add(img);
                break;
            case ASTROID:
                astroids.add(img);
                break;
                default: return;
        }

    }

    /**
     * removes sprite plus from the class
     * @param spritePlus
     * @return
     */
    public boolean removeSpritePlus(SpritePlus spritePlus){
        switch(spritePlus.getType())
        {
            case SHIP:
                return ships.remove(spritePlus);
            case PROJECTILE:
                return projectiles.remove(spritePlus);
            case ASTROID:
                return astroids.remove(spritePlus);
            default: return false;
        }
    }

//    /**
//     * Adds sprite and location to list of things to render
//     * Use for sprites that will not be updated
//     * @param sprite
//     * @param location
//     */
//    public void addSpritePlus(Sprite sprite, Vector3 location, SpritePlus.types type){imgs.add(new SpritePlus(sprite,location,type));}
//    public ArrayList<SpritePlus> getSpritePluses() {
//        return imgs;
//    }
    
//    public void setSprites(ArrayList<SpritePlus> imgs) {
//        this.imgs = imgs;
//    }

    public void render()
    {
        batch.begin();
        drawSpriteList(astroids);
        drawSpriteList(projectiles);
        drawSpriteList(ships);
        batch.end();
    }
    private void drawSpriteList(ArrayList<SpritePlus> imgs)
    {
        for(SpritePlus spr: imgs) {
            sprite = spr.getSprite();
            location = spr.getLocation();
            type = spr.getType();
            if (type == SpritePlus.types.PROJECTILE) sprite.setRotation((location.z + 270) % 360);
            else sprite.setRotation(location.z);
            sprite.setX(location.x - sprite.getWidth() / 2);
            sprite.setY(location.y - sprite.getHeight() / 2);

            sprite.draw(batch);
        }
    }

    public void dispose()
    {
        batch.dispose();
    }

    public ArrayList<SpritePlus> getAstroids() {
        return astroids;
    }

    public ArrayList<SpritePlus> getProjectiles() {
        return projectiles;
    }

    public ArrayList<SpritePlus> getShips() {
        return ships;
    }
}
