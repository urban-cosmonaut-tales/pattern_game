package PatternFactory;

import Unit.*;

/**
 * Created by Евгения on 05.06.2016.
 */
public class HealerFactory extends Factory{
    @Override
    public Unit createUnit() {
        return new Healer();
    }
}
