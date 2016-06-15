package PatternState;

import javafx.scene.paint.Color;


/**
 * Created by Дарья on 21.05.2016.
 */
public class DeadState extends State {
    @Override
    public Color setColor() {
        return Color.RED;
    }
}
