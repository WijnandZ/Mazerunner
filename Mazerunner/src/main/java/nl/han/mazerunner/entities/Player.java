package nl.han.mazerunner.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;
import com.github.hanyaeger.api.media.SoundClip;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.api.userinput.KeyListener;
import javafx.scene.input.KeyCode;
import nl.han.mazerunner.Mazerunner;
import nl.han.mazerunner.entities.Items.Key;
import nl.han.mazerunner.entities.Items.Pickaxe;
import nl.han.mazerunner.entities.enemies.MoveableEnemy;
import nl.han.mazerunner.entities.map.tiles.*;
import nl.han.mazerunner.entities.powerups.Live;
import nl.han.mazerunner.entities.powerups.Coin;
import nl.han.mazerunner.entities.text.LivesText;

import java.util.Set;

public class Player extends DynamicSpriteEntity implements SceneBorderTouchingWatcher, KeyListener, Collided, Collider {
    private Mazerunner mazerunner;
    private double lastX;
    private double lastY;
    private double currentX;
    private double currentY;
    private boolean hasPickaxe = false;
    private boolean hasKey = false;
    private int totalOfCoins;
    private int totalOfLives;
    private LivesText livesText;

    public Player(Coordinate2D initialLocation, Mazerunner mazerunner, int coins, int lives, LivesText livesText) {
        super("sprites/popetje.png", initialLocation, new Size(40, 40));
        this.mazerunner = mazerunner;
        this.totalOfCoins = coins;
        this.totalOfLives = lives;
        this.livesText = livesText;
    }

    @Override
    public void onCollision(Collider collidingObject) {
        if (collidingObject instanceof Wall) {
            calculateCoordinates((Wall) collidingObject);
        }
        if (collidingObject instanceof Teleporter) {
            setAnchorLocationX(((Teleporter) collidingObject).getTeleportX());
            setAnchorLocationY(((Teleporter) collidingObject).getTeleportY());
        }
        if (collidingObject instanceof Coin) {
            totalOfCoins++;
            ((Coin) collidingObject).remove();
        }
        if (collidingObject instanceof Live) {
            totalOfLives.setText(String.valueOf(getTotalOfLives()));
            ((Live) collidingObject).remove();
        }
        if (collidingObject instanceof Finish) {
            this.mazerunner.setActiveScene(2);
        }
        if (collidingObject instanceof Pickaxe) {
            hasPickaxe = true;
            ((Pickaxe) collidingObject).remove();
        }
        if (collidingObject instanceof Key) {
            hasKey = true;
            ((Key) collidingObject).remove();
        }
        if (collidingObject instanceof BreakableWall && hasPickaxe == true){
            ((BreakableWall) collidingObject).remove();
        }
        if (collidingObject instanceof Door && hasKey == true){
            ((Door) collidingObject).remove();
        }
        if (collidingObject instanceof MoveableEnemy) {
            SoundClip swordSound = new SoundClip("audio/sword_sound.mp3");
            swordSound.play();
            totalOfLives--;
            Coordinate2D startPoint = new Coordinate2D(70, 70);
            setAnchorLocation(startPoint);
            checkLives();
        }

    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> pressedKeys) {
        if (pressedKeys.contains(KeyCode.A) || pressedKeys.contains(KeyCode.LEFT)) {
            setLastLocation();
            setAnchorLocationX(getAnchorLocation().getX() - 60);
        } else if (pressedKeys.contains(KeyCode.D) || pressedKeys.contains(KeyCode.RIGHT)) {
            setLastLocation();
            setAnchorLocationX(getAnchorLocation().getX() + 60);
        } else if (pressedKeys.contains(KeyCode.W) || pressedKeys.contains(KeyCode.UP)) {
            setLastLocation();
            setAnchorLocationY(getAnchorLocation().getY() - 60);
        } else if (pressedKeys.contains(KeyCode.S) || pressedKeys.contains(KeyCode.DOWN)) {
            setLastLocation();
            setAnchorLocationY(getAnchorLocation().getY() + 60);
        }
        setCurrentLocation();
    }

    @Override
    public void notifyBoundaryTouching(final SceneBorder border) {
        switch (border) {
            case TOP:
                setAnchorLocationY(70);
                break;
            case BOTTOM:
                setAnchorLocationY(getSceneHeight() - 50);
                break;
            case LEFT:
                setAnchorLocationX(70);
                break;
            case RIGHT:
                setAnchorLocationX(getSceneWidth() - 50);
                break;
        }
    }

    private void calculateCoordinates(SpriteEntity collider){
        if(currentY - collider.getAnchorLocation().getY() == 10 && currentX - collider.getAnchorLocation().getX() == 10){
            if(lastX - currentX > 60 || lastX - currentX < -60) {
                if(currentX > getSceneWidth() / 2){
                    setAnchorLocationX(currentX - 60);
                } else {
                    setAnchorLocationX(currentX + 60);
                }
                setCurrentLocation();
            } else if(lastY - currentY > 60 || lastY - currentY < -60) {
                if(currentY > getSceneHeight() / 2){
                    setAnchorLocationY(currentY - 60);
                } else {
                    setAnchorLocationY(currentY + 60);
                }
                setCurrentLocation();
            } else {
                setAnchorLocationX(lastX);
                setAnchorLocationY(lastY);
            }
        }
    }

    private void checkLives(){
        if (totalOfLives == 0) {
            this.mazerunner.setActiveScene(2);
        }
    }

    private void setLastLocation(){
        lastX = getAnchorLocation().getX();
        lastY = getAnchorLocation().getY();
    }

    private void setCurrentLocation(){
        currentX = getAnchorLocation().getX();
        currentY = getAnchorLocation().getY();
    }

    public int getTotalOfCoins() {
        return totalOfCoins;
    }

    public int getTotalOfLives() {
        return totalOfLives;
    }

}
