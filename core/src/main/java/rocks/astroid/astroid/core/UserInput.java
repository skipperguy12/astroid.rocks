package rocks.astroid.astroid.core;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector3;
import rocks.astroid.astroid.core.client.GlobalFunctions;
import rocks.astroid.astroid.core.logic.ships.CombatShip;
import rocks.astroid.astroid.core.screens.Play;
import rocks.astroid.astroid.physics.Body;
import rocks.astroid.astroid.physics.Vec2;

import javax.swing.plaf.basic.BasicTabbedPaneUI;

/**
 * Takes input from player
 */
public class UserInput extends InputAdapter {
    private CombatShip ship;
    private Body body;
    private OrthographicCamera cam;

    public UserInput(CombatShip ship, OrthographicCamera cam)
    {
        this.ship = ship;
        body = GlobalFunctions.PhysicsManager.getBody(ship);
        this.cam = cam;
    }
    public void handleInput(float delta) {

        //float mobility = ship.getThrust() / ship.getMass();
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            GlobalFunctions.PhysicsManager.getBody(ship).applyForce(new Vec2(
                    (float) StrictMath.cos(body.getOrient())* 10 ,
                    (float) StrictMath.sin(body.getOrient())* 10
            ));
            //ship.setSpeed(ship.getSpeed() + mobility * Gdx.graphics.getDeltaTime());
            //ship.getSpritePlus().setSprite(GlobalFunctions.getMovingShipSprite(ship));
        }
//        if (Gdx.input.getInputProcessor().keyUp(Input.Keys.UP)) {
//            ship.getSpritePlus().setSprite(new Sprite(new Texture("img/sprites/ships/fighter/ship_blue.png")));
//        }

        if (Gdx.input.isKeyPressed(Input.Keys.DOWN))
            GlobalFunctions.PhysicsManager.getBody(ship).applyForce(new Vec2(
                    (float) (-1f * StrictMath.cos(body.getOrient())* 10) ,
                    (float) (-1f * StrictMath.sin(body.getOrient())* 10)
            ));
            //ship.setSpeed(ship.getSpeed() - mobility * Gdx.graphics.getDeltaTime());
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            //ship.getLocation().z += mobility * Gdx.graphics.getDeltaTime() * 15;
            //ship.setSpeed((float) (ship.getSpeed() * .995));
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            //ship.getLocation().z -= mobility * Gdx.graphics.getDeltaTime() * 15;
            //ship.setSpeed((float) (ship.getSpeed() * .995));
        }
        //ship.getLocation().z = (ship.getLocation().z + 360) % 360;

//        if (Gdx.input.getInputProcessor() != null && Gdx.input.getInputProcessor().keyDown(Input.Keys.SPACE)) {
//            System.out.println("hi");
//            ship.fire();
//        }

        if (Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
            Vector3 asdf = ((Play) ((Game) Gdx.app.getApplicationListener()).getScreen()).getMousePosInGameWorld();
            System.out.println("asdf = " + asdf);
        }

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
    public boolean keyUp(int keycode) {
        if(keycode==Input.Keys.UP) {
            //ship.getSpritePlus().setSprite(GlobalFunctions.getShipSprite(ship));
        }
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
