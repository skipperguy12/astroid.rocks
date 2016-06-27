package rocks.astroid.astroid.core.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import rocks.astroid.astroid.core.ShipMover;
import rocks.astroid.astroid.core.logic.Fighter;
import rocks.astroid.astroid.core.logic.Ship;
import rocks.astroid.astroid.physics.PhysicsScene;

public class Play implements Screen {
    private SpriteBatch batch;
    private ShipMover player;
    private PhysicsScene physicsScene;

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0,0,0,1); // sets color
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); // clear

        player.update();

        batch.begin();
        batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void show() {
        batch = new SpriteBatch();
        player = new ShipMover(new Fighter(Gdx.graphics.getWidth()/2,Gdx.graphics.getHeight()/2 - 50,0,10,1,1000,100));
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
