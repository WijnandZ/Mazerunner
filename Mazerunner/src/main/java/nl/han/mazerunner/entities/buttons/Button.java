package nl.han.mazerunner.entities.buttons;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.api.userinput.MouseEnterListener;
import com.github.hanyaeger.api.userinput.MouseExitListener;
import javafx.scene.Cursor;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public abstract class Button extends TextEntity implements MouseButtonPressedListener, MouseEnterListener, MouseExitListener {
    private Color buttonColor;
    private Color buttonEnterColor;

    public Button(Coordinate2D initialLocation, String text, Color buttonColor, Color buttonEnterColor, Font font) {
        super(initialLocation, text);
        this.buttonColor = buttonColor;
        this.buttonEnterColor = buttonEnterColor;
        setFill(buttonColor);
        setFont(font);
    }

    @Override
    public void onMouseEntered() {
        setFill(buttonEnterColor);
        setCursor(Cursor.HAND);
    }

    @Override
    public void onMouseExited() {
        setFill(buttonColor);
        setCursor(Cursor.DEFAULT);
    }
}
