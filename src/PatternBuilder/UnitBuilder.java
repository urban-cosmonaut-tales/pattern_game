package PatternBuilder;

import Unit.*;

/**
 * Created by Дарья on 21.05.2016.
 */
public abstract class UnitBuilder {
    protected Unit unit;
    public Unit getUnit(){
        return unit;
    }
    public void setUnit(Unit _unit){
        this.unit = _unit;
    }
    public abstract void buildHealth();
    public abstract void buildStrength();
    public abstract void buildMaxHealth();
}
