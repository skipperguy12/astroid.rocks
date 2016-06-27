package rocks.astroid.astroid.core.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector3;
import rocks.astroid.astroid.core.UserInput;
import rocks.astroid.astroid.core.client.GlobalFunctions;
import rocks.astroid.astroid.core.client.SpriteDisplay;
import rocks.astroid.astroid.core.logic.World;
import rocks.astroid.astroid.core.logic.astroids.Astroid;
import rocks.astroid.astroid.core.logic.ships.Fighter;
import rocks.astroid.astroid.core.logic.weapons.Projectile;
import rocks.astroid.astroid.physics.PhysicsScene;

import java.util.ArrayList;

import static rocks.astroid.astroid.core.client.GlobalFunctions.PROJECTILE_REMOVAL_SPEED;

public class Play implements Screen {

    private ArrayList<Projectile> remove;
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

    /**
     * order from front to back:
     * ship, projectiles, astroids
     * @param delta
     */
    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.setProjectionMatrix(cam.combined);
        input.handleInput(delta);

        getWorld().getPhysicsScene().step(delta);

        for(Astroid astroid: getWorld().getAstroids()) astroid.update();
        for(Projectile projectile: getWorld().getProjectiles()) projectile.update();

        GlobalFunctions.moveLaterally(world.getPlayer());
        world.getPlayer().update();

        //follow player
        cam.position.set(world.getPlayer().getLocation().x, world.getPlayer().getLocation().y, 0);
        cam.update();

        projectileCheckRemove(); //TODO: USE THIS
//        projectileRemove();//TODO: OR THIS

        spriteDisplay.render();

        //System.out.println(Gdx.graphics.getFramesPerSecond());
    }

    public Vector3 getMousePosInGameWorld() {
        return cam.unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0));
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
        cam.zoom += 3f;

        //new Astroid(world.getPlayer().getLocation().cpy());
        generateAstroidsAroundPlayer();

        input = new UserInput(world.getPlayer(),cam);
        Gdx.input.setInputProcessor(input);//not necessary?

        remove = new ArrayList<Projectile>();
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
        getSpriteDisplay().dispose();
    }

    /**
     * remove all projectiles whose speed is less than or equal to PROJECTILE_REMOVAL_SPEED
     * prevents ConcurrentModificationException from editing list while looping
     */
    public void projectileCheckRemove()
    {
        int loc = 0;
        boolean checked = false;
        while(!checked)
        {
            if (getWorld().getProjectiles().size()==0)
                return;
            for(;loc<getWorld().getProjectiles().size();loc++)
            {
                if(getWorld().getProjectiles().get(loc).getSpeed()<=PROJECTILE_REMOVAL_SPEED)
                {
                    getWorld().getProjectiles().remove(loc);
                    break;
                }
                if(loc==getWorld().getProjectiles().size()-1)
                    checked=true;
            }
        }
    }

//    /**
//     * TODO: choose to use either projectileRemove() or projectileCheckRemove(), (choose the more efficient one)
//     */
//    public void projectileRemove()
//    {
//        for(int i = remove.size()-1; i>=0;i--)
//        {
//            getWorld().getProjectiles().remove(remove.get(i));
//            remove.remove(i);
//        }
//    }
//    public void addToProjectileRemove(Projectile projectile)
//    {
//        remove.add(projectile);
//    }

    public World getWorld() {
        return world;
    }
    public void generateAstroidsAroundPlayer(){
        for(int i = 0;i<100;i++)
        {
            Vector3 temp = world.getPlayer().getLocation().cpy();
            temp.add(MathUtils.random(-10000,10000),MathUtils.random(-10000,10000),MathUtils.random(360));
            new Astroid(temp);
        }
    }
}