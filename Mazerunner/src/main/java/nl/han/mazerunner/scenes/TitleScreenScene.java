package nl.han.mazerunner.scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.StaticScene;
import javafx.scene.Cursor;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import nl.han.mazerunner.Mazerunner;
import nl.han.mazerunner.entities.Button;
import nl.han.mazerunner.entities.StartButton;

public class TitleScreenScene extends StaticScene {

    private Mazerunner mazerunner;

    public TitleScreenScene(Mazerunner mazerunner) {
        this.mazerunner = mazerunner;
    }

    @Override
    public void setupScene() {
        setBackgroundAudio("audio/startscreen_theme.mp3");
        setBackgroundAudioVolume(0.3);
        setBackgroundImage("backgrounds/maze_background.jpg");
    }

    @Override
    public void setupEntities() {
        var titleText = new TextEntity(new Coordinate2D(getWidth() / 2, getHeight() / 4), "Mazerunner");
        titleText.setAnchorPoint(AnchorPoint.BOTTOM_CENTER);
        titleText.setFill(Color.WHITE);
        titleText.setFont(Font.font("Roboto", FontWeight.BOLD, 144));
        addEntity(titleText);

        var startButtonLocation = new Coordinate2D(getWidth() / 2, getHeight() / 2);
        String startButtonText = "Start Game";
        Color buttonColor = Color.WHITE;
        Color buttonEnterColor = Color.LIGHTGRAY;
        Cursor mouseCursor = Cursor.DEFAULT;
        Cursor buttonEnteredCursor = Cursor.HAND;
        Font startButtonFont = Font.font("Roboto", FontWeight.BOLD, 72);
        var startGameButton = new Button(startButtonLocation, startButtonText, mazerunner, buttonColor, mouseCursor, buttonEnterColor, buttonEnteredCursor, startButtonFont);
        startGameButton.setAnchorPoint(AnchorPoint.TOP_CENTER);
        addEntity(startGameButton);
    }
}
