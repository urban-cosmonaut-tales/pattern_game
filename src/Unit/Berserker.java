package Unit;

import PatternState.State;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Дарья on 21.05.2016.
 */
public class Berserker extends Unit{
    public Berserker(){
    }

    @Override
    public void doAction(ArrayList<Unit> unit) {
        int damage = unit.get(0).getHealth() - strength;
        unit.get(0).setHealth(damage);
    }
}
