package nl.han.mazerunner.entities.buttons;

import com.github.hanyaeger.api.Coordinate2D;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import nl.han.mazerunner.Mazerunner;

public class BackToTitleScreenButton extends Button{

    private Mazerunner mazerunner;

    public BackToTitleScreenButton(Coordinate2D initialLocation, String text, Color buttonColor, Color buttonEnterColor, Font font, Mazerunner mazerunner) {
        super(initialLocation, text, buttonColor, buttonEnterColor, font);
        this.mazerunner = mazerunner;
    }

    @Override
    public void onMouseButtonPressed(MouseButton button, Coordinate2D coordinate2D) {
        mazerunner.setActiveScene(0);
    }
}
