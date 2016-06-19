package Frames;

import Army.ComputerArmy;
import Army.MyArmy;
import Unit.Unit;
import javafx.animation.TranslateTransition;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import static java.lang.Thread.sleep;

/**
 * Created by Дарья on 22.05.2016.
 */
public class GameMenu extends Parent {
    FightButton[] fUnitPlayer, fUnitComp; // объекты-кнопки для самой битвы.
    UnitOptions[] fUnit, fComputer;
    MyArmy realArmyMy;
    ComputerArmy realArmyComp;
    boolean flag = false; // флаг для того, чтобы понять надо перезагружать армию или нет
    int countAr, countHl, countBr, countKp; // количество выделенных персонажей
    int numAr, numHl, numBr, numKp; // номер выделенного персонажа
    VBox menuMyArmy = new VBox(17); // меню в котором отображаются юниты армии игрока во время битвы
    VBox menuComputerArmy = new VBox(17); // меню в котором отображаются юниты армии компьютера во время битвы
    VBox opMyArmy = new VBox(17);
    VBox opComputerArmy = new VBox(17);
    HBox allMyArmy = new HBox(10);
    HBox allComputerArmy = new HBox(10);
    HBox menuGame = new HBox(350); // здесь лежат армия игрока, армия компьютера и необходимые кнопки меню битвы
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

        menuGame.setTranslateX(70);
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
        ImgButton[] unitAr = new ImgButton[4];
        unitAr[0] = new ImgButton(Ar[0]);
        unitAr[1] = new ImgButton(Ar[1]);
        unitAr[2] = new ImgButton(Ar[2]);
        unitAr[3] = new ImgButton(Ar[3]);

        ClassName hil = new ClassName("Healers class", Color.DARKGREEN);
        ImgButton[] unitHl = new ImgButton[4];
        unitHl[0] = new ImgButton(Hl[0]);
        unitHl[1] = new ImgButton(Hl[1]);
        unitHl[2] = new ImgButton(Hl[2]);
        unitHl[3] = new ImgButton(Hl[3]);

        ClassName ber = new ClassName("Berserkers class", Color.DARKRED);
        ImgButton[] unitBer = new ImgButton[4];
        unitBer[0] = new ImgButton(Br[0]);
        unitBer[1] = new ImgButton(Br[1]);
        unitBer[2] = new ImgButton(Br[2]);
        unitBer[3] = new ImgButton(Br[3]);

        ClassName ktp = new ClassName("Catapults class",Color.DARKGOLDENROD);
        ImgButton[] unitKatp = new ImgButton[4];
        unitKatp[0] = new ImgButton(Kp[0]);
        unitKatp[1] = new ImgButton(Kp[1]);
        unitKatp[2] = new ImgButton(Kp[2]);
        unitKatp[3] = new ImgButton(Kp[3]);


        final int offset = 400;

        menu2.setTranslateX(offset);
        menuAllChange.setTranslateX(offset);
        menuGame.setTranslateX(offset);

        realArmyMy = new MyArmy();
        realArmyComp = new ComputerArmy();

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

        // внопка закончить игру
        MenuButtonShort btnExitGame = new MenuButtonShort("END GAME");

