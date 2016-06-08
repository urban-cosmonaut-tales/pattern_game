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
// класс отвечающий за создание кнопок в меню выбора персонажей
public class ImgButton extends StackPane {
    private boolean status; // переменная отвечает за то, выбран этот персонаж в меню или нет
    public ImgButton(String ii) throws IOException {
        status = false;
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
            bg.setTranslateY(10);
            imgView.setTranslateY(10);
            bg.setFill(Color.WHITE);
        });
        setOnMouseExited(event -> {
            bg.setTranslateY(0);
            imgView.setTranslateY(0);
            bg.setFill(Color.BLACK);
        });

        DropShadow drop = new DropShadow(50, Color.RED);
        drop.setInput(new Glow());


        setOnMousePressed(event -> {
            if (getEffect() == null) {setEffect(drop); status = true;
                /* если кнопку нажали и на ней не был установлен эффект, значит надо
                его установить и задать значение статуса как кнопку которую выбрали */
            }
            else {setEffect(null); status = false;
            /* в ином случае убираем эффект и значение статуса соответствует невыбранной кнопке */
            }});
        //setOnMouseReleased(event -> setEffect(null));
    }
    public boolean getStatus()
    {
        return this.status;
    }
    public void setStatus(boolean sts)
    {
        this.status = sts;
    }
}
