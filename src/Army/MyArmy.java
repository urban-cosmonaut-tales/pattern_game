package Army;

import java.util.ArrayList;

import PatternBuilder.*;
import PatternFactory.*;
import Unit.*;

/**
 * Created by Дарья on 21.05.2016.
 */
public class MyArmy {
    private static MyArmy instance;
    private static ArrayList<Unit> army;

    public static MyArmy getInstance() {
        if (instance == null) {
            instance = new MyArmy();
        }
        return instance;
    }
    public MyArmy(){
        army = new ArrayList<Unit>(4);
    }

    public static ArrayList<Unit> getArmy(){
        return army;
    }

    public Unit getUnit(int n){
        return army.get(n);
    }

    public void addUnit(Unit unit){
        army.add(unit);
    }

    public void addUnit(int index, Unit unit){
        army.add(index, unit);
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
