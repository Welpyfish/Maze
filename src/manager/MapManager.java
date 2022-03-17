package manager;
import model.GameObject;
import model.Map;
import model.StaticObject.Wall;

public class MapManager {
    public Map map;

    public MapManager(Map map){
        this.map = map;
    }
    public void updateObject(GameObject gameObject)
    {
        gameObject.updateX();
        for(Wall wall : map.walls) {
            gameObject.horizontalCollision(wall);
        }
        gameObject.updateY();
        for(Wall wall : map.walls) {
            gameObject.verticalCollision(wall);
        }
    }

    public void manageInput(ButtonAction action){
        switch(action){
            case MOVE_LEFT:
                map.hero.setSpeedX(-5);
                break;
            case MOVE_RIGHT:
                map.hero.setSpeedX(5);
                break;
            case MOVE_UP:
                map.hero.setSpeedY(-5);
                break;
            case MOVE_DOWN:
                map.hero.setSpeedY(5);
                break;
            default:
                map.hero.setSpeedX(0);
                map.hero.setSpeedY(0);
        }
    }
}
