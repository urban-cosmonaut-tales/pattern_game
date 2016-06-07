package Frames;

import javafx.animation.TranslateTransition;
import javafx.scene.Parent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import java.io.IOException;
import java.util.Random;

/**
 * Created by Дарья on 22.05.2016.
 */
public class GameMenu extends Parent {
    FightButton fUnit0, fUnit1, fUnit2, fUnit3, fUnit4, fUnit5, fUnit6, fUnit7; // объекты-кнопки для самой битвы.
    boolean flag = false; // флаг для того, чтобы понять надо перезагружать армию или нет
    VBox menuMyArmy = new VBox(17); // меню в котором отображаются юниты армии игрока во время битвы
    VBox menuComputerArmy = new VBox(17); // меню в котором отображаются юниты армии компьютера во время битвы
    HBox menuGame = new HBox(500); // здесь лежат армия игрока, армия компьютера и необходимые кнопки меню битвы
    String[] Ar; // массив с путями до картинок лучников
    String[] Hl; // массив с путями до картинок целителей
    String[] Br; // массив с путями до картинок воинов
    String[] Kp; // массив с путями до картинок катапульт
    public GameMenu() throws IOException {
        VBox menu0 = new VBox(10); // стартовое меню
        VBox menu2 = new VBox(10); // меню информации об игре

        HBox menu3 = new HBox(80); // здесь лежат все классы для всех юнитов
        VBox menuAr = new VBox(10); // меню выбора содержащее класс лучников
        VBox menuHil = new VBox(10); // меню выбора содержащее класс целителей
        VBox menuBer = new VBox(10); // меню выбора содержащее класс воинов
        VBox menuKatp = new VBox(10); // меню выбора содержащее класс катапульт

        VBox menu4 = new VBox(10); // в меню выбора лежит клавиша вернуться в главное меню
        VBox menu5 = new VBox(10); // в меню выбора лежит клавиша начать игру
        VBox menuAllChange = new VBox(30); // здесь лежат все элементы меню выбора

        // перемещаем каждое меню по оси X и Y от угла фрейма
        menu0.setTranslateX(200);
        menu0.setTranslateY(300);

        menu2.setTranslateX(200);
        menu2.setTranslateY(300);

        menuAllChange.setTranslateX(100);
        menuAllChange.setTranslateY(100);

        menuGame.setTranslateX(100);
        menuGame.setTranslateY(100);

        // присваиваем массивы 4 элемента и для каждого указываем путь до картинки
        Ar = new String[4];
        Ar[0] = new String("C:\\Users\\Дарья\\IdeaProjects\\pattern_game\\pattern_game\\src\\Image\\Img\\arch\\icon.jpg");
        Ar[1] = new String("C:\\Users\\Дарья\\IdeaProjects\\pattern_game\\pattern_game\\src\\Image\\Img\\arch\\Mirana.png");
        Ar[2] = new String("C:\\Users\\Дарья\\IdeaProjects\\pattern_game\\pattern_game\\src\\Image\\Img\\arch\\templar-assassin.png");
        Ar[3] = new String("C:\\Users\\Дарья\\IdeaProjects\\pattern_game\\pattern_game\\src\\Image\\Img\\arch\\windranger.png");

        Hl = new String[4];
        Hl[0] = new String("C:\\Users\\Дарья\\IdeaProjects\\pattern_game\\pattern_game\\src\\Image\\Img\\hil\\Disruptor.png");
        Hl[1] = new String("C:\\Users\\Дарья\\IdeaProjects\\pattern_game\\pattern_game\\src\\Image\\Img\\hil\\hor_ico.png");
        Hl[2] = new String("C:\\Users\\Дарья\\IdeaProjects\\pattern_game\\pattern_game\\src\\Image\\Img\\hil\\icon.jpg");
        Hl[3] = new String("C:\\Users\\Дарья\\IdeaProjects\\pattern_game\\pattern_game\\src\\Image\\Img\\hil\\sky.png");

        Br = new String[4];
        Br[0] = new String("C:\\Users\\Дарья\\IdeaProjects\\pattern_game\\pattern_game\\src\\Image\\Img\\berserker\\Bloodseeker.png");
        Br[1] = new String("C:\\Users\\Дарья\\IdeaProjects\\pattern_game\\pattern_game\\src\\Image\\Img\\berserker\\hor_ico.png");
        Br[2] = new String("C:\\Users\\Дарья\\IdeaProjects\\pattern_game\\pattern_game\\src\\Image\\Img\\berserker\\icon.jpg");
        Br[3] = new String("C:\\Users\\Дарья\\IdeaProjects\\pattern_game\\pattern_game\\src\\Image\\Img\\berserker\\spirit_breaker_full.png");

        Kp = new String[4];
        Kp[0] = new String("C:\\Users\\Дарья\\IdeaProjects\\pattern_game\\pattern_game\\src\\Image\\Img\\ktp\\Gyrocopter.png");
        Kp[1] = new String("C:\\Users\\Дарья\\IdeaProjects\\pattern_game\\pattern_game\\src\\Image\\Img\\ktp\\I'm Sorry pubs of the future3.png");
        Kp[2] = new String("C:\\Users\\Дарья\\IdeaProjects\\pattern_game\\pattern_game\\src\\Image\\Img\\ktp\\icon (1).jpg");
        Kp[3] = new String("C:\\Users\\Дарья\\IdeaProjects\\pattern_game\\pattern_game\\src\\Image\\Img\\ktp\\icon.jpg");

        String nol = new String("C:\\Users\\Дарья\\IdeaProjects\\pattern_game\\pattern_game\\src\\Image\\Tantsuyut-vse.jpg");

        // создаем заголовок для каждого класса и создаем кнопки-картинки
        ClassName ar = new ClassName("Archers class", Color.DARKBLUE);
        ImgButton unitAr0 = new ImgButton(Ar[0]);
        ImgButton unitAr1 = new ImgButton(Ar[1]);
        ImgButton unitAr2 = new ImgButton(Ar[2]);
        ImgButton unitAr3 = new ImgButton(Ar[3]);

        ClassName hil = new ClassName("Healers class", Color.DARKGREEN);
        ImgButton unitHil0 = new ImgButton(Hl[0]);
        ImgButton unitHil1 = new ImgButton(Hl[1]);
        ImgButton unitHil2 = new ImgButton(Hl[2]);
        ImgButton unitHil3 = new ImgButton(Hl[3]);

        ClassName ber = new ClassName("Berserkers class", Color.DARKRED);
        ImgButton unitBer0 = new ImgButton(Br[0]);
        ImgButton unitBer1 = new ImgButton(Br[1]);
        ImgButton unitBer2 = new ImgButton(Br[2]);
        ImgButton unitBer3 = new ImgButton(Br[3]);

        ClassName ktp = new ClassName("Catapults class",Color.DARKGOLDENROD);
        ImgButton unitKatp0 = new ImgButton(Kp[0]);
        ImgButton unitKatp1 = new ImgButton(Kp[1]);
        ImgButton unitKatp2 = new ImgButton(Kp[2]);
        ImgButton unitKatp3 = new ImgButton(Kp[3]);


        final int offset = 400;

        menu2.setTranslateX(offset);
        menuAllChange.setTranslateX(offset);
        menuGame.setTranslateX(offset);

        // кнопка старт главного меню
        // класс TranslateTransition для анимации перемещения здесь и далее
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

        // кнопка информации главного меню
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

        // кнопка выхода главное меню
        MenuButton btnExit = new MenuButton("EXIT");
        btnExit.setOnMouseClicked(event -> {
            System.exit(0);
        });

        // кнопка вернуться в главное меню из меню с инофрмацией об игре
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

        // кнопка получить информацию об игре
        MenuButton btnAboutGame = new MenuButton("ABOUT GAME");

        //кнопка вернуться в главное меню из менб выбора персонажей
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

        // по нажатию этой кнопки должно анимироваться и происходить сражение
        MenuButtonShort btnFight = new MenuButtonShort("FIGHT");
        btnFight.setOnMouseClicked(event -> {

        });

        // внопка закончить игру
        MenuButtonShort btnExitGame = new MenuButtonShort("END GAME");
        btnExitGame.setOnMouseClicked( event -> {
            flag = true; // меняется значение флага, необходимое для обнуления массива армии игрока и армии компьютера
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

        // кнопка начать игру
        MenuButton btnStartGame = new MenuButton("START GAME");
        btnStartGame.setOnMouseClicked( event -> {
            if (flag == true) { // если армию уже создавали обнуляем все переменные необходимые для боя
                fUnit0 = null; fUnit1 = null; fUnit2 = null; fUnit3 = null; fUnit4 = null; fUnit5 = null; fUnit6 = null; fUnit7 = null;
                flag = false;
                menuMyArmy = new VBox(17);
                menuComputerArmy = new VBox(17);
                menuGame = new HBox(500);

                menuGame.setTranslateX(100);
                menuGame.setTranslateY(100);
                menuGame.setTranslateX(offset);
            }
            try {
                // если выбран лучник(0) то кнопке в меню сражение присваиваем картинку сражение
                if (unitAr0.getStatus()== true) {
                    fUnit0 = new FightButton(Ar[0]);
                    // здесь создание персонажа
                    }
                else
                {fUnit0 = new FightButton(nol);}
                // если выбран целитель(0) то кнопке в меню сражение присваиваем картинку сражение
                if (unitHil0.getStatus() == true) {
                    fUnit1 = new FightButton(Hl[0]);
                    // здесь создание персонажа
                }
                else
                {fUnit1 = new FightButton(nol);}
                // если выбран воин(0) то кнопке в меню сражение присваиваем картинку сражение
                if (unitBer0.getStatus() == true) {
                    fUnit2 = new FightButton(Br[0]);
                    // здесь создание персонажа
                }
                else
                {fUnit2 = new FightButton(nol);}
                // если выбрана катапульта(0) то кнопке в меню сражение присваиваем картинку сражение
                if (unitKatp0.getStatus() == true) {
                    fUnit3 = new FightButton(Kp[0]);
                    // здесь создание персонажа
                }
                else
                {fUnit3 = new FightButton(nol);}

                // рандомим номер элемента массива для каждого класса
                Random rnd = new Random();
                int numAr = rnd.nextInt(4);
                int numHl = rnd.nextInt(4);
                int numBr = rnd.nextInt(4);
                int numKp = rnd.nextInt(4);
                // присваиваем кнопке сражения картинку в зависммости от результата рандома
                fUnit4 = new FightButton(Ar[numAr]);
                // здесь создание персонажа
                fUnit5 = new FightButton(Hl[numHl]);
                // здесь создание персонажа
                fUnit6 = new FightButton(Br[numBr]);
                // здесь создание персонажа
                fUnit7 = new FightButton(Kp[numKp]);
                // здесь создание персонажа
                if (flag == false) { // если переменные обнулены или еще ни разу не создавались
                    // заполняем меню элементами
                    menuMyArmy.getChildren().addAll(fUnit0, fUnit1, fUnit2, fUnit3, btnFight);
                    menuComputerArmy.getChildren().addAll(fUnit4, fUnit5, fUnit6, fUnit7, btnExitGame);
                    menuGame.getChildren().addAll(menuMyArmy, menuComputerArmy);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
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

        // в каждое менб помещаются соответствующие элементы
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

        Rectangle bg = new Rectangle(1200, 700);
        bg.setFill(Color.GREY);
        bg.setOpacity(0.4);

        getChildren().addAll(bg, menu0);
    }
}
