package controller;

import model.Map;

public class MapManager {
    private Map map;
    private GameEngine gameEngine;
    private boolean actions[];

    public MapManager(GameEngine gameEngine, Map map)
    {
        this.gameEngine = gameEngine;
        this.map = map;
    }

    public void updateMap(){
        map.getPlayer().update(map);
    }

    public Map getMap() {
        return map;
    }
}
