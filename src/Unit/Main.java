package Unit;

import Army.ComputerArmy;
import Army.MyArmy;
import PatternBuilder.*;

import java.util.ArrayList;

/**
 * Created by Евгения on 06.06.2016.
 */
public class Main {
    public static void main(String[] args){
        ComputerArmy computerArmy = ComputerArmy.getInstance();
        ArrayList<Unit> arm = computerArmy.getArmy();
        System.out.println("computer army");
        for(Unit un : arm){
            System.out.println(un.toString());
        }

        MyArmy myArmy = MyArmy.getInstance();
        UnitBuilder ub = new ArcherBuilder(new Archer(), 4);
        ub.build();
        UnitBuilder ub1 = new BerserkerBuilder(new Berserker(), 0);
        ub1.build();
        UnitBuilder ub2 = new CatapultaBuilder(new Catapult(), 2);
        ub2.build();
        UnitBuilder ub3 = new HealerBuilder(new Healer(), 3);
        ub3.build();
        myArmy.addUnit(ub.getUnit());
        myArmy.addUnit(ub1.getUnit());
        myArmy.addUnit(ub2.getUnit());
        myArmy.addUnit(ub3.getUnit());
        ArrayList<Unit> arm2 = myArmy.getArmy();
        System.out.println("users army");
        for(Unit un : arm2){
            System.out.println(un.toString());
        }

        myArmy.getSoldier(1).doAction(new Unit[]{computerArmy.getSoldier(3)});
        System.out.println("war");
        System.out.println(myArmy.getSoldier(1));
        System.out.println(computerArmy.getSoldier(3));

        myArmy.getSoldier(3).doAction(new Unit[]{computerArmy.getSoldier(3), computerArmy.getSoldier(0)});
        System.out.println("war 1");
        System.out.println(myArmy.getSoldier(3));
        System.out.println(computerArmy.getSoldier(3));
        System.out.println(computerArmy.getSoldier(0));

    }
}
