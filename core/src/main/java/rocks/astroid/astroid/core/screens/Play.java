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
import rocks.astroid.astroid.physics.Vec2;

import java.util.ArrayList;

import static rocks.astroid.astroid.core.client.GlobalFunctions.PROJECTILE_REMOVAL_SPEED;

public class Play implements Screen {

    private ArrayList<Projectile> remove;
    private OrthographicCamera cam;
    private SpriteDisplay spriteDisplay;
    private SpriteBatch batch;
    private World world;
    private UserInput input;

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

        //GlobalFunctions.PhysicsManager.displayTable();

        ///for(Astroid astroid: getWorld().getAstroids()) astroid.update();
        //for(Projectile projectile: getWorld().getProjectiles()) System.out.println(projectile.getBody().getVelocity());

        //GlobalFunctions.moveLaterally(world.getPlayer());
        //world.getPlayer().update();

        //follow player
        //System.out.println(world.getPlayer().getBody().getPosition().x*GlobalFunctions.METERS_TO_PIXELS + "  " + world.getPlayer().getBody().getPosition().y*GlobalFunctions.METERS_TO_PIXELS );
        cam.position.set(world.getPlayer().getBody().getPosition().x, world.getPlayer().getBody().getPosition().y, 0);
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

        world = new World();
        world.setPlayer(new Fighter(Gdx.graphics.getWidth()/2-250,Gdx.graphics.getHeight()/2-250,0));
        //world = new World(new Fighter(Gdx.graphics.getWidth()/2-250,Gdx.graphics.getHeight()/2-250,0) );

        world.addClient(new Fighter(Gdx.graphics.getWidth()+100,Gdx.graphics.getHeight()+100,0));

        GlobalFunctions.PhysicsManager.displayTable();

        cam = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        cam.zoom += 3f;

        //new Astroid(world.getPlayer().getLocation().cpy());
        //generateAstroidsAroundPlayer();

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
                if(getWorld().getProjectiles().get(loc).getBody().getVelocity().length()<=PROJECTILE_REMOVAL_SPEED)
                {
                    spriteDisplay.removeSpritePlus(world.getProjectiles().get(loc).getSpritePlus());
                    GlobalFunctions.PhysicsManager.removeBody(getWorld().getProjectiles().remove(loc));
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
    public SpriteDisplay getSpriteDisplay()
    {
        return spriteDisplay;
    }
    public SpriteBatch getSpriteBatch(){return batch;}

    public void generateAstroidsAroundPlayer(){
        for(int i = 0;i<100;i++)
        {
            Vec2 temp = world.getPlayer().getBody().getPosition();
            new Astroid(new Vector3(MathUtils.random(-10000,10000)+temp.x,MathUtils.random(-10000,10000)+temp.y,MathUtils.random(359)));
        }
    }
}