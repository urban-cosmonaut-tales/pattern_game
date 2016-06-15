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
        ComputerArmy comArm = ComputerArmy.getInstance();
        MyArmy myArm = MyArmy.getInstance();

        comArm.createArmy(0,2,3,3);
        myArm.createArmy(3,2,1,0);

        //description of army
        System.out.println("user army \n");
        for (Unit un : myArm.getArmy()){
            System.out.println(un.toString());
        }
        System.out.println("\ncomputer army \n");
        for (Unit un : comArm.getArmy()){
            System.out.println(un.toString());
        }

        // user attack
        /*ArrayList<Unit> ar = new ArrayList<>();
        ar.add(comArm.getSoldier(0));
        ar.add(comArm.getSoldier(1));

        myArm.getUnit(0).doAction(ar);



        System.out.println("user attack \n");

        System.out.println(myArm.getUnit(0).toString());
        System.out.println(comArm.getSoldier(0).toString());
        System.out.println(comArm.getSoldier(1).toString());*/

        System.out.println("\ncomputer attack \n");
        comArm.attack();

        System.out.println("user army \n");
        for (Unit un : myArm.getArmy()){
            System.out.println(un.toString());
        }
        System.out.println("\ncomputer army \n");
        for (Unit un : comArm.getArmy()){
            System.out.println(un.toString());
        }

    }
}
