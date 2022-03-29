package nl.han.mazerunner.scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.StaticScene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import nl.han.mazerunner.Mazerunner;
import nl.han.mazerunner.entities.Player;
import nl.han.mazerunner.entities.buttons.Button;
import nl.han.mazerunner.entities.buttons.QuitGameButton;

public class GameOverScene extends StaticScene {

    private Mazerunner mazerunner;
    private Player player;
    final private Color WHITE;
    final private Color LIGHTGRAY;
    final private String FONT;

    public GameOverScene(Mazerunner mazerunner, Player player) {
        this.mazerunner = mazerunner;
        this.player = player;
        WHITE = Color.WHITE;
        LIGHTGRAY = Color.LIGHTGRAY;
        FONT = "ROBOTO";
    }

    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/game_background.jpg");
        setBackgroundAudio("audio/game_background_music.mp3");
    }

    @Override
    public void setupEntities() {
        Coordinate2D gameOverLocation = new Coordinate2D(getWidth() / 2, getHeight() / 4);
        TextEntity gameOverText = new TextEntity(gameOverLocation, "Game Over!");
        gameOverText.setAnchorPoint(AnchorPoint.BOTTOM_CENTER);
        gameOverText.setFill(WHITE);
        gameOverText.setFont(Font.font(FONT, FontWeight.BOLD, 144));
        addEntity(gameOverText);

        Coordinate2D scoreBoardLocation = new Coordinate2D(getWidth() / 2, getHeight() / 3);
        TextEntity totalOfCoinsText = new TextEntity(scoreBoardLocation, "Total of coins found: " + player.getTotalOfCoins());
        totalOfCoinsText.setAnchorPoint(AnchorPoint.BOTTOM_CENTER);
        totalOfCoinsText.setFill(WHITE);
        totalOfCoinsText.setFont(Font.font(FONT, FontWeight.BOLD, 36));
        addEntity(totalOfCoinsText);

        TextEntity totalOfLivesText = new TextEntity(scoreBoardLocation, "Total of lives left: " + player.getTotalOfLives());
        totalOfLivesText.setAnchorPoint(AnchorPoint.TOP_CENTER);
        totalOfLivesText.setFill(WHITE);
        totalOfLivesText.setFont(Font.font(FONT, FontWeight.BOLD, 36));
        addEntity(totalOfLivesText);

        String quitGameText = "Quit Game";
        Font startButtonFont = Font.font(FONT, FontWeight.BOLD, 72);
        Coordinate2D quitGameButtonLocation = new Coordinate2D(getWidth() / 2, getHeight() / 2);
        Button quitGameButton = new QuitGameButton(quitGameButtonLocation, quitGameText, WHITE, LIGHTGRAY, startButtonFont, mazerunner);
        quitGameButton.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(quitGameButton);
    }
}
