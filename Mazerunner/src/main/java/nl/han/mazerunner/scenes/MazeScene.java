package nl.han.mazerunner.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.scenes.TileMapContainer;
import nl.han.mazerunner.entities.Items.*;
import nl.han.mazerunner.entities.Player;
import nl.han.mazerunner.entities.enemies.Boss;
import nl.han.mazerunner.entities.enemies.Enemy;
import nl.han.mazerunner.entities.enemies.Knight;
import nl.han.mazerunner.entities.map.MazeMap;

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
        Coordinate2D swordLocation = new Coordinate2D(70, 850);

        addEntity(new Pickaxe(defaultSize));
        addEntity(new Key(defaultSize));
        addEntity(new Sword(swordLocation, defaultSize));
        for (int i = 0; i < 3; i++) {
            addEntity(new Life(defaultSize));
        }
        for (int i = 0; i < 15; i++) {
            addEntity(new Coin(defaultSize));
        }
        addEntity(player);

        int enemySpeed = 8;
        Coordinate2D enemy1Location = new Coordinate2D(70, 430);
        Coordinate2D enemy2Location = new Coordinate2D(1330, 730);
        Coordinate2D enemy3Location = new Coordinate2D(1690, 850);
        Coordinate2D enemy4Location = new Coordinate2D(1810, 910);
        Enemy[] allEnemies = {
            new Knight(enemy1Location, defaultSize, "sprites/enemy.png", enemySpeed),
            new Knight(enemy2Location, defaultSize, "sprites/enemy.png", enemySpeed),
            new Knight(enemy3Location, defaultSize, "sprites/enemy.png", enemySpeed),
            new Boss(enemy4Location, defaultSize, "sprites/boss_enemy.png")
        };
        for (Enemy enemy: allEnemies) {
            addEntity(enemy);
            enemy.move();
        }


        addEntity(player.getScoreboard());
    }

    @Override
    public void setupTileMaps() {
        addTileMap(new MazeMap());
    }
}
