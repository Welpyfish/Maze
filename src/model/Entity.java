package model;

import model.hero.HeroAction;
import model.item.Weapon;

import java.awt.*;
import java.util.ArrayList;

public class Entity extends GameObject{
    private double speedX, speedY;
    private int hp;
    private boolean isHit;
    private Weapon weapon;

    public Entity(double x, double y, Weapon weapon){
        super(x, y);
        this.setDimension(36, 36);
        this.weapon = weapon;
        isHit = false;
        weapon.setX(getX());
        weapon.setY(getY());
    }

    public void changeHp(int damage){
        if(this.hp + damage > 0){
            this.hp += damage;
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

    public void updateAction(byte action, Map map){
        weapon.updateLocation(this);
        if ((action & HeroAction.ATTACK) != 0){
            weapon.attack(this, map);
        }
    }

    public void updateLocation(byte movement, Map map) {
        //updateStates(action);
        move(movement);
        updateMovement(map);
    }

    private void move(byte movement) {
        if ((movement & HeroAction.MOVE_LEFT) == 0 && (movement & HeroAction.MOVE_RIGHT) == 0) {
            setSpeedX(0);
        } else {
            if ((movement & HeroAction.MOVE_LEFT) != 0) {
                changeSpeedX(-1);
            }
            if ((movement & HeroAction.MOVE_RIGHT) != 0) {
                changeSpeedX(1);
            }
        }
        if ((movement & HeroAction.MOVE_UP) == 0 && (movement & HeroAction.MOVE_DOWN) == 0) {
            setSpeedY(0);
        } else {
            if ((movement & HeroAction.MOVE_UP) != 0) {
                changeSpeedY(1);
            }
            if ((movement & HeroAction.MOVE_DOWN) != 0) {
                changeSpeedY(-1);
            }
        }
    }

    public void updateMovement(Map map){
        if (speedX != 0) {
            moveSingleAxis(speedX, 0, map.collideableObjects);
        }
        if (speedY != 0) {
            moveSingleAxis(0, speedY, map.collideableObjects);
        }
    }

    private void moveSingleAxis(double dx, double dy, ArrayList<GameObject> colliders) {
        setX(getX() + dx);// * Config.DeltaTime;
        setY(getY() - dy);// * Config.DeltaTime;

        for (GameObject collider : colliders) {
            if(collider != this && checkOverlap(collider)) {
                if (dx > 0) {
                    setX(collider.getX() - this.getDimension().width);
                    setSpeedX(0);
                } else if (dx < 0) {
                    setX(collider.getX() + collider.getDimension().width);
                    setSpeedX(0);
                } else if (dy > 0) {
                    this.setY(collider.getY() + collider.getDimension().height);
                    this.setSpeedY(0);
                } else if (dy < 0) {
                    this.setY(collider.getY() - this.getDimension().height);
                    this.setSpeedY(0);
                }
            }
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

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public boolean isHit() {
        return isHit;
    }

    public void setHit(boolean hit) {
        isHit = hit;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Weapon getWeapon() {
        return weapon;
    }
}
