package rocks.astroid.astroid.core.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import rocks.astroid.astroid.server.packets.TestPacket;

import java.io.IOException;

public class TestClient implements Screen {

    private SpriteBatch batch;
    private Sprite ship;

    public TestClient() {
        Client client = new Client();
        client.start();
        try {
            client.connect(5000, "localhost", 54555, 54777);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Kryo kryo = client.getKryo();
        kryo.register(TestPacket.class);



        TestPacket request = new TestPacket();
        request.text = "Here is the request";
        client.sendTCP(request);

        client.addListener(new Listener() {
            public void received (Connection connection, Object object) {
                if (object instanceof TestPacket) {
                    TestPacket response = (TestPacket)object;
                    System.out.println(response.text);
                }
            }
        });

    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        handleInputs();

        batch.begin();
            ship.draw(batch);
        batch.end();
    }

    private void handleInputs() {
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            ship.setX(ship.getX()-2);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            ship.setX(ship.getX()+2);
        }
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void show() {

        batch = new SpriteBatch();
        ship = new Sprite(new Texture("img/sprites/ships/fighter/ship_blue.png"));
        ship.setScale(.5f, .5f);
    }

    @Override
    public void hide() {

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
    }
}
