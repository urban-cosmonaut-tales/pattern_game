package PatternBuilder;
import Unit.*;
/**
 * Created by Дарья on 21.05.2016.
 */
public class Director {
    public void build(UnitBuilder b){
        b.buildStrength();
        b.buildHealth();
    }

}
