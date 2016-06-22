package rocks.astroid.astroid.core.client;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import rocks.astroid.astroid.core.logic.Fighter;
import rocks.astroid.astroid.core.logic.Ship;

public class GlobalFunctions {

    public static Sprite getSprite(Ship ship) {
        Sprite sprite = null;
        if(ship instanceof Fighter) {
            if(ship.getTeam() == Ship.team.BLUE) {
                sprite = new Sprite(new Texture("img/sprites/ships/fighter/ship_blue.png"));
            } else if(ship.getTeam() == Ship.team.RED) {
                sprite = new Sprite(new Texture("img/sprites/ships/fighter/ship_red.png"));
            } else {
                sprite = new Sprite(new Texture("img/sprites/ships/fighter/ship_purple.png"));
            }
        }
        return sprite;
    }
}
