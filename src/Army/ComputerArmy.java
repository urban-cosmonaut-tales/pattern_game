package Army;

import PatternBuilder.*;
import PatternFactory.*;
import Unit.*;

import javafx.scene.paint.Color;
import java.util.ArrayList;
import java.util.Random;
import java.util.jar.Pack200;

/**
 * Created by Дарья on 21.05.2016.
 */
public class ComputerArmy {
    private static ComputerArmy instance;
    private int attackingSoldier;
    private ArrayList<Integer> attackedUnits = new ArrayList<>();

    public static ComputerArmy getInstance() {
        if (instance == null) {
            instance = new ComputerArmy();
        }
        return instance;
    }
    public int getAttackingSoldier(){
        return this.attackingSoldier;
    }
    public ArrayList<Integer> getAttackedUnits(){
        return this.attackedUnits;
    }
    private ArrayList<Unit> army;

    public ComputerArmy(){
        army = new ArrayList<Unit>(4);
    }

    public ArrayList<Unit> getArmy(){
        return this.army;
    }
    public Unit getSoldier(int index){
        return army.get(index);
    }
    public void addUnit(int index, Unit unit){
        army.add(index, unit);
    }
    public void addUnit(Unit unit){
        army.add(unit);
    }

    public void createArmy(int archer, int berserker, int healer, int catapult){
        if(!army.isEmpty())
            army.clear();
        Factory[] factories = new Factory[]{new ArcherFactory(), new BerserkerFactory(), new HealerFactory(),
                new CatapultFactory()};

        for (Factory factory: factories){
            army.add(factory.createUnit());
        }
        new ArcherBuilder(army.get(0), archer).build();
        new BerserkerBuilder(army.get(1), berserker).build();
        new HealerBuilder(army.get(2), healer).build();
        new CatapultaBuilder(army.get(3), catapult).build();

    }
    private ArrayList<Unit> generateEnemies(){
        int enemyCount;
        Random rnd = new Random();
        ArrayList<Unit> units = new ArrayList<Unit>();
        int pastNum = 6;
        int presentNum;
        enemyCount = rnd.nextInt(4)+1;
        for(int i = 0; i < enemyCount; i++){
            presentNum = rnd.nextInt(4);
            if(!MyArmy.getArmy().get(presentNum).isDead() && presentNum != pastNum){
                units.add(MyArmy.getArmy().get(presentNum));
            }
            pastNum = presentNum;
        }
        return units;
    }
    public void attack(){
        int soldier;
        ArrayList<Unit> units;
        while(true){
            soldier = new Random().nextInt(army.size());
            if(!this.army.get(soldier).isDead()){
                break;
            }
        }
        if(soldier == 0 || soldier == 1 ) {
            units = generateEnemies();
        }else if(soldier == 2){
            int enemyCount;
            Random rnd = new Random();
            units = new ArrayList<Unit>();
            int pastNum = 6;
            int presentNum;
            enemyCount = rnd.nextInt(4)+1;
            for(int i = 0; i < enemyCount; i++){
                presentNum = rnd.nextInt(4);
                if(!this.army.get(presentNum).isDead() && presentNum != pastNum && this.army.get(presentNum).getColor() != Color.GREEN && presentNum != 2){
                    units.add(this.army.get(presentNum));
                }
                pastNum = presentNum;
            }
        } else{
            units = new ArrayList<>();
                while(true) {
                    int ind = new Random().nextInt(4);
                    if (!MyArmy.getArmy().get(ind).isDead()) {
                        units.add(MyArmy.getArmy().get(ind));
                        break;
                    }
                }
        }

       // System.out.println(this.army.get(soldier).toString());
        //System.out.println("enemy");
        /*for(Unit un : units){
            System.out.println(un.toString());
        }*/
        this.army.get(soldier).doAction(units);
        attackingSoldier = soldier;
        for(Unit un : units){
            if(un.getClass().getName().equals("Unit.Archer")){
                attackedUnits.add(0);
            }else if(un.getClass().getName().equals("Unit.Berserker")){
                attackedUnits.add(1);
            }else if(un.getClass().getName().equals("Unit.Healer")){
                attackedUnits.add(2);
            }else {
                attackedUnits.add(3);
            }
        }
    }

}
