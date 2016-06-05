package PatternFactory;

import Unit.*;

/**
 * Created by Дарья on 21.05.2016.
 */
public class CatapultFactory extends Factory {
    @Override
    public Unit createUnit() {
        return new Catapult();
    }
}
