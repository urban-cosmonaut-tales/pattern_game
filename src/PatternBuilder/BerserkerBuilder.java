package PatternBuilder;

/**
 * Created by Евгения on 05.06.2016.
 */
public class BerserkerBuilder extends UnitBuilder{
    private int index;
    private final double health = 40;
    private final double strength = -10;
    public BerserkerBuilder(int _index){
        this.index = _index;
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
        unit.setStrength(strength + (index));
    }
}
