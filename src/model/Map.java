package model;

import manager.ButtonAction;
import model.*;
import model.StaticObject.*;
import model.hero.Hero;

import java.util.ArrayList;
import java.lang.String;


public class Map {
    private ArrayList<GameObject> allGameObjects = new ArrayList<GameObject>();

    private String[] levelMap = {
            "                           ",
            "   P         XXX           ",
            "                           ",
            " XXXXX                     ",
            "            XXXXXXXX       ",
            "         X  X              ",
            "       XXX  X              ",
            "    XXXXXX  X       XXX    ",
            "XXXXXXXXXX  XXXXXXXXXXX    ",
    };

    private int tileSize = 48;

    public ArrayList<Wall> walls = new ArrayList<Wall>();
    public Hero hero;

    public Map(){
        generateLevel(levelMap);
    }

    public void generateLevel(String[] levelMap){
        for(int i=0; i<levelMap.length; i++){
            for(int j=0; j<levelMap[i].length(); j++){
                int x = j*tileSize;
                int y = i*tileSize;
                if(levelMap[i].charAt(j) == 'X') {
                    Wall newWall = new Wall(x, y);
                    walls.add(newWall);
                } else if(levelMap[i].charAt(j) == 'P'){
                    hero = new Hero(x, y);
                }
            }
        }
    }
}
