package PatternBuilder;

import Unit.*;

/**
 * Created by Дарья on 21.05.2016.
 */
public class ArcherBuilder extends UnitBuilder {
    private int index;
    private final int health = 40;
    private final int strength = 10;
    public ArcherBuilder(Unit _unit, int _index){
        super(_unit);
        unit.setIndex(_index);
        index = _index;
    }
    @Override
    public void buildHealth() {
        unit.setHealth(health-(index*3));
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
