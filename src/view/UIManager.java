package view;

import controller.GameEngine;
import model.Map;
import model.Platform;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class UIManager extends JPanel
{
    private GameEngine gameEngine;
    private Map map;
    private ImageLoader imageLoader;

    private BufferedImage playerImage;
    private BufferedImage platformImage;

    public UIManager(GameEngine gameEngine)
    {
        this.gameEngine = gameEngine;
        this.map = gameEngine.getMapManager().getMap();
        imageLoader = gameEngine.getImageLoader();
        setPreferredSize(new Dimension(1000, 720));

        playerImage = imageLoader.loadImage("media/player_block.png");
        platformImage = imageLoader.loadImage("media/platform_block.png");
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g.create();
        drawGameObjects(g2);
        g2.dispose();
    }

    private void drawGameObjects(Graphics2D g2)
    {
        for(Platform platform : map.getPlatforms()){
            g2.drawImage(platformImage, (int)platform.getX(), (int)platform.getY(), null);
        }
        g2.drawImage(playerImage, (int)map.getPlayer().getX(), (int)map.getPlayer().getY(), null);
    }

}
