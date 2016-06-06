package Army;

import java.util.ArrayList;
import Unit.*;

/**
 * Created by Дарья on 21.05.2016.
 */
public class MyArmy {
    private static MyArmy instance;

    public static MyArmy getInstance() {
        if (instance == null) {
            instance = new MyArmy();
        }
        return instance;
    }
    public ArrayList<Unit> getArmy(){
        return this.army;
    }
    public Unit getSoldier(int n){
        return army.get(n);
    }
    private ArrayList<Unit> army;
    public MyArmy(){
        army = new ArrayList<Unit>(5);
    }
    public void addUnit(Unit unit){
        army.add(unit);
    }
}
