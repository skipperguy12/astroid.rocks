package rocks.astroid.astroid.core.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2D;
import com.badlogic.gdx.physics.box2d.World;
import rocks.astroid.astroid.core.client.GlobalFunctions;
import rocks.astroid.astroid.core.client.Player;
import rocks.astroid.astroid.core.logic.Fighter;

public class Play implements Screen {

    private OrthographicCamera cam;
    private float rotationSpeed;

    private SpriteBatch batch;
    private Player player;

    private World world;
    private float pixel2meter = .1f;
    private float meter2pixel = 1/pixel2meter;

    public Play() {
        Box2D.init();
        world = new World(new Vector2(0, -1), true);
        player = new Player(new Fighter(batch, Gdx.graphics.getWidth()/2-250,Gdx.graphics.getHeight()/2-250,0,10,1,1000,100));
    }

    //private Sprite test;

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.setProjectionMatrix(cam.combined);
        handleInput();

        player.update();

        cam.position.set(player.getShip().getShipLocation().x + 500 * GlobalFunctions.getSprite(player.getShip()).getScaleX(), player.getShip().getShipLocation().y + 500 * GlobalFunctions.getSprite(player.getShip()).getScaleY(), 0);
        //cam.translate(player.getMovementVector());
        cam.update();

        batch.begin();
        batch.end();
    }

    //input for camera
    private void handleInput() {
        if (Gdx.input.isKeyPressed(Input.Keys.NUMPAD_7)) {
            cam.zoom += .1;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.NUMPAD_9)) {
            cam.zoom -= .1;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.NUMPAD_4)) {
            cam.translate(-5, 0, 0);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.NUMPAD_6)) {
            cam.translate(5, 0, 0);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.NUMPAD_2)) {
            cam.translate(0, -5, 0);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.NUMPAD_8)) {
            cam.translate(0, 5, 0);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.NUMPAD_1)) {
            cam.rotate(-rotationSpeed, 0, 0, 1);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.NUMPAD_3)) {
            cam.rotate(rotationSpeed, 0, 0, 1);
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
        rotationSpeed = 0.5f;
        batch = new SpriteBatch();

        cam = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());//* (h / w)
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
