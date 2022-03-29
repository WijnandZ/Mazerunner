package nl.han.mazerunner.scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.StaticScene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import nl.han.mazerunner.Mazerunner;
import nl.han.mazerunner.entities.buttons.Button;
import nl.han.mazerunner.entities.buttons.StartGameButton;

public class TitleScreenScene extends StaticScene {

    private Mazerunner mazerunner;
    final private String FONT;
    final private Color WHITE;
    final private Color LIGHTGRAY;

    public TitleScreenScene(Mazerunner mazerunner) {
        this.mazerunner = mazerunner;
        this.FONT = "ROBOTO";
        this.WHITE = Color.WHITE;
        this.LIGHTGRAY = Color.LIGHTGRAY;
    }

    @Override
    public void setupScene() {
        setBackgroundAudio("audio/startscreen_theme.mp3");
        setBackgroundAudioVolume(0.3);
        setBackgroundImage("backgrounds/maze_background.jpg");
    }

    @Override
    public void setupEntities() {
        Coordinate2D textLocation = new Coordinate2D(getWidth() / 2, getHeight() / 4);
        TextEntity titleText = new TextEntity(textLocation, "Mazerunner");
        titleText.setAnchorPoint(AnchorPoint.BOTTOM_CENTER);
        titleText.setFill(WHITE);
        titleText.setFont(Font.font(FONT, FontWeight.BOLD, 144));
        addEntity(titleText);

        Coordinate2D buttonLocation = new Coordinate2D(getWidth() / 2, getHeight() / 2);
        String startButtonText = "Start Game";
        Font startButtonFont = Font.font(FONT, FontWeight.BOLD, 72);
        Button startGameButton = new StartGameButton(buttonLocation, startButtonText, WHITE, LIGHTGRAY, startButtonFont, mazerunner);
        startGameButton.setAnchorPoint(AnchorPoint.TOP_CENTER);
        addEntity(startGameButton);
    }
}
