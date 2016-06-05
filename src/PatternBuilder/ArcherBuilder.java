package PatternBuilder;

/**
 * Created by Дарья on 21.05.2016.
 */
public class ArcherBuilder extends UnitBuilder {
    private int index;
    private final double health = 40;
    private final double strength = -10;
    public ArcherBuilder(int _index){
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
