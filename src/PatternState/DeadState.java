package PatternState;

import Unit.Unit;

import java.awt.*;

/**
 * Created by Дарья on 21.05.2016.
 */
public class DeadState extends State {
    @Override
    public void setColor(Unit unit) {
        unit.setColor(Color.red);
    }
}
