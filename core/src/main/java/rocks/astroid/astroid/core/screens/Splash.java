package rocks.astroid.astroid.core.screens;

import aurelienribon.tweenengine.BaseTween;
import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenCallback;
import aurelienribon.tweenengine.TweenManager;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import rocks.astroid.astroid.core.tween.SpriteAccessor;

public class Splash implements Screen {
    private SpriteBatch batch;
    private Sprite splash;
    private Sprite rocket;
    private TweenManager tweenManager;
    private float timer;

    @Override
    public void render(float delta) {
        timer += delta;
        Gdx.gl.glClearColor(0,0,0,1); // sets color
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); // clear

        tweenManager.update(delta);

        /*
        float xOffset = (Gdx.graphics.getWidth() / 2) - (rocket.getX() + (rocket.getWidth() / 2));
        float yOffset = (Gdx.graphics.getHeight() / 2) - (rocket.getY() + (rocket.getHeight() / 2));
        float mouseX = Gdx.input.getX() + xOffset;
        float mouseY = (Gdx.graphics.getHeight() - Gdx.input.getY()) + yOffset;

        float radiansToMouse = MathUtils.atan2(mouseX - (Gdx.graphics.getWidth() / 2), (Gdx.graphics.getHeight() / 2) - mouseY);
        float degreesToMouse = MathUtils.radiansToDegrees * radiansToMouse;
        rocket.setRotation(degreesToMouse - 90);

        rocket.setX((float) (rocket.getX() + MathUtils.cos(degreesToMouse - 90) * 1));
        rocket.setY((float) (rocket.getY() + MathUtils.sin(degreesToMouse - 90) * 1));
        */

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
        tweenManager = new TweenManager();
        Tween.registerAccessor(Sprite.class, new SpriteAccessor());


        splash = new Sprite(new Texture("img/splash.png"));
        rocket = new Sprite(new Texture("img/sprites/ships/fighter/ship_blue.png"));
        splash.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        rocket.setCenter(Gdx.graphics.getWidth()/2, (Gdx.graphics.getHeight()/2));
        rocket.setScale(.75f, .75f);
        //rocket.rotate90(true);
        //System.out.println(rocket.getX() + " "  + rocket.getY());

        Tween.set(splash, SpriteAccessor.ALPHA).target(0).start(tweenManager);
        Tween.to(splash, SpriteAccessor.ALPHA, 2).target(1).repeatYoyo(1, 2).start(tweenManager);

        Tween.set(rocket, SpriteAccessor.ALPHA).target(0).start(tweenManager);
        Tween.to(rocket, SpriteAccessor.ALPHA, 2).target(1).repeatYoyo(1, 2).start(tweenManager).setCallback(new TweenCallback() {
            @Override
            public void onEvent(int type, BaseTween<?> source) {
                Gdx.app.log("astroid.rocks", "Changing from Splash screen to Main menu");
                ((Game)Gdx.app.getApplicationListener()).setScreen(new MainMenu());
            }
        });

        Tween.set(rocket, SpriteAccessor.SCALE).target(0, 0).start(tweenManager);
        Tween.to(rocket, SpriteAccessor.SCALE, 1).target(.75f, .75f).start(tweenManager);

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
        rocket.getTexture().dispose();
    }
}
