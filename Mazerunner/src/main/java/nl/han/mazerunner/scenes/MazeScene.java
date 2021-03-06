package nl.han.mazerunner.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.scenes.TileMapContainer;
import nl.han.mazerunner.entities.Items.Key;
import nl.han.mazerunner.entities.Items.Pickaxe;
import nl.han.mazerunner.entities.Player;
import nl.han.mazerunner.entities.enemies.MoveableEnemy;
import nl.han.mazerunner.entities.map.MazeMap;
import nl.han.mazerunner.entities.powerups.Live;
import nl.han.mazerunner.entities.powerups.Coin;

public class MazeScene extends DynamicScene implements TileMapContainer {
    private Player player;

    public MazeScene(Player player) {
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
        int defaultWidth = 40;
        Size defaultSize = new Size(defaultWidth, defaultWidth);

        addEntity(new Pickaxe(defaultSize));
        addEntity(new Key(defaultSize));
        for (int i = 0; i < 3; i++) {
            addEntity(new Live(defaultSize));
        }
        for (int i = 0; i < 15; i++) {
            addEntity(new Coin(defaultSize));
        }
        addEntity(player);

        int enemySpeed = 8;
        Coordinate2D enemy1Location = new Coordinate2D(70, 430);
        Coordinate2D enemy2Location = new Coordinate2D(1330, 730);
        Coordinate2D enemy3Location = new Coordinate2D(1690, 850);
        MoveableEnemy enemy1 = new MoveableEnemy(enemy1Location, defaultSize, "sprites/enemy.png", enemySpeed);
        MoveableEnemy enemy2 = new MoveableEnemy(enemy2Location, defaultSize, "sprites/enemy.png", enemySpeed);
        MoveableEnemy enemy3 = new MoveableEnemy(enemy3Location, defaultSize, "sprites/enemy.png", enemySpeed);
        addEntity(enemy1);
        addEntity(enemy2);
        addEntity(enemy3);
    }

    @Override
    public void setupTileMaps() {
        addTileMap(new MazeMap());
    }
}
