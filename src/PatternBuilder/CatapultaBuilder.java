package PatternBuilder;

import Unit.Unit;

/**
 * Created by Евгения on 05.06.2016.
 */
public class CatapultaBuilder extends UnitBuilder{
    private int index;
    private final int health = 40;
    private final int strength = 10;
    public CatapultaBuilder(Unit _unit, int _index){
        super(_unit);
        this.index = _index;
        unit.setIndex(_index);
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
