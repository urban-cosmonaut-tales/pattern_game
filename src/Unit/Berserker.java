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
        for(int i = 0; i < unit.size(); i++){
            int damage = unit.get(i).getHealth() - strength;
            unit.get(i).setHealth(damage);
        }
    }
}
