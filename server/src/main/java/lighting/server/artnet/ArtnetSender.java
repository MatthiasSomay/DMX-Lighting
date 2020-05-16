package lighting.server.artnet;

import ch.bildspur.artnet.ArtNetClient;
import lighting.server.frame.Frame;
import lighting.server.scene.Scene;

import java.util.List;

public class ArtnetSender {

    private final ArtNetClient artNetClient = new ArtNetClient();
    private Scene sceneToPlay;
    private List<int[]> fadingList;

    public ArtnetSender() {
    }

    public void setSceneToPlay(Scene sceneToPlay) {
        this.sceneToPlay = sceneToPlay;
    }


    public Scene getSceneToPlay() {
        return sceneToPlay;
    }

    public void setFadingList(List<int[]> fadingList) {
        this.fadingList = fadingList;
    }

    public List<int[]> getFadingList() {
        return fadingList;
    }

    public void sendData() {

        for (Frame frame : sceneToPlay.getFrames()) {
            byte[] dmxData = intArrayToByteArray(frame.getDmxValues());
            if (!artNetClient.isRunning()) {
                artNetClient.start();
            }

            artNetClient.broadcastDmx(0, sceneToPlay.getUniverse(), dmxData);

        }

        //artNetClient.stop();


    }

    public void sendFrame() {
        if (!artNetClient.isRunning()) {
            artNetClient.start();
        }
        for (int[] frame : fadingList) {
            byte[] dmxData = intArrayToByteArray(frame);
            artNetClient.broadcastDmx(0, sceneToPlay.getUniverse(), dmxData);

        }
        System.out.println("Frame verstuurd");
        artNetClient.stop();
    }


    public byte[] intArrayToByteArray(int[] intArray) {
        byte[] byteArray = new byte[512];

        for (int i = 0; i < 512; i++) {
            byte b = (byte) (intArray[i] & 0xFF);
            byteArray[i] = b;
        }
        return byteArray;
    }


}


