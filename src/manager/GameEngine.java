package manager;

//import model.hero.Mario;
//import view.ImageLoader;
import view.UIManager;
import model.*;

import javax.swing.*;
import java.awt.*;

public class GameEngine implements Runnable {
    private final static int WIDTH = 1200, HEIGHT = 720;
    public MapManager mapManager;
    //private GameStatus gameStatus;
    private boolean isRunning;
    private Thread thread;
    private UIManager uiManager;
    //private ImageLoader imageLoader;

    public GameEngine() {
        init();
    }

    private void init() {
//        imageLoader = new ImageLoader();
        InputManager inputManager = new InputManager(this);
//        gameStatus = GameStatus.START_SCREEN;
        mapManager = new MapManager(new Map());
        uiManager = new UIManager(this, WIDTH, HEIGHT);

        JFrame frame = new JFrame("Maze");
        frame.add(uiManager);
        frame.addKeyListener(inputManager);
        frame.addMouseListener(inputManager);
        frame.pack();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        start();
    }

    private synchronized void start() {
        if (isRunning)
            return;
//else
        isRunning = true;
        thread = new Thread(this);
        thread.start();
    }

    //public GameStatus getGameStatus() {
//        return gameStatus;
//    }

    @Override
    public void run() {
        long lastTime = System.nanoTime();
        double fps = 60.0;
        double ns = 1000000000 / fps;
        double delta = 0;
        //long timer = System.currentTimeMillis();

        while (isRunning && !thread.isInterrupted()) {

            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                //if (gameStatus == GameStatus.RUNNING) {
                    gameLoop();
                //}
                delta--;
            }
            render();

//            if(gameStatus != GameStatus.RUNNING) {
//                timer = System.currentTimeMillis();
//            }
//
//            if (System.currentTimeMillis() - timer > 1000) {
//                timer += 1000;
//                mapManager.updateTime();
//            }
        }
    }

    private void render() {
        uiManager.repaint();
    }

    private void gameLoop() {
        mapManager.updateMap();
        //updateLocations();
        //checkCollisions();
        //updateCamera();

        //setGameStatus(GameStatus.GAME_OVER);
    }

    public void receiveInput(int keycode, boolean type){
        mapManager.manageInput(keycode, type);
    }

//    public void setGameStatus(GameStatus gameStatus)
//    {
//        this.gameStatus = gameStatus;
//    }
//
//    public ImageLoader getImageLoader()
//    {
//        return imageLoader;
//    }
//
//
//    private void updateLocations() {
//        mapManager.updateLocations();
//    }
//
//    private void checkCollisions() {
//        mapManager.checkCollisions(this);
//    }

    public void drawMap(Graphics2D g2) {
        //mapManager.drawMap(g2);
    }
}
