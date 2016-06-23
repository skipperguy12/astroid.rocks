package rocks.astroid.astroid.core.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import rocks.astroid.astroid.core.UserInput;
import rocks.astroid.astroid.core.client.GlobalFunctions;
import rocks.astroid.astroid.core.client.SpriteDisplay;
import rocks.astroid.astroid.core.logic.World;
import rocks.astroid.astroid.core.logic.ships.CombatShip;
import rocks.astroid.astroid.core.logic.ships.Fighter;
import rocks.astroid.astroid.core.logic.ships.Ship;
import rocks.astroid.astroid.core.logic.weapons.Projectile;

import java.util.ArrayList;

import static rocks.astroid.astroid.core.client.GlobalFunctions.moveLaterally;

public class Play implements Screen {

    private OrthographicCamera cam;
    private SpriteDisplay spriteDisplay;
    private SpriteBatch batch;
    private World world;
    private UserInput input;

    public SpriteDisplay getSpriteDisplay()
    {
        return spriteDisplay;
    }
    public SpriteBatch getSpriteBatch(){return batch;}

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.setProjectionMatrix(cam.combined);
        input.handleInput(delta);

        GlobalFunctions.moveLaterally(world.getPlayer());
        world.getPlayer().update();


        cam.position.set(world.getPlayer().getLocation().x, world.getPlayer().getLocation().y, 0);
        cam.update();


        spriteDisplay.render();

        for(Projectile projectile: getWorld().getProjectiles()) {
            projectile.update();
        }
        removeProjectile();

    }

    /**
     * remove all projectiles whose speed is 0
     * prevents ConcurrentModificationException from editing list while looping
     */
    public void removeProjectile()
    {
        int loc = 0;
        boolean checked = false;
        while(!checked)
        {
            if (getWorld().getProjectiles().size()==0)
                return;
            for(;loc<getWorld().getProjectiles().size();loc++)
            {
                if(getWorld().getProjectiles().get(loc).getSpeed()==0)
                {
                    getWorld().getProjectiles().remove(loc);
                    break;
                }
                if(loc==getWorld().getProjectiles().size()-1)
                    checked=true;
            }
        }
    }



    @Override
    public void resize(int width, int height) {
        cam.viewportWidth = width;
        cam.viewportHeight = height;
        cam.position.set(width/2f, height/2f, 0); //by default camera position on (0,0,0)
    }

    @Override
    public void show() {


        batch = new SpriteBatch();
        spriteDisplay = new SpriteDisplay();

        world = new World(new Fighter(Gdx.graphics.getWidth()/2-250,Gdx.graphics.getHeight()/2-250,0) );

        cam = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        input = new UserInput(world.getPlayer(),cam);
        Gdx.input.setInputProcessor(input);
    }

    @Override
    public void hide() {
        dispose();
    }

    @Override
    public void pause() {}

    @Override
    public void resume() {}

    @Override
    public void dispose() {
        batch.dispose();
    }

    public World getWorld() {
        return world;
    }
}
