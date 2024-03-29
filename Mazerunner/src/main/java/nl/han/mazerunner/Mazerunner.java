package nl.han.mazerunner;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.YaegerGame;
import nl.han.mazerunner.Other.Scoreboard;
import nl.han.mazerunner.entities.Player;
import nl.han.mazerunner.scenes.GameOverScene;
import nl.han.mazerunner.scenes.MazeScene;
import nl.han.mazerunner.scenes.TitleScreenScene;

public class Mazerunner extends YaegerGame {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void setupGame() {
        setGameTitle("Mazerunner");
        setSize(new Size(1920, 1080));
    }

    @Override
    public void setupScenes() {
        Scoreboard scoreboard = new Scoreboard(new Coordinate2D(0, 0));
        Player player = new Player(new Coordinate2D(70, 70), this, 0, 2, scoreboard);
        addScene(0, new TitleScreenScene(this));
        addScene(1, new MazeScene(player));
        addScene(2, new GameOverScene(this, player));
    }
}
