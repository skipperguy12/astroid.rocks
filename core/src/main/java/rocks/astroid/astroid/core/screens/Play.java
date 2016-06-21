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

    private Sprite test;

    @Override
    public void render(float delta) {
        //player.update();
        batch.setProjectionMatrix(cam.combined);
        handleInput();
        cam.update();


        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //test.setScale(.5f, .5f);
        //cam.position.set(cam.unproject(new Vector3(test.getX(), test.getY(), 2)));

        batch.begin();
        test.draw(batch);
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
        //cam.zoom = MathUtils.clamp(cam.zoom, 0.1f, 100/cam.viewportWidth);

        float effectiveViewportWidth = cam.viewportWidth * cam.zoom;
        float effectiveViewportHeight = cam.viewportHeight * cam.zoom;
        //cam.position.x = MathUtils.clamp(cam.position.x, effectiveViewportWidth / 2f, 100 - effectiveViewportWidth / 2f);
        //cam.position.y = MathUtils.clamp(cam.position.y, effectiveViewportHeight / 2f, 100 - effectiveViewportHeight / 2f);
    }


    @Override
    public void resize(int width, int height) {
        cam.viewportWidth = width;
        cam.viewportHeight = height;
        cam.position.set(width/2f, height/2f, 0); //by default camera position on (0,0,0)
    }

    @Override
    public void show() {
        test = new Sprite(new Texture("img/sprites/ships/fighter/ship_blue.png"));
        rotationSpeed = 0.5f;

        batch = new SpriteBatch();

        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();

        // Constructs a new OrthographicCamera, using the given viewport width and height
        // Height is multiplied by aspect ratio.
        cam = new OrthographicCamera(w, h);//* (h / w)

        //cam.position.set(cam.viewportWidth / 2f, cam.viewportHeight / 2f, 0);

        cam.update();

        player = new ShipMover(new Fighter(batch, Gdx.graphics.getWidth()/2,Gdx.graphics.getHeight()/2 - 50,0,10,1,1000,100));
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
        test.getTexture().dispose();
        batch.dispose();

    }
}
