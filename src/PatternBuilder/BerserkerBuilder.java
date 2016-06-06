package PatternBuilder;

import Unit.Unit;

/**
 * Created by Евгения on 05.06.2016.
 */
public class BerserkerBuilder extends UnitBuilder{
    private int index;
    private final int health = 30;
    private final int strength = 10;
    public BerserkerBuilder( Unit _unit, int _index){
        super(_unit);
        unit.setIndex(_index);
        index = _index;
    }
    @Override
    public void buildHealth() {
        unit.setHealth(health-(index*4));
    }

    @Override
    public void buildMaxHealth() {
        unit.setMaxHealth(health-(index*3));
    }

    @Override
    public void buildStrength() {
        unit.setStrength(strength + (index*3));
    }
}
