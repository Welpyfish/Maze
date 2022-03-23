package view;

import manager.GameEngine;
//import manager.GameStatus;
import manager.MapManager;
import model.*;
import model.StaticObject.*;
import model.hero.*;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class UIManager extends JPanel{
    private GameEngine engine;
    private Font gameFont;
    private BufferedImage image;
    private MapManager mapManager;

    public UIManager(GameEngine engine, int width, int height) {
        setPreferredSize(new Dimension(width, height));
        setMaximumSize(new Dimension(width, height));
        setMinimumSize(new Dimension(width, height));
        this.engine = engine;
        this.mapManager = engine.mapManager;
//        ImageLoader loader = engine.getImageLoader();
//        BufferedImage sprite = loader.loadImage("/sprite.png");
//        this.brick = sprite.getSubimage(0, 0, 48, 48);
//        this.goomba = sprite.getSubimage(48, 144, 48, 48);

//        try {
//            InputStream in = getClass().getResourceAsStream("/media/font/mario-font.ttf");
//            gameFont = Font.createFont(Font.TRUETYPE_FONT, in);
//        } catch (FontFormatException | IOException e) {
            gameFont = new Font("Verdana", Font.BOLD, 12);
//            e.printStackTrace();
//        }
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g.create();
        //GameStatus gameStatus = engine.getGameStatus();
        drawGameObjects(g2);
//        engine.drawMap(g2);
        g2.dispose();
    }

    private void drawGameObjects(Graphics2D g2) {
        g2.setFont(gameFont);
        g2.setColor(Color.BLUE);
        for(Wall wall : mapManager.map.walls){
            g2.drawImage(wall.getImage(), (int)wall.getX(), (int)wall.getY(), null);
        }
        for(Enemy enemy : mapManager.map.enemies){
            g2.drawImage(enemy.getImage(), (int)enemy.getX(), (int)enemy.getY(), null);
            g2.drawString(Integer.toString(enemy.getHp()), (int)enemy.getX(), (int)enemy.getY() - 5);
        }
        g2.drawImage(mapManager.map.hero.getImage(), (int)mapManager.map.hero.getX(), (int)mapManager.map.hero.getY(), null);
        g2.drawImage(mapManager.map.hero.getWeapon().getImage(), (int)mapManager.map.hero.getWeapon().getX(), (int)mapManager.map.hero.getWeapon().getY(), null);
        g2.drawString(Integer.toString(mapManager.map.hero.getHp()), (int)mapManager.map.hero.getX(), (int)mapManager.map.hero.getY() - 5);
    }
}
