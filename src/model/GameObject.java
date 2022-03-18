package model;

import java.awt.*;
import java.awt.image.BufferedImage;

abstract public class GameObject {
    private double x, y;
    private double speedX, speedY;
    private Dimension dimension;
    private BufferedImage image;

    public GameObject(double x, double y){
        this.x = x;
        this.y = y;
        this.dimension = new Dimension(48, 48);
    }

    public void updateX(){
        this.x += this.speedX;
    }

    public void updateY(){
        this.y -= this.speedY;
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

    public boolean checkCollision(GameObject gameObject){
        boolean result = true;

        if(this.getX() > gameObject.getX() + gameObject.dimension.width){
            result = false;
        } else if(this.getX() + this.dimension.width < gameObject.getX()){
            result = false;
        } else if(this.getY() > gameObject.getY() + gameObject.dimension.height){
            result = false;
        } else if(this.getY() + this.dimension.height < gameObject.getY()){
            result = false;
        }

        return result;
    }

    public void handleCollision(GameObject gameObject){
        if(checkCollision(gameObject)) {
            if (this.getSpeedX() > 0) {
                this.setX(gameObject.getX() - this.dimension.width - 1);
            } else if (this.getSpeedX() < 0) {
                this.setX(gameObject.getX() + gameObject.dimension.width + 1);
            }
            if (this.getSpeedY() > 0) {
                this.setY(gameObject.getY() + gameObject.dimension.height + 1);
            } else if (this.getSpeedY() < 0) {
                this.setY(gameObject.getY() - this.dimension.height - 1);
            }
            this.setSpeedX(0);
            this.setSpeedY(0);
        }
    }

    public void setLocation(double x, double y) {
        setX(x);
        setY(y);
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public Dimension getDimension(){
        return dimension;
    }

    public void setDimension(Dimension dimension) {
        this.dimension = dimension;
    }

    public void setDimension(int width, int height){ this.dimension =  new Dimension(width, height); }

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

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

//    public Rectangle getTopBounds(){
//        return new Rectangle((int)x+dimension.width/6, (int)y, 2*dimension.width/3, dimension.height/2);
//    }
//
//    public Rectangle getBottomBounds(){
//        return new Rectangle((int)x+dimension.width/6, (int)y + dimension.height/2, 2*dimension.width/3, dimension.height/2);
//    }
//
//    public Rectangle getLeftBounds(){
//        return new Rectangle((int)x, (int)y + dimension.height/4, dimension.width/4, dimension.height/2);
//    }
//
//    public Rectangle getRightBounds(){
//        return new Rectangle((int)x + 3*dimension.width/4, (int)y + dimension.height/4, dimension.width/4, dimension.height/2);
//    }
//
//    public Rectangle getBounds(){
//        return new Rectangle((int)x, (int)y, dimension.width, dimension.height);
//    }
}
