package nl.han.mazerunner.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.api.userinput.MouseEnterListener;
import com.github.hanyaeger.api.userinput.MouseExitListener;
import javafx.scene.Cursor;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import nl.han.mazerunner.Mazerunner;

public class Button extends TextEntity implements MouseButtonPressedListener, MouseEnterListener, MouseExitListener {
    private final Mazerunner mazerunner;
    private Color buttonColor;
    private Cursor mouseCursor;
    private Color buttonEnterColor;
    private Cursor buttonEnterCursor;

    public Button(Coordinate2D initialLocation, String text, Mazerunner mazerunner, Color buttonColor, Cursor mouseCursor, Color buttonEnterColor, Cursor buttonEnterCursor, Font font) {
        super(initialLocation, text);
        this.mazerunner = mazerunner;
        this.buttonColor = buttonColor;
        this.mouseCursor = mouseCursor;
        this.buttonEnterColor = buttonEnterColor;
        this.buttonEnterCursor = buttonEnterCursor;
        setFill(buttonColor);
        setFont(font);
    }

    @Override
    public void onMouseButtonPressed(MouseButton button, Coordinate2D coordinate2D) {
        mazerunner.setActiveScene(1);
    }

    @Override
    public void onMouseEntered() {
        setFill(buttonEnterColor);
        setCursor(buttonEnterCursor);
    }

    @Override
    public void onMouseExited() {
        setFill(buttonColor);
        setCursor(mouseCursor);
    }
}