        // кнопка начать игру
        MenuButton btnStartGame = new MenuButton("START GAME");
        btnStartGame.setOnMouseClicked( event -> {
            if(!flag) {
                fUnitPlayer = new FightButton[4];
                fUnitComp = new FightButton[4];
                //
                fUnit = new UnitOptions[4];
                fComputer = new UnitOptions[4];
                //

                countAr=0; countHl=0; countBr=0; countKp=0;
                numAr=-1; numHl=-1; numBr=-1; numKp=-1;
            }
            if (flag) { // если армию уже создавали обнуляем все переменные необходимые для боя
                fUnitPlayer[0] = null; fUnitPlayer[1] = null; fUnitPlayer[2] = null; fUnitPlayer[3] = null;
                fUnitComp[0] = null; fUnitComp[1] = null; fUnitComp[2] = null; fUnitComp[3] = null;
                //
                fUnit[0]= null; fUnit[1]= null; fUnit[2]= null; fUnit[3]= null;
                fComputer[0]=null; fComputer[1]=null; fComputer[2]=null; fComputer[3]=null;
                //


                flag = false;
                menuMyArmy = new VBox(17);
                menuComputerArmy = new VBox(17);
                opMyArmy = new VBox(17);
                opComputerArmy = new VBox(17);
                allMyArmy = new HBox(10);
                allComputerArmy = new HBox(10);
                menuGame = new HBox(350);

                menuGame.setTranslateX(70);
                menuGame.setTranslateY(100);
                menuGame.setTranslateX(offset);
            }
            try {
                for(int i=0;i<4;i++){
                    if(unitAr[i].getStatus()) {
                        countAr++; numAr=i;
                        unitAr[i].setEffect(null);
                        unitAr[i].setStatus(false);
                        }
                    if(unitHl[i].getStatus()) {
                        countHl++; numHl=i;
                        unitHl[i].setEffect(null);
                        unitHl[i].setStatus(false);
                        }
                    if(unitBer[i].getStatus()) {
                        countBr++; numBr=i;
                        unitBer[i].setEffect(null);
                        unitBer[i].setStatus(false);
                        }
                    if(unitKatp[i].getStatus()) {
                        countKp++; numKp=i;
                        unitKatp[i].setEffect(null);
                        unitKatp[i].setStatus(false);
                        }
                }
                if ((countAr != 1)||(countBr != 1) || (countHl != 1) || (countKp != 1)) {
                    JOptionPane.showMessageDialog(null,"\n" + "In each class, one character must be selected");
                    return;
                }

                // задаем картинки выбранных персонажей персонажам в окне сражения
                fUnitPlayer[0] = new FightButton(Ar[numAr]);
                fUnitPlayer[1] = new FightButton(Br[numBr]);
                fUnitPlayer[2] = new FightButton(Hl[numHl]);
                fUnitPlayer[3] = new FightButton(Kp[numKp]);
                // здесь передаем в билдер значение всех индексов для создания персонажей
                realArmyMy.createArmy(numAr, numBr, numHl, numKp);

                // рандомим номер элемента массива для каждого класса
                Random rnd = new Random();
                int numArComp = rnd.nextInt(4);
                int numHlComp = rnd.nextInt(4);
                int numBrComp = rnd.nextInt(4);
                int numKpComp = rnd.nextInt(4);
                // присваиваем кнопке сражения картинку в зависммости от результата рандома
                fUnitComp[0] = new FightButton(Ar[numArComp]);
                // здесь создание персонажа
                fUnitComp[1] = new FightButton(Br[numBrComp]);
                // здесь создание персонажа
                fUnitComp[2] = new FightButton(Hl[numHlComp]);
                // здесь создание персонажа
                fUnitComp[3] = new FightButton(Kp[numKpComp]);
                // здесь создание персонажа
                realArmyComp.createArmy(numArComp, numBrComp, numHlComp, numKpComp);

                //
                fUnit[0] = new UnitOptions(realArmyMy.getUnit(0).getHealth(),
                        realArmyMy.getUnit(0).getStrength(),realArmyMy.getUnit(0).getColor(), false);
                fUnit[1] = new UnitOptions(realArmyMy.getUnit(1).getHealth(),
                        realArmyMy.getUnit(1).getStrength(),realArmyMy.getUnit(1).getColor(),false);
                fUnit[2] = new UnitOptions(realArmyMy.getUnit(2).getHealth(),
                        realArmyMy.getUnit(2).getStrength(),realArmyMy.getUnit(2).getColor(),true);
                fUnit[3] = new UnitOptions(realArmyMy.getUnit(3).getHealth(),
                        realArmyMy.getUnit(3).getStrength(),realArmyMy.getUnit(3).getColor(),false);

                fComputer[0] = new UnitOptions(realArmyComp.getSoldier(0).getHealth(),
                        realArmyComp.getSoldier(0).getStrength(),realArmyComp.getSoldier(0).getColor(),false);
                fComputer[1] = new UnitOptions(realArmyComp.getSoldier(1).getHealth(),
                        realArmyComp.getSoldier(1).getStrength(),realArmyComp.getSoldier(1).getColor(),false);
                fComputer[2] = new UnitOptions(realArmyComp.getSoldier(2).getHealth(),
                        realArmyComp.getSoldier(2).getStrength(),realArmyComp.getSoldier(2).getColor(),true);
                fComputer[3] = new UnitOptions(realArmyComp.getSoldier(3).getHealth(),
                        realArmyComp.getSoldier(3).getStrength(),realArmyComp.getSoldier(3).getColor(),false);
                //

                countAr=0; countHl=0; countBr=0; countKp=0;
                numAr=-1; numHl=-1; numBr=-1; numKp=-1;
                if (!flag) { // если переменные обнулены или еще ни разу не создавались
                    // заполняем меню элементами
                    menuMyArmy.getChildren().addAll(fUnitPlayer[0], fUnitPlayer[1], fUnitPlayer[2], fUnitPlayer[3], btnFight);
                    menuComputerArmy.getChildren().addAll(fUnitComp[0], fUnitComp[1], fUnitComp[2], fUnitComp[3], btnExitGame);
                    //
                    opMyArmy.getChildren().addAll(fUnit[0],fUnit[1],fUnit[2],fUnit[3]);
                    opComputerArmy.getChildren().addAll(fComputer[0],fComputer[1],fComputer[2],fComputer[3]);
                    allMyArmy.getChildren().addAll(menuMyArmy,opMyArmy);
                    allComputerArmy.getChildren().addAll(opComputerArmy,menuComputerArmy);
                    menuGame.getChildren().addAll(allMyArmy, allComputerArmy);
                    //
                    //menuGame.getChildren().addAll(menuMyArmy, menuComputerArmy);
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



        btnFight.setOnMouseClicked(event -> {
            int countFU = 0;
            int countFC = 0;
            int[] numberFU;
            int[] numberFC;
            for (int i=0;i<4;i++) {
                if(fUnitPlayer[i].getState()) {
                    countFU++;
                }
                if (fUnitComp[i].getState()) {
                    countFC++;
                }
            }

            if (countFU == 0) {
                JOptionPane.showMessageDialog(null,"\n" + "You have not chosen anyone");
                return;
            }

            numberFU = new int[countFU];
            numberFC = new int[countFC];
            int fu=0;
            int fc=0;

            for (int i=0;i<4;i++) {
                if(fUnitPlayer[i].getState()) {
                    numberFU[fu] = i;
                    fu++;
                    fUnitPlayer[i].setEffect(null);
                    fUnitPlayer[i].setState(false);
                }
                if (fUnitComp[i].getState()) {
                    numberFC[fc] = i;
                    fc++;
                    fUnitComp[i].setEffect(null);
                    fUnitComp[i].setState(false);
                }
            }
            //Class<?> unitClass = realArmyMy.getUnit(numberFU).getClass();
            //System.out.println(unitClass.toString());

            if(countFU == 1) {
                Class<?> unitClass = realArmyMy.getUnit(numberFU[0]).getClass();
                ArrayList<Unit> arrayDamage = new ArrayList<Unit>();
                if(unitClass.equals(realArmyMy.getUnit(0).getClass())) {
                    System.out.println("this real archer");
                    for(int i=0;i<countFC;i++) {
                        arrayDamage.add(realArmyComp.getSoldier(numberFC[i]));
                    }
                    realArmyMy.getUnit(0).doAction(arrayDamage);
                }
                if(unitClass.equals(realArmyMy.getUnit(1).getClass())) {
                    System.out.println("this real ber");
                    if(countFC != 1) {
                        JOptionPane.showMessageDialog(null,"\n" + "Berserker can attack only one unit");
                        return;
                    }
                    for(int i=0;i<countFC;i++) {
                        arrayDamage.add(realArmyComp.getSoldier(numberFC[i]));
                    }
                    realArmyMy.getUnit(1).doAction(arrayDamage);
                }
                if(unitClass.equals(realArmyMy.getUnit(3).getClass())) {
                    System.out.println("this real kap");
                    if(countFC != 4) {
                        JOptionPane.showMessageDialog(null,"\n" + "For attack catapult the enemy select all unit");
                        return;
                    }
                    for(int i=0;i<countFC;i++) {
                        arrayDamage.add(realArmyComp.getSoldier(numberFC[i]));
                    }
                    realArmyMy.getUnit(3).doAction(arrayDamage);

                }
            }
            else if (countFC == 0){
                ArrayList<Unit> arrayHl = new ArrayList<Unit>();
                boolean fheal = false;
                for (int i=0; i<countFU;i++) {
                    Class<?> unitClass = realArmyMy.getUnit(numberFU[i]).getClass();
                    if(unitClass.equals(realArmyMy.getUnit(2).getClass())) {
                        System.out.println("this real hil");
                        fheal=true;
                    } else {
                        arrayHl.add(realArmyMy.getUnit(numberFU[i]));
                    }
                }
                if (!fheal) {
                    JOptionPane.showMessageDialog(null,"\n" + "Not set healer");
                    return;
                }
                realArmyMy.getUnit(2).doAction(arrayHl);

            }
            else {
                JOptionPane.showMessageDialog(null,"\n" + "Healer does not treat the enemy");
                return;
            }
            fUnit[0].textHp.setText("Health: " + Integer.toString(realArmyMy.getUnit(0).getHealth()));
            fUnit[1].textHp.setText("Health: " + Integer.toString(realArmyMy.getUnit(1).getHealth()));
            fUnit[2].textHp.setText("Health: " + Integer.toString(realArmyMy.getUnit(2).getHealth()));
            fUnit[3].textHp.setText("Health: " + Integer.toString(realArmyMy.getUnit(3).getHealth()));
            fUnit[0].st.setFill(realArmyMy.getUnit(0).getColor());
            fUnit[1].st.setFill(realArmyMy.getUnit(1).getColor());
            fUnit[2].st.setFill(realArmyMy.getUnit(2).getColor());
            fUnit[3].st.setFill(realArmyMy.getUnit(3).getColor());

            fComputer[0].textHp.setText("Health: " + Integer.toString(realArmyComp.getSoldier(0).getHealth()));
            fComputer[1].textHp.setText("Health: " + Integer.toString(realArmyComp.getSoldier(1).getHealth()));
            fComputer[2].textHp.setText("Health: " + Integer.toString(realArmyComp.getSoldier(2).getHealth()));
            fComputer[3].textHp.setText("Health: " + Integer.toString(realArmyComp.getSoldier(3).getHealth()));
            fComputer[0].st.setFill(realArmyComp.getSoldier(0).getColor());
            fComputer[1].st.setFill(realArmyComp.getSoldier(1).getColor());
            fComputer[2].st.setFill(realArmyComp.getSoldier(2).getColor());
            fComputer[3].st.setFill(realArmyComp.getSoldier(3).getColor());

            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            realArmyComp.attack();

            fUnit[0].textHp.setText("Health: " + Integer.toString(realArmyMy.getUnit(0).getHealth()));
            fUnit[1].textHp.setText("Health: " + Integer.toString(realArmyMy.getUnit(1).getHealth()));
            fUnit[2].textHp.setText("Health: " + Integer.toString(realArmyMy.getUnit(2).getHealth()));
            fUnit[3].textHp.setText("Health: " + Integer.toString(realArmyMy.getUnit(3).getHealth()));

            fComputer[0].textHp.setText("Health: " + Integer.toString(realArmyComp.getSoldier(0).getHealth()));
            fComputer[1].textHp.setText("Health: " + Integer.toString(realArmyComp.getSoldier(1).getHealth()));
            fComputer[2].textHp.setText("Health: " + Integer.toString(realArmyComp.getSoldier(2).getHealth()));
            fComputer[3].textHp.setText("Health: " + Integer.toString(realArmyComp.getSoldier(3).getHealth()));
        });

        btnExitGame.setOnMouseClicked( event -> {
            int reply = JOptionPane.showConfirmDialog(null, "\n" + "ARE YOU SURE?", "THIS IS THE END", JOptionPane.YES_NO_OPTION);
            if (reply== JOptionPane.NO_OPTION) {return;}
            flag = true; // меняется значение флага, необходимое для обнуления массива армии игрока и армии компьютера
            getChildren().add(menu0);
            realArmyMy.getArmy().clear();
            realArmyComp.getArmy().clear();

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

        // в каждое менб помещаются соответствующие элементы
        menu0.getChildren().addAll(btnStart, btnInformation, btnExit);
        menu2.getChildren().addAll(btnBackInf, btnAboutGame);

        menu3.getChildren().addAll(menuAr, menuHil, menuBer, menuKatp);
        menuAr.getChildren().addAll(ar, unitAr[0], unitAr[1], unitAr[2], unitAr[3]);
        menuHil.getChildren().addAll(hil, unitHl[0], unitHl[1], unitHl[2], unitHl[3]);
        menuBer.getChildren().addAll(ber, unitBer[0], unitBer[1], unitBer[2], unitBer[3]);
        menuKatp.getChildren().addAll(ktp, unitKatp[0], unitKatp[1], unitKatp[2], unitKatp[3]);
        menu4.getChildren().addAll(btnBackSelect);
        menu5.getChildren().addAll(btnStartGame);
        menuAllChange.getChildren().addAll(menu3, menu4, menu5);

        Rectangle bg = new Rectangle(1200, 700);
        bg.setFill(Color.GREY);
        bg.setOpacity(0.4);

        getChildren().addAll(bg, menu0);
    }
}
