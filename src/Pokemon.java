import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Pokemon extends Card {
    //I want to try using an array list instead of having multiple type variables
    //ArrayList is apparently mutable all the time, so I'm not sure how to go about this
    private int hp;
    private ArrayList<String> type = new ArrayList<String>();
    private ArrayList<String> weakness = new ArrayList<String>();
    private ArrayList<String> resistance = new ArrayList<String>();
    private String stage;

    public ArrayList<String> getType(){
        ArrayList<String> copyType = new ArrayList<>(type);
        return copyType;
    }

    public void setType(String userInputType){
        type.add(userInputType);
    }

    public ArrayList<String> getResistance(){
        ArrayList<String> copyResistance = new ArrayList<>(resistance);
        return copyResistance;
    }

    public void setResistance(String userInputResistance){
        resistance.add(userInputResistance);
    }

    public ArrayList<String> getWeakness(){
        ArrayList<String> copyWeakness = new ArrayList<>(weakness);
        return copyWeakness;
    }

    public void setWeakness(String userInputWeakness){
        weakness.add(userInputWeakness);
    }

    public int getHp(){
        return hp;
    }
    public void setHp(int userInputHp){
        hp = userInputHp;
    }

    public String getStage() {return stage;}
    public void setStage(String userInputStage) {stage = userInputStage;}

}
