package rocks.astroid.astroid.core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import rocks.astroid.astroid.core.logic.ships.CombatShip;

/**
 * Takes input from player
 */
public class UserInput extends InputAdapter {
    private CombatShip ship;
    private OrthographicCamera cam;

    public UserInput(CombatShip ship, OrthographicCamera cam)
    {
        this.ship = ship;
        this.cam = cam;
    }
    public void handleInput(float delta) {

        float mobility = ship.getThrust() / ship.getMass();
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            ship.setSpeed(ship.getSpeed() + mobility * Gdx.graphics.getDeltaTime());
            ship.getSpritePlus().setSprite(new Sprite(new Texture("img/sprites/ships/fighter/ship_blue_fire.png")));
        }
//        if (Gdx.input.getInputProcessor().keyUp(Input.Keys.UP)) {
//            ship.getSpritePlus().setSprite(new Sprite(new Texture("img/sprites/ships/fighter/ship_blue.png")));
//        }

        if (Gdx.input.isKeyPressed(Input.Keys.DOWN))
            ship.setSpeed(ship.getSpeed() - mobility * Gdx.graphics.getDeltaTime());
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            ship.getLocation().z += mobility * Gdx.graphics.getDeltaTime() * 15;
            ship.setSpeed((float) (ship.getSpeed() * .99));
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            ship.getLocation().z -= mobility * Gdx.graphics.getDeltaTime() * 15;
            ship.setSpeed((float) (ship.getSpeed() * .99));
        }
        ship.getLocation().z = (ship.getLocation().z + 360) % 360;

//        if (Gdx.input.getInputProcessor() != null && Gdx.input.getInputProcessor().keyDown(Input.Keys.SPACE)) {
//            System.out.println("hi");
//            ship.fire();
//        }

        ship.fire(delta);

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
            cam.rotate(-1f, 0, 0, 1);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.NUMPAD_3)) {
            cam.rotate(1f, 0, 0, 1);
        }

    }

    @Override
    public boolean keyDown(int keycode) {
        if(keycode==Input.Keys.UP)
            ship.getSpritePlus().setSprite(new Sprite(new Texture("img/sprites/ships/fighter/ship_blue.png")));
        return super.keyUp(keycode);
    }
//    @Override
//    public boolean keyUp(int keycode) {
//        if(keycode==Input.Keys.UP)
//            ship.getSpritePlus().setSprite(new Sprite(new Texture("img/sprites/ships/fighter/ship_blue_fire.png")));
//        return super.keyUp(keycode);
//    }
    //    public boolean keyDown (int keycode) {
//        if(keycode== Input.Keys.SPACE) {
//            System.out.println("bye");
//            ship.fire();
//        }
//        return false;
//    }

}
