package lighting.server.artnet;

import ch.bildspur.artnet.ArtNetClient;
import ch.bildspur.artnet.events.ArtNetServerEventAdapter;
import ch.bildspur.artnet.packets.ArtDmxPacket;
import ch.bildspur.artnet.packets.ArtNetPacket;
import lighting.server.frame.Frame;
import lighting.server.scene.Scene;
import lighting.server.sceneX.SceneX;
import org.springframework.stereotype.Component;

@Component
public class ArtnetListener {

    private final ArtNetClient artNetClient = new ArtNetClient();
    private Scene scene = new Scene();
    private SceneX sceneX = new SceneX();

    public ArtnetListener() {
        listenData();
    }

    public Scene getScene() {
        return scene;
    }

    public SceneX getSceneX() {
        return sceneX;
    }

    public void listenData(){
        artNetClient.getArtNetServer().addListener(
                new ArtNetServerEventAdapter() {
                    @Override public void artNetPacketReceived(ArtNetPacket packet) {
                        ArtDmxPacket dmxPacket = (ArtDmxPacket)packet;
                        scene = new Scene(1,"test",byteArrayToIntArray(dmxPacket.getDmxData()));
                    }
                });
        artNetClient.start();
    }

    public void recordData(){
        artNetClient.getArtNetServer().addListener(
                new ArtNetServerEventAdapter() {
                    @Override public void artNetPacketReceived(ArtNetPacket packet) {
                        ArtDmxPacket dmxPacket = (ArtDmxPacket)packet;
                        Frame frame = new Frame(byteArrayToIntArray(dmxPacket.getDmxData()), 100);
                        sceneX.getFrames().add(frame);
                    }
                });
        artNetClient.start();
    }


    public int[] byteArrayToIntArray(byte[] byteArray){
        int[] intArray = new int[512];
        int x = 0;
        for (byte b: byteArray
        ) {
            int i = (b & 0xFF);
            intArray[x] = i;
            x++;
        }
        return intArray;
    }
}