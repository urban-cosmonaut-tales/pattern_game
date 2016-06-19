package PatternState;

import javafx.scene.paint.Color;

/**
 * Created by Евгения on 20.06.2016.
 */
public class TrulyDeadState extends State {
    @Override
    public Color setColor() {
        return Color.DARKBLUE;
    }
}
