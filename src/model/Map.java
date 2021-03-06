package model;

import manager.ButtonAction;
import model.*;
import model.StaticObject.*;
import model.hero.Hero;
import model.item.Melee;
//import model.item.Sword;
import model.item.Weapon;

import java.util.ArrayList;
import java.lang.String;


public class Map {
    private ArrayList<GameObject> allGameObjects = new ArrayList<GameObject>();

    private String[] levelMap = {
            "XXXXXXXXXXXXXXXXXXXXXXXXX",
            "X    PX      E          X",
            "X     X                 X",
            "X     XXXXXXXXXXXXXXX   X",
            "X     X                 X",
            "X  XXXX     X           X",
            "X           X           X",
            "X      E    XXXXXXXXXXXXX",
            "X                       X",
            "XXXXXXXXXX              X",
            "X           XXXXXXXX    X",
            "X           X           X",
            "X           X           X",
            "X           X           X",
            "XXXXXXXXXXXXXXXXXXXXXXXXX",
    };

    private int tileSize = 48;

    public ArrayList<Wall> walls = new ArrayList<Wall>();
    public ArrayList<GameObject> collideableObjects = new ArrayList<GameObject>();
    public ArrayList<Enemy> enemies = new ArrayList<Enemy>();
    public Hero hero;

    public Map(){
        generateLevel(levelMap);
    }

    public void generateLevel(String[] levelMap){
        for(int i=0; i<levelMap.length; i++){
            for(int j=0; j<levelMap[i].length(); j++){
                int x = j*tileSize;
                int y = i*tileSize;
                switch (levelMap[i].charAt(j)) {
                    case 'X':
                        Wall newWall = new Wall(x, y);
                        walls.add(newWall);
                        collideableObjects.add(newWall);
                        break;
                    case 'P':
                        hero = new Hero(x, y, new Melee());
                        collideableObjects.add(hero);
                        break;
                    case 'E':
                        Enemy newEnemy = new Enemy(x, y, new Melee());
                        enemies.add(newEnemy);
                        collideableObjects.add(newEnemy);
                        break;
                    default:
                }
            }
        }
    }
}
