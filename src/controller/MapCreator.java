package controller;

import model.Map;
import view.ImageLoader;

import java.awt.*;
import java.awt.image.BufferedImage;

public class MapCreator
{
    ImageLoader imageLoader;

    public MapCreator()
    {
        //
    }

    public Map createMap(String mapPath)
    {
        BufferedImage mapImage = imageLoader.loadImage(mapPath);
        Map map = new Map();

        for (int x = 0; x < mapImage.getWidth(); x++) {
            for (int y = 0; y < mapImage.getHeight(); y++) {
                int currentPixel = mapImage.getRGB(x, y);
                int xLocation = x * 48;
                int yLocation = y * 48;

                if(currentPixel == new Color(160, 160, 160).getRGB())
                {
                    map.addPlayer(xLocation, yLocation);
                }
            }
        }
        return map;
    }

    public Map createMap(String[] mapString)
    {
        Map map = new Map();

        for (int y = 0; y < mapString.length; y++) {
            for (int x = 0; x < mapString[0].length(); x++) {
                char currentTile = mapString[y].charAt(x);
                int xLocation = x * 48;
                int yLocation = y * 48;

                if(currentTile == 'P')
                {
                    map.addPlayer(xLocation, yLocation);
                }
                else if(currentTile == 'G')
                {
                    map.addPlatform(xLocation, yLocation);
                }
            }
        }
        return map;
    }
}

