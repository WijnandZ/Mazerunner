package nl.han.mazerunner.scenes;

import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.scenes.TileMapContainer;
import nl.han.mazerunner.Mazerunner;
import nl.han.mazerunner.entities.Player;
import nl.han.mazerunner.entities.map.WallMap;
import nl.han.mazerunner.entities.powerups.Live;
import nl.han.mazerunner.entities.powerups.Coin;

public class MazeScene extends DynamicScene implements TileMapContainer {

    private Mazerunner mazerunner;
    private Player player;

    public MazeScene(Mazerunner mazerunner, Player player) {
        this.mazerunner = mazerunner;
        this.player = player;
    }

    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/game_background.jpg");
        setBackgroundAudio("audio/game_background_music.mp3");
        setBackgroundAudioVolume(0.2);
    }

    @Override
    public void setupEntities() {
        int powerUpWidth = 40;
        var powerUpSize = new Size(powerUpWidth, powerUpWidth);
        addEntity(new Live(powerUpSize));
        for (int i = 0; i <= 15; i++) {
            addEntity(new Coin(powerUpSize));
        }
        addEntity(player);
    }

    @Override
    public void setupTileMaps() {
        addTileMap(new WallMap());
    }
}
