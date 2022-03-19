package model;

import java.awt.*;

public class Entity extends GameObject{
    private double speedX, speedY;

    public Entity(double x, double y){
        super(x, y);
        this.setDimension(36, 36);
    }

    public void updateX(){
        this.setX(this.getX() + this.speedX);
    }

    public void updateY(){
        this.setY(this.getY() - this.speedY);
    }

    public void changeSpeedX(double change){
        if(speedX + change <= 5 && speedX + change >= -5) {
            speedX += change;
        }
    }

    public void changeSpeedY(double change){
        if(speedY + change <= 5 && speedY + change >= -5) {
            speedY += change;
        }
    }

    public void horizontalCollision(GameObject gameObject) {

        if (checkOverlap(gameObject)) {
            if (this.getSpeedX() > 0) {
                this.setX(gameObject.getX() - this.getDimension().width - 1);
            } else if (this.getSpeedX() < 0) {
                this.setX(gameObject.getX() + gameObject.getDimension().width + 1);
            }
            this.setSpeedX(0);
        }
    }
    public void verticalCollision(GameObject gameObject){
        if(checkOverlap(gameObject)) {
            if (this.getSpeedY() > 0) {
                this.setY(gameObject.getY() + gameObject.getDimension().height + 1);
            } else if (this.getSpeedY() < 0) {
                this.setY(gameObject.getY() - this.getDimension().height - 1);
            }
            this.setSpeedY(0);
        }
    }

    public double getSpeedX() {
        return speedX;
    }

    public void setSpeedX(double speedX) {
        this.speedX = speedX;
    }

    public double getSpeedY() {
        return speedY;
    }

    public void setSpeedY(double speedY) {
        this.speedY = speedY;
    }
}
