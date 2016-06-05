package Unit;

import PatternState.DamagedState;
import PatternState.DeadState;
import PatternState.HealthyState;
import PatternState.State;
import java.awt.Color;

/**
 * Created by Дарья on 21.05.2016.
 */
public class Archer extends Unit{
    private double health;
    private double maxHealth;
    private double strength;
    //private Color color = Color.green;
    private State state = new HealthyState();

    public void setHealth(double _health){
        this.health = _health;
        changeState();
    }
    public void setMaxHealth(double _health){
        this.maxHealth = _health;
    }
    public void setStrength(double _strength){
        this.strength = _strength;
    }

    public Color getColor(){
        return state.setColor();
    }
    public double getHealth(){
        return this.health;
    }
    public void changeState(){
        double percent = (100*health)/maxHealth;
        if(percent <= 35){
            this.state = new DeadState();
        }else if(percent <= 70){
            this.state = new DamagedState();
        }else {
            this.state = new HealthyState();
        }
    }


    public void doAction(Unit unit){

    }
}
