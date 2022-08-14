package model;

import java.awt.image.BufferedImage;

public class Sprite {
    private double x, y;
    private int width, height;
    private BufferedImage image;
    private GameObjectType type;

    public Sprite(int x, int y)
    {
        this.x = x;
        this.y = y;
        this.width = 48;
        this.height = 48;
    }

    public boolean checkOverlap(Sprite sprite){
        boolean result = true;

        if(this.getX() >= sprite.getX() + sprite.getWidth()){
            result = false;
        } else if(this.getX() + this.getWidth() <= sprite.getX()){
            result = false;
        } else if(this.getY() >= sprite.getY() + sprite.getHeight()){
            result = false;
        } else if(this.getY() + this.getHeight() <= sprite.getY()){
            result = false;
        }

        return result;
    }

    public BufferedImage getCurrentImage() {
        return image;
    }

    public void setCurrentImage(BufferedImage image) {
        this.image = image;
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

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }
}
