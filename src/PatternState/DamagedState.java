package PatternState;

import Unit.*;

import java.awt.*;

/**
 * Created by Дарья on 21.05.2016.
 */
public class DamagedState extends State {
    @Override
    public Color setColor() {
        return Color.yellow;
    }
}
