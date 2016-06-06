package Unit;

import PatternState.State;

import java.awt.*;

import static java.lang.Math.abs;

/**
 * Created by Дарья on 21.05.2016.
 */
public class Healer extends Unit{
    public Healer(){
        maxHealth = 30;
    }
    @Override
    public void doAction(Unit[] enemy) {
        int count = enemy.length;
        int str = strength;
        for(int i = 0; i < enemy.length; i++){
            int damage = str/count--;
            int health = enemy[i].getHealth() + damage;
            enemy[i].setHealth(health);
            str = str - damage;
        }
    }
}
