package PatternBuilder;

/**
 * Created by Дарья on 21.05.2016.
 */
public class HealerBuilder extends UnitBuilder {
    private int index;
    private double health = 40;
    private double power = 10;
    public HealerBuilder(int _index){
        this.index = _index;
    }
    @Override
    public void buildStrength() {
        unit.setStrength(power - index);
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
