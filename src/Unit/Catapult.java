package Unit;

import PatternState.State;

import java.awt.*;

/**
 * Created by Дарья on 21.05.2016.
 */
public class Catapult extends Unit{

    public Catapult(){
        maxHealth = 40;
    }
    @Override
    public void doAction(Unit[] unit) {
        int damage = unit[0].getHealth() - strength;
        unit[0].setHealth(damage);
    }
}
