package Frames;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import javax.swing.*;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by Дарья on 22.05.2016.
 */
public class GameMenu extends Parent {
    public GameMenu() throws IOException {
        VBox menu0 = new VBox(10);
        VBox menu1 = new VBox(10);
        VBox menu2 = new VBox(10);
        HBox menu3 = new HBox(10);
        VBox menu4 = new VBox(10);
        VBox menu5 = new VBox(10);
        VBox menuAllChange = new VBox(30);
        VBox menuMyArmy = new VBox(17);
        VBox menuComputerArmy = new VBox(17);
        HBox menuGame = new HBox(10);

        menu0.setTranslateX(100);
        menu0.setTranslateY(200);

        menu1.setTranslateX(100);
        menu1.setTranslateY(200);

        menu2.setTranslateX(100);
        menu2.setTranslateY(200);

        menuAllChange.setTranslateX(100);
        menuAllChange.setTranslateY(50);

        menuMyArmy.setTranslateX(50);
        menuMyArmy.setTranslateY(50);

        menuComputerArmy.setTranslateX(400);
        menuComputerArmy.setTranslateY(50);

        ImgButton unit0 = new ImgButton("C:\\Users\\Дарья\\IdeaProjects\\pattern_game\\pattern_game\\src\\Image\\unit\\Windranger.png");
        ImgButton unit1 = new ImgButton("C:\\Users\\Дарья\\IdeaProjects\\pattern_game\\pattern_game\\src\\Image\\unit\\Enchantress.png");
        ImgButton unit2 = new ImgButton("C:\\Users\\Дарья\\IdeaProjects\\pattern_game\\pattern_game\\src\\Image\\unit\\Omniknight.png");
        ImgButton unit3 = new ImgButton("C:\\Users\\Дарья\\IdeaProjects\\pattern_game\\pattern_game\\src\\Image\\unit\\Techies.png");
        ImgButton unit4 = new ImgButton("C:\\Users\\Дарья\\IdeaProjects\\pattern_game\\pattern_game\\src\\Image\\unit\\Timbersaw.png");

        FightButton fUnit0 = new FightButton("C:\\Users\\Дарья\\IdeaProjects\\pattern_game\\pattern_game\\src\\Image\\Tantsuyut-vse.jpg");
        FightButton fUnit1 = new FightButton("C:\\Users\\Дарья\\IdeaProjects\\pattern_game\\pattern_game\\src\\Image\\Tantsuyut-vse.jpg");
        FightButton fUnit2 = new FightButton("C:\\Users\\Дарья\\IdeaProjects\\pattern_game\\pattern_game\\src\\Image\\Tantsuyut-vse.jpg");
        FightButton fUnit3 = new FightButton("C:\\Users\\Дарья\\IdeaProjects\\pattern_game\\pattern_game\\src\\Image\\Tantsuyut-vse.jpg");
        FightButton fUnit4 = new FightButton("C:\\Users\\Дарья\\IdeaProjects\\pattern_game\\pattern_game\\src\\Image\\Tantsuyut-vse.jpg");
        FightButton fUnit5 = new FightButton("C:\\Users\\Дарья\\IdeaProjects\\pattern_game\\pattern_game\\src\\Image\\Tantsuyut-vse.jpg");
        FightButton fUnit6 = new FightButton("C:\\Users\\Дарья\\IdeaProjects\\pattern_game\\pattern_game\\src\\Image\\Tantsuyut-vse.jpg");
        FightButton fUnit7 = new FightButton("C:\\Users\\Дарья\\IdeaProjects\\pattern_game\\pattern_game\\src\\Image\\Tantsuyut-vse.jpg");
        FightButton fUnit8 = new FightButton("C:\\Users\\Дарья\\IdeaProjects\\pattern_game\\pattern_game\\src\\Image\\Tantsuyut-vse.jpg");
        FightButton fUnit9 = new FightButton("C:\\Users\\Дарья\\IdeaProjects\\pattern_game\\pattern_game\\src\\Image\\Tantsuyut-vse.jpg");
        FightButton fUnit10 = new FightButton("C:\\Users\\Дарья\\IdeaProjects\\pattern_game\\pattern_game\\src\\Image\\Tantsuyut-vse.jpg");
        FightButton fUnit11 = new FightButton("C:\\Users\\Дарья\\IdeaProjects\\pattern_game\\pattern_game\\src\\Image\\Tantsuyut-vse.jpg");
        FightButton fUnit12 = new FightButton("C:\\Users\\Дарья\\IdeaProjects\\pattern_game\\pattern_game\\src\\Image\\Tantsuyut-vse.jpg");
        FightButton fUnit13 = new FightButton("C:\\Users\\Дарья\\IdeaProjects\\pattern_game\\pattern_game\\src\\Image\\Tantsuyut-vse.jpg");
        FightButton fUnit14 = new FightButton("C:\\Users\\Дарья\\IdeaProjects\\pattern_game\\pattern_game\\src\\Image\\Tantsuyut-vse.jpg");

        final int offset = 400;

        menu1.setTranslateX(offset);
        menu2.setTranslateX(offset);
        menuAllChange.setTranslateX(offset);
        menuGame.setTranslateX(offset);

        MenuButton btnStart = new MenuButton("START");
        btnStart.setOnMouseClicked( event -> {
            getChildren().add(menuAllChange);

            TranslateTransition tt = new TranslateTransition(Duration.seconds(0.25), menu0);
            tt.setToX(menu0.getTranslateX() - offset);

            TranslateTransition tt1 = new TranslateTransition(Duration.seconds(0.5), menuAllChange);
            tt1.setToX(menu0.getTranslateX());

            tt.play();
            tt1.play();

            tt.setOnFinished(evt -> {
                getChildren().remove(menu0);
            });

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

        MenuButtonShort btnBackSelect = new MenuButtonShort("BACK");
        btnBackSelect.setOnMouseClicked( event -> {
            getChildren().add(menu0);

            TranslateTransition tt = new TranslateTransition(Duration.seconds(0.25), menuAllChange);
            tt.setToX(menuAllChange.getTranslateX() + offset);

            TranslateTransition tt1 = new TranslateTransition(Duration.seconds(0.5), menu0);
            tt1.setToX(menuAllChange.getTranslateX());

            tt.play();
            tt1.play();

            tt.setOnFinished(evt -> {
                getChildren().remove(menuAllChange);
            });
        });

        YouGold yg = new YouGold("30");

        MenuButton btnDelete = new MenuButton("DELETE UNIT");
        MenuButton btnStartGame = new MenuButton("START GAME");
        btnStartGame.setOnMouseClicked( event -> {
            getChildren().add(menuGame);

            TranslateTransition tt = new TranslateTransition(Duration.seconds(0.25), menuAllChange);
            tt.setToX(menuAllChange.getTranslateX() - offset);

            TranslateTransition tt1 = new TranslateTransition(Duration.seconds(0.5), menuGame);
            tt1.setToX(menuAllChange.getTranslateX());

            tt.play();
            tt1.play();

            tt.setOnFinished(evt -> {
                getChildren().remove(menuAllChange);
            });

        });

        MenuButtonShort btnFight = new MenuButtonShort("FIGHT");
        btnFight.setOnMouseClicked(event -> {

        });
        MenuButtonShort btnExitGame = new MenuButtonShort("END GAME");
        btnExitGame.setOnMouseClicked( event -> {
            getChildren().add(menu0);

            TranslateTransition tt = new TranslateTransition(Duration.seconds(0.25), menuGame);
            tt.setToX(menuGame.getTranslateX() + offset);

            TranslateTransition tt1 = new TranslateTransition(Duration.seconds(0.5), menu0);
            tt1.setToX(menuGame.getTranslateX());

            tt.play();
            tt1.play();

            tt.setOnFinished(evt -> {
                getChildren().remove(menuGame);
            });
        });

        menu0.getChildren().addAll(btnStart, btnOptions, btnInformation, btnExit);
        menu1.getChildren().addAll(btnBack, btnLevel1, btnLevel2);
        menu2.getChildren().addAll(btnBackInf, btnAboutGame);

        menu3.getChildren().addAll(unit0, unit1, unit2, unit3, unit4);
        menu4.getChildren().addAll(btnBackSelect);
        menu5.getChildren().addAll(btnDelete, btnStartGame);
        menuAllChange.getChildren().addAll(menu3, yg, menu4, menu5);

        menuMyArmy.getChildren().addAll(fUnit0, fUnit1, fUnit2, fUnit3, fUnit4, fUnit5, fUnit6, btnFight);
        menuComputerArmy.getChildren().addAll(fUnit7, fUnit8, fUnit9, fUnit10, fUnit11, fUnit12, fUnit13, btnExitGame);
        menuGame.getChildren().addAll(menuMyArmy, menuComputerArmy);

        Rectangle bg = new Rectangle(960, 560);
        bg.setFill(Color.GREY);
        bg.setOpacity(0.4);

        getChildren().addAll(bg, menu0);
    }
}
