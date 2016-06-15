package Frames;

import javafx.geometry.Pos;
import javafx.scene.effect.Bloom;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by Дарья on 23.05.2016.
 */
// в этом классе описываются кнопки в меню сражения
public class FightButton extends StackPane {
    public boolean state;
    public FightButton(String ii) throws IOException {
        state = false;
        InputStream is = Files.newInputStream(Paths.get(ii));
        Image img = new Image(is);
        is.close();
        ImageView imgView = new ImageView(img);
        imgView.setFitWidth(160);
        imgView.setFitHeight(90);

        Rectangle bg = new Rectangle(160, 90);
        bg.setOpacity(0.6);
        bg.setFill(Color.BLACK);
        bg.setEffect(new GaussianBlur(3.5));

        setAlignment(Pos.CENTER_LEFT);
        setRotate(-0.5);
        getChildren().addAll(bg, imgView);

        DropShadow drop0 = new DropShadow(50, Color.WHITE);
        drop0.setInput(new Bloom());

        setOnMouseEntered(event -> {
            bg.setTranslateX(10);
            imgView.setTranslateX(10);
            bg.setFill(Color.WHITE);
        });

        setOnMouseExited(event -> {
            bg.setTranslateX(0);
            imgView.setTranslateX(0);
            bg.setFill(Color.BLACK);
        });

        DropShadow drop = new DropShadow(80, Color.WHITE);
        drop.setInput(new Glow());

        setOnMousePressed( event -> {
            if (getEffect() == null) {setEffect(drop); state=true;}
            else {setEffect(null);state=true;}
            });
        //setOnMouseReleased(event -> setEffect(null));
    }
    public boolean getState() {
        return state;
    }
    public void setState(boolean state) {
        this.state = state;
    }
}
