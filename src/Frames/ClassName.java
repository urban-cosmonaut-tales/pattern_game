package Frames;

import javafx.geometry.Pos;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

/**
 * Created by Дарья on 06.06.2016.
 */
public class ClassName extends StackPane {
    private Text text;

    public ClassName(String message) {
        text = new Text(message);
        text.setFont(this.text.getFont().font(20));
        text.setFill(Color.BLACK);

        Rectangle bg = new Rectangle(150,30);
        bg.setOpacity(0.6);
        bg.setFill(Color.WHITE);
        bg.setEffect(new GaussianBlur(3.5));

        setAlignment(Pos.CENTER_LEFT);
        setRotate(-0.5);
        getChildren().addAll(bg,text);
    }
}
