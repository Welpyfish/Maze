package model;

import java.awt.*;

public class Entity extends GameObject{
    private double speedX, speedY;
    private int hp;

    public Entity(double x, double y){
        super(x, y);
        this.setDimension(36, 36);
    }

    public void takeDamage(int damage){
        if(this.hp - damage > 0){
            this.hp -= damage;
        }
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

    public boolean horizontalCollision(GameObject gameObject) {
        boolean result = false;
        if (checkOverlap(gameObject)) {
            if (this.getSpeedX() > 0) {
                this.setX(gameObject.getX() - this.getDimension().width);
            } else if (this.getSpeedX() < 0) {
                this.setX(gameObject.getX() + gameObject.getDimension().width);
            }
            this.setSpeedX(0);
            result = true;
        }
        return result;
    }
    public boolean verticalCollision(GameObject gameObject){
        boolean result = false;
        if(checkOverlap(gameObject)) {
            if (this.getSpeedY() > 0) {
                this.setY(gameObject.getY() + gameObject.getDimension().height);
            } else if (this.getSpeedY() < 0) {
                this.setY(gameObject.getY() - this.getDimension().height);
            }
            this.setSpeedY(0);
            result = true;
        }
        return result;
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

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
}
