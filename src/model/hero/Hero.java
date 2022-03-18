package model.hero;

import manager.ButtonAction;
import model.GameObject;
import view.ImageLoader;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Hero extends GameObject {
    private ButtonAction actionX;
    private ButtonAction actionY;

    public Hero(double x, double y){
        super(x, y);

        ImageLoader imageLoader = new ImageLoader();

        BufferedImage sprite = imageLoader.loadImage("/media/sprite.png");
        this.setImage(sprite.getSubimage(48, 0, 48, 48));
        setDimension(48,48);
        //remainingLives = 3;
        //points = 0;
        //coins = 0;
        //invincibilityTimer = 0;

        //BufferedImage[] leftFrames = imageLoader.getLeftFrames(MarioForm.SMALL);
        //BufferedImage[] rightFrames = imageLoader.getRightFrames(MarioForm.SMALL);

        //Animation animation = new Animation(leftFrames, rightFrames);
        //marioForm = new MarioForm(animation, false, false);
        //setStyle(marioForm.getCurrentStyle(toRight, false, false));
    }

    public void updateMoveDirection(ButtonAction x, ButtonAction y)
    {
        actionX = x;
        actionY = y;

        if (x == ButtonAction.MOVE_LEFT)
        {
            changeSpeedX(-1);
        }
        if (x == ButtonAction.MOVE_RIGHT)
        {
            changeSpeedX(1);
        }
        if (y == ButtonAction.MOVE_UP)
        {
            changeSpeedY(1);
        }
        if (y == ButtonAction.MOVE_DOWN)
        {
            changeSpeedY(-1);
        }
        if (x == ButtonAction.NO_ACTION){
            setSpeedX(0);
        }
        if (y == ButtonAction.NO_ACTION){
            setSpeedY(0);
        }
    }

    public void update()
    {
        if (actionX != ButtonAction.NO_ACTION) {
            updateX();
        }
        if (actionY != ButtonAction.NO_ACTION) {
            updateY();
        }
    }
}
