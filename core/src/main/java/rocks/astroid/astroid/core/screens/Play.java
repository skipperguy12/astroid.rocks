package rocks.astroid.astroid.core.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector3;
import rocks.astroid.astroid.core.ShipMover;
import rocks.astroid.astroid.core.logic.Fighter;
import rocks.astroid.astroid.core.logic.Ship;

public class Play implements Screen {

    private OrthographicCamera cam;
    private float rotationSpeed;

    private SpriteBatch batch;
    private ShipMover player;

    //private Sprite test;

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.setProjectionMatrix(cam.combined);
        handleInput();

        cam.translate(player.getMovementVector());
        cam.update();
        player.update();

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

        player = new ShipMover(new Fighter(batch, Gdx.graphics.getWidth()/2-250,Gdx.graphics.getHeight()/2-250,0,10,1,1000,100));
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
