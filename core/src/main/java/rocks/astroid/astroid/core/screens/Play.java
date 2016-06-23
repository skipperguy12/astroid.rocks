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
import rocks.astroid.astroid.core.logic.ships.CombatShip;
import rocks.astroid.astroid.core.logic.ships.Fighter;
import rocks.astroid.astroid.core.logic.ships.Ship;
import rocks.astroid.astroid.core.logic.weapons.Projectile;

import static rocks.astroid.astroid.core.client.GlobalFunctions.moveLaterally;

public class Play implements Screen {

    private OrthographicCamera cam;
    private static SpriteDisplay spriteDisplay;
    private static SpriteBatch batch;
    private CombatShip ship;
    private UserInput input;


    public Play()
    {
        batch = new SpriteBatch();
        spriteDisplay = new SpriteDisplay();
        ship = new Fighter(Gdx.graphics.getWidth()/2-250,Gdx.graphics.getHeight()/2-250,0);
        cam = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        input = new UserInput(ship,cam);
        Gdx.input.setInputProcessor(input);
    }
    public static SpriteDisplay getSpriteDisplay()
    {
        return spriteDisplay;
    }
    public static SpriteBatch getSpriteBatch(){return batch;}

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.setProjectionMatrix(cam.combined);
        input.handleInput();

        GlobalFunctions.moveLaterally(ship);

        ship.update();
        spriteDisplay.render();

        for(Projectile projectile: GlobalFunctions.projectiles) {
            projectile.update();
        }

        cam.update();
    }


    @Override
    public void resize(int width, int height) {
        cam.viewportWidth = width;
        cam.viewportHeight = height;
        cam.position.set(width/2f, height/2f, 0); //by default camera position on (0,0,0)
    }

    @Override
    public void show() {
        cam.update();
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
}
