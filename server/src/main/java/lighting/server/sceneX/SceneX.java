package lighting.server.sceneX;

import lighting.server.frame.Frame;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SceneX {

    private String id = UUID.randomUUID().toString();
    private String name;
    private Long duration;
    private int fadeTime;
    private int universe;
    private int buttonId;
    private LocalDateTime createdOn;
    private List<Frame> frames = new ArrayList<>();

    public SceneX(String name, List<Frame> frames) {
        this.name = name;
        this.frames = frames;
    }

    public SceneX(String name, int buttonId, List<Frame> frames) {
        this.name = name;
        this.buttonId = buttonId;
        this.frames = frames;
    }

    public SceneX(String name, Long duration, int buttonId, int fadeTime, int universe,  LocalDateTime createdOn, List<Frame> frames) {
        this.name = name;
        this.duration = duration;
        this.buttonId = buttonId;
        this.fadeTime = fadeTime;
        this.universe = universe;
        this.createdOn = createdOn;
        this.frames = frames;
    }

    public SceneX() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public int getButtonId() {
        return buttonId;
    }

    public void setButtonId(int buttonId) {
        this.buttonId = buttonId;
    }

    public int getFadeTime() {
        return fadeTime;
    }

    public void setFadeTime(int fadeTime) {
        this.fadeTime = fadeTime;
    }

    public int getUniverse() {
        return universe;
    }

    public void setUniverse(int universe) {
        this.universe = universe;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public List<Frame> getFrames() {
        return frames;
    }

    public void setFrames(List<Frame> frames) {
        this.frames = frames;
    }

    public String getId() { return id; }
}
