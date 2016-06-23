package rocks.astroid.astroid.core.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector3;
import rocks.astroid.astroid.core.logic.ships.Fighter;
import rocks.astroid.astroid.core.logic.ships.Ship;

public class Play implements Screen {

    private OrthographicCamera cam;
    private float rotationSpeed;

    private SpriteBatch batch;
    private Ship ship;

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.setProjectionMatrix(cam.combined);
        handleInput();

        moveLaterally();
        ship.update();
        ship.draw();
        cam.update();

        //cam.position.set(ship.getLocation().x, ship.getLocation().y, 0);
        //cam.translate(ship.getMovementVector());

        batch.begin();
        batch.end();
    }

    private void handleInput() {
        float mobility = ship.getThrust()/ship.getMass();
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) ship.setSpeed(ship.getSpeed()+mobility * Gdx.graphics.getDeltaTime());
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) ship.setSpeed(ship.getSpeed()- mobility * Gdx.graphics.getDeltaTime());
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) { ship.getLocation().z+=mobility * Gdx.graphics.getDeltaTime()*15;ship.setSpeed((float) (ship.getSpeed()*.99));}
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)){ ship.getLocation().z-=mobility * Gdx.graphics.getDeltaTime()*15;ship.setSpeed((float) (ship.getSpeed()*.99));}
        ship.getLocation().z= (ship.getLocation().z + 360)%360;

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
    /**
     * moves the ship either forwards or backwards based on speed
     */
    private void moveLaterally()
    {
        Vector3 temp = ship.getLocation();
        ship.setLocation(new Vector3(
                (int) (temp.x+ (MathUtils.cos((float)Math.toRadians(temp.z))*ship.getSpeed())),
                (int) (temp.y+ (MathUtils.sin((float)Math.toRadians(temp.z))*ship.getSpeed())),
                temp.z)
        );
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

        ship = new Fighter(batch, Gdx.graphics.getWidth()/2-250,Gdx.graphics.getHeight()/2-250,0);
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
