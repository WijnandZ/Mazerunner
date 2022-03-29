package nl.han.mazerunner.scenes;

import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.scenes.TileMapContainer;
import nl.han.mazerunner.Mazerunner;
import nl.han.mazerunner.entities.map.MuurMap;

public class MazeScene extends DynamicScene implements EntitySpawnerContainer, TileMapContainer {

    private Mazerunner mazerunner;

    public MazeScene(Mazerunner mazerunner) {
        this.mazerunner = mazerunner;
    }

    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/game_background.jpg");
        setBackgroundAudio("audio/game_background_music.mp3");
        setBackgroundAudioVolume(0.2);
    }

    @Override
    public void setupEntities() {

    }

    @Override
    public void setupEntitySpawners() {

    }

    @Override
    public void setupTileMaps() {
        addTileMap(new MuurMap());
    }


}
