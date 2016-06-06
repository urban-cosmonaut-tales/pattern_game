package Unit;

import PatternState.State;

import java.awt.*;

/**
 * Created by Дарья on 21.05.2016.
 */
public class Berserker extends Unit{
    public Berserker(){
        maxHealth = 50;
    }

    @Override
    public void doAction(Unit[] unit) {
        for(int i = 0; i < unit.length; i++){
            int damage = unit[i].getHealth() - strength;
            unit[i].setHealth(damage);
        }
    }
}
