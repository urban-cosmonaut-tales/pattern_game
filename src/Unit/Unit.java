package Unit;

import PatternState.DamagedState;
import PatternState.DeadState;
import PatternState.HealthyState;
import PatternState.State;
import javafx.scene.paint.Color;

import java.util.ArrayList;

/**
 * Created by Евгения on 05.06.2016.
 */
public abstract class Unit {
    protected int health;
    protected int maxHealth;
    protected int strength;
    protected State state = new HealthyState();
    protected int index;

    public void setHealth(int _health){
        if(_health >= this.maxHealth){
            this.health = this.maxHealth;
        }else if(_health <=0){
            this.health = 0;
        }else{
            this.health = _health;
        }
        this.changeState();
    }
    public void setIndex(int n){
        index = n;
    }
    protected int getIndex(){
        return index;
    }
    public void setMaxHealth(int _health){
        this.maxHealth = _health;
    }
    public void setStrength(int _strength){
        this.strength = _strength;
    }

    public Color getColor(){
        return state.setColor();
    }
    public int getHealth(){
        return this.health;
    }
    public int getStrength(){
        return this.strength;
    }
    public int getMaxHealth(){
        return maxHealth;
    }

    public abstract void doAction(ArrayList<Unit> enemies);
    protected void changeState(){
        //System.out.println("change " + strength);
        int percent = (100*health)/maxHealth;
        if(percent <= 35){
            this.state = new DeadState();
        }else if(percent <= 70){
            this.state = new DamagedState();
        }else {
            this.state = new HealthyState();
        }
    }
    public boolean isDead(){
        if(this.health<=0){
            return true;
        }
        else return false;
    }
    public String toString(){
        StringBuffer sb = new StringBuffer();
        sb.append("вид воина: " + this.getClass().getName());
        sb.append(" уровень: " + this.index);
        sb.append(" сила: " + this.strength);
        sb.append(" здоровье: " + this.health);
        return sb.toString();
    }
}
