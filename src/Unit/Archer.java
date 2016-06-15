package Unit;


import java.util.ArrayList;

import static java.lang.Math.abs;

/**
 * Created by Дарья on 21.05.2016.
 */
public class Archer extends Unit{

    public Archer(){

    }


    @Override
    public void doAction(ArrayList<Unit> enemies) {
        int count = enemies.size();
        int str = strength;
        for(int i = 0; i < enemies.size(); i++){
            int damage = str / count--;
            int health = enemies.get(i).getHealth() - damage;
            enemies.get(i).setHealth(health);
            str = str - abs(damage);
        }
    }
}
