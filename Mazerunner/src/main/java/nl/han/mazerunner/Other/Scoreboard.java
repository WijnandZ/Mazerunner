package nl.han.mazerunner.Other;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class Scoreboard extends TextEntity {

    public Scoreboard(Coordinate2D location) {
        super(location, "Your life's: 0 Your coins: 0");
        setFont(Font.font("ROBOTO", FontWeight.BOLD, 36));
    }

    public void update(int totalOfLifes, int totalOfCoins){
        setText("Your life's: " + totalOfLifes + " Your coins: " + totalOfCoins);
    }


}
