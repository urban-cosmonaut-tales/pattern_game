package Frames;

import javafx.geometry.Pos;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import javax.swing.*;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by Дарья on 22.05.2016.
 */
public class ImgButton extends StackPane {

    public ImgButton(String ii) throws IOException {
        InputStream is = Files.newInputStream(Paths.get(ii));
        Image img = new Image(is);
        is.close();
        ImageView imgView = new ImageView(img);
        imgView.setFitWidth(128);
        imgView.setFitHeight(72);

        Rectangle bg = new Rectangle(130,75);
        bg.setOpacity(0.6);
        bg.setFill(Color.BLACK);
        bg.setEffect(new GaussianBlur(3.5));

        setAlignment(Pos.CENTER_LEFT);
        setRotate(-0.5);
        getChildren().addAll(bg,imgView);

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

        DropShadow drop = new DropShadow(50, Color.WHITE);
        drop.setInput(new Glow());

        setOnMousePressed(event -> setEffect(drop));
        setOnMouseReleased(event -> setEffect(null));
    }
}
