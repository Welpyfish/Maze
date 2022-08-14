package model;


public class Entity extends Sprite {

    private double speedX;
    private double speedY;
    private boolean isDead;
    public Entity(int x, int y)
    {
        super(x, y);

        isDead = false;
    }


//    public void changeHp(int damage){
//        if(this.hp + damage > 0){
//            this.hp += damage;
//        }
//    }
}
