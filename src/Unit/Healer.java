package Unit;

import java.util.ArrayList;

/**
 * Created by Дарья on 21.05.2016.
 */
public class Healer extends Unit{
    public Healer(){
        maxHealth = 30;
    }
    @Override
    public void doAction(ArrayList<Unit> enemy) {
        int count = enemy.size();
        int str = strength;
        for(int i = 0; i < enemy.size(); i++){
            int damage = str/count--;
            int health = enemy.get(i).getHealth() + damage;
            enemy.get(i).setHealth(health);
            str = str - damage;
        }
    }
}
