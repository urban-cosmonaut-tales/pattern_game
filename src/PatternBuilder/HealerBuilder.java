package PatternBuilder;

import Unit.Unit;

/**
 * Created by Дарья on 21.05.2016.
 */
public class HealerBuilder extends UnitBuilder {
    private int index;
    private int health = 40;
    private int power = 10;
    public HealerBuilder(Unit _unit, int _index){
        super(_unit);
        this.index = _index;
        unit.setIndex(_index);
    }
    @Override
    public void buildStrength() {
        unit.setStrength(power + (index*3));
    }

    @Override
    public void buildHealth() {
        unit.setHealth(health - (index * 3));
    }

    @Override
    public void buildMaxHealth() {
        unit.setMaxHealth(health - (index * 3));
    }
}
