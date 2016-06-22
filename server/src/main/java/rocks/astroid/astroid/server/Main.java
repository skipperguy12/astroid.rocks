package rocks.astroid.astroid.server;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.Server;
import rocks.astroid.astroid.server.packets.TestPacket;

import java.io.IOException;

public class Main {
    static boolean messageReceived = false;
    public static void main(String... args) throws IOException {

        Server server = new Server();
        server.start();
        server.bind(54555, 54777);
        Kryo kryo = server.getKryo();

        kryo.register(TestPacket.class);
        server.addListener(new ServerListener());

        while(!messageReceived) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
