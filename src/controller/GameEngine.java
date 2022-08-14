package controller;

import view.GameFrame;
import view.ImageLoader;
import view.UIManager;

public class GameEngine implements Runnable
{
    private Thread thread;

    private GameFrame gameFrame;
    private UIManager uiManager;
    private ImageLoader imageLoader;
    private MapManager mapManager;
    private MapCreator mapCreator;

    String mapLevel1[] = {
            "                    ",
            "                    ",
            "                    ",
            "        P           ",
            "                    ",
            "                    ",
            "                    ",
            "                    ",
            "                    ",
            "                    ",
            "                    ",
            "                    ",
            "                    ",
            "                    ",
            "GGGGGGGGGGGGGGGGGGGG",
    };

    public GameEngine()
    {
        init();
    }

    private void init()
    {
        imageLoader = new ImageLoader();

        mapCreator = new MapCreator();
        mapManager = new MapManager(this, mapCreator.createMap(mapLevel1));

        uiManager = new UIManager(this);
        gameFrame = new GameFrame(uiManager);

        thread = new Thread(this);
        thread.start();
    }
    @Override
    public void run() {
        long lastTime = System.nanoTime();
        double fps = 60.0;
        double nsFrame = 1000000000 / fps;
        double delta = 0;
        //long timer = System.currentTimeMillis();

        while (!thread.isInterrupted()) {

            long now = System.nanoTime();
            delta += (now - lastTime) / nsFrame;
            lastTime = now;
            while (delta >= 1) {
                //if (gameStatus == GameStatus.RUNNING) {
                gameLoop();
                //}
                delta--;
            }
            uiManager.repaint();
        }
    }

    public void gameLoop(){
        mapManager.updateMap();
    }

    public MapManager getMapManager() {
        return mapManager;
    }

    public ImageLoader getImageLoader() {
        return imageLoader;
    }
}
