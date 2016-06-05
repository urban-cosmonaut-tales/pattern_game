package PatternFactory;

import Unit.Archer;
import Unit.Unit;

/**
 * Created by Дарья on 21.05.2016.
 */
public class ArcherFactory extends Factory {
    @Override
    public Unit createUnit() {
        return new Archer();
    }
}
