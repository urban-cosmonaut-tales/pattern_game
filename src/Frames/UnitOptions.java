package Frames;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;


/**
 * Created by Дарья on 11.06.2016.
 */
public class UnitOptions extends StackPane {
    public Label textHp;
    public Rectangle st;

    public UnitOptions(int health, int power, Color state, boolean heal) {
        VBox allOp = new VBox(14);

        textHp = new Label("Health: " + Integer.toString(health));
        textHp.setFont(textHp.getFont().font(15));
        textHp.setTextFill(Color.WHITE);
        //textHp.setFill(Color.WHITE);

        Text textP;
        if (heal == true) {
            textP = new Text("Healing: " + Integer.toString(power));
        }
        else {
            textP = new Text("Damage: " + Integer.toString(power));
        }

        textP.setFont(textP.getFont().font(15));
        textP.setFill(Color.WHITE);

        st = new Rectangle(90,20);
        st.setOpacity(0.6);
        st.setFill(state);

        allOp.getChildren().addAll(textHp, textP, st);
        getChildren().addAll(allOp);
    }
}
