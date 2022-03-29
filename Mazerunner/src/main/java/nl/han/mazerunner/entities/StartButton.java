package nl.han.mazerunner.entities;

import com.github.hanyaeger.api.Coordinate2D;
import javafx.scene.Cursor;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import nl.han.mazerunner.Mazerunner;

public class StartButton extends Button{
    public StartButton(Coordinate2D initialLocation, String text, Mazerunner mazerunner, Color buttonColor, Cursor mouseCursor, Color buttonEnterColor, Cursor buttonEnterCursor, Font font) {
        super(initialLocation, text, mazerunner, buttonColor, mouseCursor, buttonEnterColor, buttonEnterCursor, font);
    }
}
