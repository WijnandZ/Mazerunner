package nl.han.mazerunner.entities.text;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class LivesText extends TextEntity {
    public LivesText(Coordinate2D location) {
        super(location);
        setFont(Font.font("Roboto", FontWeight.BOLD, 30));
        setFill(Color.WHITE);
    }

    public void setText(int lives){
        setText("Lives: " + lives);
    }
}
