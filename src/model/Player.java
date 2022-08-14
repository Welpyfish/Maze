package model;

import java.util.ArrayList;

public class Player extends Sprite
{
    private boolean[] actions;
    private double speedX;
    private double speedY;
    private boolean isDead;
    public Player(int x, int y)
    {
        super(x, y);
        actions = new boolean[] {false, false, false, false};
    }

    public void update(Map map){
        movementX();
        movementY(map.getPlatforms());
        updateMovement(map);
    }

    public boolean[] getActions() {
        return actions;
    }

    public void setAction(int action, boolean type) {
        this.actions[action] = type;
    }

    public void movementX()
    {
        if(!actions[0] && !actions[1])
        {
            speedX = 0;
        }
        if (actions[0])
        {
            speedX = -5;
        }
        if (actions[1])
        {
            speedX = 5;
        }
    }

    public void movementY(ArrayList<Platform> platforms)
    {
        if (actions[2])
        {
            this.setY(getY()-1);
            for (Platform platform : platforms)
            {
                if(checkOverlap(platform))
                {
                    speedY = 12.5;
                }
            }
            this.setY(getY()+1);
            actions[2] = false;
        }
        speedY -= 0.2;
    }

    public void updateMovement(Map map){
        if (speedX != 0) {
            moveSingleAxis(speedX, 0, map.getPlatforms());
        }
        if (speedY != 0) {
            moveSingleAxis(0, speedY, map.getPlatforms());
        }
    }

    private void moveSingleAxis(double dx, double dy, ArrayList<Platform> colliders) {
        setX(getX() + dx);// * Config.DeltaTime;
        setY(getY() - dy);// * Config.DeltaTime;

        for (Sprite collider : colliders) {
            if (checkOverlap(collider)) {
                if (dx > 0) {
                    setX(collider.getX() - this.getWidth());
                    setSpeedX(0);
                } else if (dx < 0) {
                    setX(collider.getX() + collider.getWidth());
                    setSpeedX(0);
                } else if (dy > 0) {
                    this.setY(collider.getY() + collider.getHeight());
                    setSpeedY(0);
                } else if (dy < 0) {
                    this.setY(collider.getY() - this.getHeight());
                    setSpeedY(0);
                }
            }
        }
    }

    private void setSpeedX(double speedX) {
        this.speedX = speedX;
    }

    private void setSpeedY(double speedY) {
        this.speedY = speedY;
    }
}
