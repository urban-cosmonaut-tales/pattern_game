package Frames;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

/**
 * Created by Дарья on 22.05.2016.
 */
public class GameMenu extends Parent {
    public GameMenu() {
        VBox menu0 = new VBox(10);
        VBox menu1 = new VBox(10);
        VBox menu2 = new VBox(10);

        menu0.setTranslateX(100);
        menu0.setTranslateY(200);

        menu1.setTranslateX(100);
        menu1.setTranslateY(200);

        menu2.setTranslateX(100);
        menu2.setTranslateY(200);

        final int offset = 400;

        menu1.setTranslateX(offset);
        menu2.setTranslateX(offset);

        MenuButton btnStart = new MenuButton("START");
        btnStart.setOnMouseClicked( event -> {
            FadeTransition ft = new FadeTransition(Duration.seconds(0.5), this);
            ft.setFromValue(1);
            ft.setToValue(0);
            ft.setOnFinished(evt -> this.setVisible(false));
            ft.play();
        });

        MenuButton btnOptions = new MenuButton("OPTIONS");
        btnOptions.setOnMouseClicked( event -> {
            getChildren().add(menu1);

            TranslateTransition tt = new TranslateTransition(Duration.seconds(0.25), menu0);
            tt.setToX(menu0.getTranslateX() - offset);

            TranslateTransition tt1 = new TranslateTransition(Duration.seconds(0.5), menu1);
            tt1.setToX(menu0.getTranslateX());

            tt.play();
            tt1.play();

            tt.setOnFinished(evt -> {
                getChildren().remove(menu0);
            });
        });

        MenuButton btnInformation = new MenuButton("INFORMATION");
        btnInformation.setOnMouseClicked( event -> {
            getChildren().add(menu2);

            TranslateTransition tt = new TranslateTransition(Duration.seconds(0.25), menu0);
            tt.setToX(menu0.getTranslateX() - offset);

            TranslateTransition tt1 = new TranslateTransition(Duration.seconds(0.5), menu2);
            tt1.setToX(menu0.getTranslateX());

            tt.play();
            tt1.play();

            tt.setOnFinished(evt -> {
                getChildren().remove(menu0);
            });
        });

        MenuButton btnExit = new MenuButton("EXIT");
        btnExit.setOnMouseClicked(event -> {
            System.exit(0);
        });

        MenuButton btnBack = new MenuButton("BACK");
        btnBack.setOnMouseClicked( event -> {
            getChildren().add(menu0);

            TranslateTransition tt = new TranslateTransition(Duration.seconds(0.25), menu1);
            tt.setToX(menu1.getTranslateX() + offset);

            TranslateTransition tt1 = new TranslateTransition(Duration.seconds(0.5), menu0);
            tt1.setToX(menu1.getTranslateX());

            tt.play();
            tt1.play();

            tt.setOnFinished(evt -> {
                getChildren().remove(menu1);
            });
        });

        MenuButton btnLevel1 = new MenuButton("LEVEL 1");
        MenuButton btnLevel2 = new MenuButton("LEVEL 2");

        MenuButton btnBackInf = new MenuButton("BACK");
        btnBackInf.setOnMouseClicked( event -> {
            getChildren().add(menu0);

            TranslateTransition tt = new TranslateTransition(Duration.seconds(0.25), menu2);
            tt.setToX(menu2.getTranslateX() + offset);

            TranslateTransition tt1 = new TranslateTransition(Duration.seconds(0.5), menu0);
            tt1.setToX(menu2.getTranslateX());

            tt.play();
            tt1.play();

            tt.setOnFinished(evt -> {
                getChildren().remove(menu2);
            });
        });

        MenuButton btnAboutGame = new MenuButton("ABOUT GAME");

        menu0.getChildren().addAll(btnStart, btnOptions, btnInformation, btnExit);
        menu1.getChildren().addAll(btnBack, btnLevel1, btnLevel2);
        menu2.getChildren().addAll(btnBackInf, btnAboutGame);

        Rectangle bg = new Rectangle(960, 560);
        bg.setFill(Color.GREY);
        bg.setOpacity(0.4);

        getChildren().addAll(bg, menu0);
    }
}
