package model.item;

import model.Entity;
import model.GameObject;
import model.Map;

public class Weapon extends GameObject {
    private int damage;
    private double range;
    private int attackState;

    public Weapon(){
        super(0, 0);
        damage = 2;
        range = 10;
    }

    public void update(Entity entity, Map map){

    }

    public void attack(Entity entity, Map map) {
        //attack
    }


    public int getAttackState() {
        return attackState;
    }

    public void setAttackState(int attackState) {
        this.attackState = attackState;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}
