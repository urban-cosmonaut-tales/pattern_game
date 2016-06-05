package Unit;

import PatternState.State;

/**
 * Created by Дарья on 21.05.2016.
 */
public class Healer extends Unit{
    private double health;
    private double minHealth;
    private double strength;
    private State state;

    public void setHealth(double _health){
        this.health = _health;
    }
    public void setMinHealth(double _health){
        this.minHealth = _health;
    }
    public void setStrength(double _strength){
        this.strength = _strength;
    }
    public void changeState(){

    }
}
