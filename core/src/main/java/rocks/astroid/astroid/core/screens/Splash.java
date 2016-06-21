package rocks.astroid.astroid.core.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Splash implements Screen {
    private SpriteBatch batch;
    private Sprite splash;
    private Sprite rocket;

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0,0,0,1); // sets color
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); // clear

        batch.begin();
        splash.draw(batch);
        rocket.draw(batch);
        batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void show() {
        batch = new SpriteBatch();

        splash = new Sprite(new Texture("img/splash.png"));
        rocket = new Sprite(new Texture("img/sprites/ships/fighter/ship_blue.png"));
        splash.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        rocket.setScale(.75f, .75f);
        rocket.setCenter(Gdx.graphics.getWidth()/2, (Gdx.graphics.getHeight()/2) - 50);
    }

    @Override
    public void hide() {
        dispose();
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {
        batch.dispose();
        splash.getTexture().dispose();
    }
}
