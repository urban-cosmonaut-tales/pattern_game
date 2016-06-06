package Army;

import PatternBuilder.*;
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
        for(int i = 0; i < 4; i++){
            army.add(addUnit(new Random().nextInt(4)));
        }

    }

    public ArrayList<Unit> getArmy(){
        return this.army;
    }
    public Unit getSoldier(int n){
        return army.get(n);
    }
    protected Unit addUnit(int num){
        Unit un = null;
        UnitBuilder ub;
        switch (num) {
            case 0:
                ub = new ArcherBuilder(new Archer(), new Random().nextInt(4));
                ub.buildHealth();
                ub.buildStrength();
                un = ub.getUnit();
                break;
            case 1:
                ub = new BerserkerBuilder(new Berserker(), new Random().nextInt(4));
                ub.buildHealth();
                ub.buildStrength();
                un = ub.getUnit();
                break;
            case 2:
                ub = new HealerBuilder(new Healer(), new Random().nextInt(4));
                ub.buildHealth();
                ub.buildStrength();
                un = ub.getUnit();

                break;
            case 3:
                ub = new CatapultaBuilder(new Catapult(), new Random().nextInt(4));
                ub.buildHealth();
                ub.buildStrength();
                un = ub.getUnit();
                break;
        }
        return un;
    }
}
