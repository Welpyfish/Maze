package model;

import view.ImageLoader;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Map
{
    private Player player;
    private ArrayList<Platform> platforms = new ArrayList<Platform>();

    public Map()
    {
    }

    public void addPlayer(int x, int y)
    {
        this.player = new Player(x, y);
    }

    public void addPlatform(int x, int y)
    {
        platforms.add(new Platform(x, y));
    }

    public Player getPlayer() {
        return player;
    }

    public ArrayList<Platform> getPlatforms() {
        return platforms;
    }
}
