package lighting.server.sceneX;

import lighting.server.IO.IIOService;
import lighting.server.artnet.ArtnetListener;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Component
public class SceneXXServiceImpl implements ISceneXService {

    private Path parentDir = Paths.get(System.getProperty("user.dir")).getParent();
    private Path scenesDir = Paths.get(parentDir + "/scenes/");

    private ArtnetListener artnetListener;

    private final IIOService iOService;

    public SceneXXServiceImpl(IIOService iOService) {
        this.iOService = iOService;
        createDirectory(scenesDir);
    }

    public void createDirectory(Path dir) {
        File file = new File(String.valueOf(dir));
        if (!file.exists()) {
            if (file.mkdir()) {
                System.out.println("Directory is created!");
            } else {
                System.out.println("Failed to create directory!");
            }
        }
    }

    public void recordScene(int button_id) {
        artnetListener = new ArtnetListener(this);
        artnetListener.recordData(button_id);
        System.out.println("test made");
    }

    public void playSceneFromButton(int button) throws IOException {
        List<SceneX> scenes = iOService.getAllScenesFromDisk();

        for (SceneX scene : scenes) {
            if (scene.getButtonId() == button) {
                //TODO play scene
                System.out.println("playing scene from button");
            }

        }

    }

    public void saveScenesToJSON(SceneX sceneX) throws IOException {
        this.iOService.saveScenesToJSON(sceneX);
    }

    public List<SceneX> getAllScenesFromDisk() throws IOException {
        return this.iOService.getAllScenesFromDisk();

    }

    public void deleteSceneFromDisk(String scene_id) throws IOException {
        this.iOService.deleteSceneFromDisk(scene_id);
    }

    public SceneX getSceneFromDisk(String scene_id) throws IOException {
        return this.iOService.getSceneFromDisk(scene_id);

    }

    public void updateSceneFromDisk(SceneX sceneX) throws IOException {
        this.iOService.updateSceneFromDisk(sceneX);

    }

    public List<Integer> getButtonsWithScene() throws IOException {
        return this.iOService.getButtonsWithScene();
    }

    public List<Integer> getButtonsWithoutScene() throws IOException {
        return this.iOService.getButtonsWithoutScene();

    }




}
