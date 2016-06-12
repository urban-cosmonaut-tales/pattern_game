package Army;

import PatternBuilder.*;
import PatternFactory.*;
import Unit.*;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Дарья on 21.05.2016.
 */
public class ComputerArmy {
    private static ComputerArmy instance;

    public static ComputerArmy getInstance() {
        if (instance == null) {
            instance = new ComputerArmy();
        }
        return instance;
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
        int[] unitIndexes = {archer, berserker, healer, catapult};
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

}
