package net.mc.tools.utilities;


import io.socket.emitter.Emitter;
import io.socket.client.IO;
import io.socket.client.Socket;
import org.junit.Assert;


import java.net.URISyntaxException;

public class SocketConnection {
    public static void checkPublishedMessageOnSocket(String configId, String message) throws URISyntaxException {

        IO.Options options = new IO.Options();
        options.forceNew = true;

        options.query = "secret=" + configId;
//        options.query = "secret=5bbc7d86ad2a1a005ed314ee";

        Socket socket = IO.socket("http://enablers01-dev-dan-configuration-service.enablers01-dev.svc.cluster.local", options);


        socket.on(Socket.EVENT_CONNECT, new Emitter.Listener() {
            @Override
            public void call(Object... objects) {
                System.out.println("Connected");

                socket.on("configUpdate", new Emitter.Listener() {
                    @Override
                    public void call(Object... objects) {

                        for (Object socketMessage : objects) {

                            Assert.assertTrue(socketMessage.toString().contains(message));

                            System.out.println(socketMessage.toString());
                        }
                        socket.disconnect();
                    }
                });
            }
        });

        socket.connect();
    }

//    public static void main(String args[]) throws URISyntaxException {
//        checkPublishedMessageOnSocket("5bbc7d86ad2a1a005ed314ee", "name");
//    }
}
