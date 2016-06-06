package Frames;

import javafx.animation.TranslateTransition;
import javafx.scene.Parent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import java.io.IOException;

/**
 * Created by Дарья on 22.05.2016.
 */
public class GameMenu extends Parent {
    public GameMenu() throws IOException {
        VBox menu0 = new VBox(10);
        VBox menu2 = new VBox(10);

        HBox menu3 = new HBox(80);
        VBox menuAr = new VBox(10);
        VBox menuHil = new VBox(10);
        VBox menuBer = new VBox(10);
        VBox menuKatp = new VBox(10);

        VBox menu4 = new VBox(10);
        VBox menu5 = new VBox(10);
        VBox menuAllChange = new VBox(30);
        VBox menuMyArmy = new VBox(17);
        VBox menuComputerArmy = new VBox(17);
        HBox menuGame = new HBox(500);

        menu0.setTranslateX(200);
        menu0.setTranslateY(300);

        menu2.setTranslateX(200);
        menu2.setTranslateY(300);

        menuAllChange.setTranslateX(100);
        menuAllChange.setTranslateY(100);

        menuGame.setTranslateX(100);
        menuGame.setTranslateY(100);

        ClassName ar = new ClassName("Archers class");
        ImgButton unitAr0 = new ImgButton("C:\\Users\\Дарья\\IdeaProjects\\pattern_game\\pattern_game\\src\\Image\\Img\\arch\\icon.jpg");
        ImgButton unitAr1 = new ImgButton("C:\\Users\\Дарья\\IdeaProjects\\pattern_game\\pattern_game\\src\\Image\\Img\\arch\\Mirana.png");
        ImgButton unitAr2 = new ImgButton("C:\\Users\\Дарья\\IdeaProjects\\pattern_game\\pattern_game\\src\\Image\\Img\\arch\\templar-assassin.png");
        ImgButton unitAr3 = new ImgButton("C:\\Users\\Дарья\\IdeaProjects\\pattern_game\\pattern_game\\src\\Image\\Img\\arch\\windranger.png");

        ClassName hil = new ClassName("Healers class");
        ImgButton unitHil0 = new ImgButton("C:\\Users\\Дарья\\IdeaProjects\\pattern_game\\pattern_game\\src\\Image\\Img\\hil\\Disruptor.png");
        ImgButton unitHil1 = new ImgButton("C:\\Users\\Дарья\\IdeaProjects\\pattern_game\\pattern_game\\src\\Image\\Img\\hil\\hor_ico.png");
        ImgButton unitHil2 = new ImgButton("C:\\Users\\Дарья\\IdeaProjects\\pattern_game\\pattern_game\\src\\Image\\Img\\hil\\icon.jpg");
        ImgButton unitHil3 = new ImgButton("C:\\Users\\Дарья\\IdeaProjects\\pattern_game\\pattern_game\\src\\Image\\Img\\hil\\sky.png");

        ClassName ber = new ClassName("Berserkers class");
        ImgButton unitBer0 = new ImgButton("C:\\Users\\Дарья\\IdeaProjects\\pattern_game\\pattern_game\\src\\Image\\Img\\berserker\\Bloodseeker.png");
        ImgButton unitBer1 = new ImgButton("C:\\Users\\Дарья\\IdeaProjects\\pattern_game\\pattern_game\\src\\Image\\Img\\berserker\\hor_ico.png");
        ImgButton unitBer2 = new ImgButton("C:\\Users\\Дарья\\IdeaProjects\\pattern_game\\pattern_game\\src\\Image\\Img\\berserker\\icon.jpg");
        ImgButton unitBer3 = new ImgButton("C:\\Users\\Дарья\\IdeaProjects\\pattern_game\\pattern_game\\src\\Image\\Img\\berserker\\spirit_breaker_full.png");

        ClassName ktp = new ClassName("Catapults class");
        ImgButton unitKatp0 = new ImgButton("C:\\Users\\Дарья\\IdeaProjects\\pattern_game\\pattern_game\\src\\Image\\Img\\ktp\\Gyrocopter.png");
        ImgButton unitKatp1 = new ImgButton("C:\\Users\\Дарья\\IdeaProjects\\pattern_game\\pattern_game\\src\\Image\\Img\\ktp\\I'm Sorry pubs of the future3.png");
        ImgButton unitKatp2 = new ImgButton("C:\\Users\\Дарья\\IdeaProjects\\pattern_game\\pattern_game\\src\\Image\\Img\\ktp\\icon (1).jpg");
        ImgButton unitKatp3 = new ImgButton("C:\\Users\\Дарья\\IdeaProjects\\pattern_game\\pattern_game\\src\\Image\\Img\\ktp\\icon.jpg");

        FightButton fUnit0 = new FightButton("C:\\Users\\Дарья\\IdeaProjects\\pattern_game\\pattern_game\\src\\Image\\Tantsuyut-vse.jpg");
        FightButton fUnit1 = new FightButton("C:\\Users\\Дарья\\IdeaProjects\\pattern_game\\pattern_game\\src\\Image\\Tantsuyut-vse.jpg");
        FightButton fUnit2 = new FightButton("C:\\Users\\Дарья\\IdeaProjects\\pattern_game\\pattern_game\\src\\Image\\Tantsuyut-vse.jpg");
        FightButton fUnit3 = new FightButton("C:\\Users\\Дарья\\IdeaProjects\\pattern_game\\pattern_game\\src\\Image\\Tantsuyut-vse.jpg");
        FightButton fUnit4 = new FightButton("C:\\Users\\Дарья\\IdeaProjects\\pattern_game\\pattern_game\\src\\Image\\Tantsuyut-vse.jpg");
        FightButton fUnit5 = new FightButton("C:\\Users\\Дарья\\IdeaProjects\\pattern_game\\pattern_game\\src\\Image\\Tantsuyut-vse.jpg");
        FightButton fUnit6 = new FightButton("C:\\Users\\Дарья\\IdeaProjects\\pattern_game\\pattern_game\\src\\Image\\Tantsuyut-vse.jpg");
        FightButton fUnit7 = new FightButton("C:\\Users\\Дарья\\IdeaProjects\\pattern_game\\pattern_game\\src\\Image\\Tantsuyut-vse.jpg");

        final int offset = 400;

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

        menu0.getChildren().addAll(btnStart, btnInformation, btnExit);
        menu2.getChildren().addAll(btnBackInf, btnAboutGame);


        menu3.getChildren().addAll(menuAr, menuHil, menuBer, menuKatp);
        menuAr.getChildren().addAll(ar, unitAr0, unitAr1, unitAr2, unitAr3);
        menuHil.getChildren().addAll(hil, unitHil0, unitHil1, unitHil2, unitHil3);
        menuBer.getChildren().addAll(ber, unitBer0, unitBer1, unitBer2, unitBer3);
        menuKatp.getChildren().addAll(ktp, unitKatp0, unitKatp1, unitKatp2, unitKatp3);
        menu4.getChildren().addAll(btnBackSelect);
        menu5.getChildren().addAll(btnStartGame);
        menuAllChange.getChildren().addAll(menu3, menu4, menu5);

        menuMyArmy.getChildren().addAll(fUnit0, fUnit1, fUnit2, fUnit3, btnFight);
        menuComputerArmy.getChildren().addAll(fUnit4, fUnit5, fUnit6, fUnit7, btnExitGame);
        menuGame.getChildren().addAll(menuMyArmy, menuComputerArmy);

        Rectangle bg = new Rectangle(1200, 700);
        bg.setFill(Color.GREY);
        bg.setOpacity(0.4);

        getChildren().addAll(bg, menu0);
    }
}
