package rocks.astroid.astroid.server;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import rocks.astroid.astroid.server.exception.UnknownPacketException;
import rocks.astroid.astroid.server.packets.Packet;
import rocks.astroid.astroid.server.packets.TestPacket;

public class ServerListener extends Listener {
    public void received (Connection connection, Object object) {
        if(!(object instanceof Packet))
            throw new UnknownPacketException("Packet object " + object + " cannot be handled by ServerListener as it is an unknown packet");

        if (object instanceof TestPacket) {
            TestPacket request = (TestPacket) object;
            System.out.println(request.text);

            TestPacket response = new TestPacket();
            response.text = "Thanks";
            connection.sendTCP(response);
        }
    }
}
