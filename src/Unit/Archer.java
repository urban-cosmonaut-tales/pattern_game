package Unit;

import PatternState.DamagedState;
import PatternState.DeadState;
import PatternState.HealthyState;
import PatternState.State;
import java.awt.Color;

import static java.lang.Math.abs;

/**
 * Created by Дарья on 21.05.2016.
 */
public class Archer extends Unit{

    public Archer(){
        maxHealth = 40;
    }


    @Override
    public void doAction(Unit[] enemies) {
        int count = enemies.length;
        int str = strength;
        for(int i = 0; i < enemies.length; i++){
            int damage = str/count--;
            int health = enemies[i].getHealth() - damage;
            enemies[i].setHealth(health);
            str = str - abs(damage);
        }
    }
}
