package Parent;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Pokemon extends Card {


    //Pokemon class with the variables that apply to all Pokemon, along with the getters and setters
    private int hp;
    private int maxHp;
    private ArrayList<String> type = new ArrayList<String>();
    private ArrayList<String> weakness = new ArrayList<String>();
    private ArrayList<String> resistance = new ArrayList<String>();
    private String stage;
    private ArrayList<String> energy = new ArrayList<>();

    public ArrayList<String> getEnergy(){
        return energy;
    }

    public void setEnergy(ArrayList<String> userInputEnergy){
        energy = userInputEnergy;
    }

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

    public int getMaxHp(){
        return maxHp;
    }
    public void setMaxHp(int userInputHp){ maxHp = userInputHp;}

    public String getStage() {return stage;}
    public void setStage(String userInputStage) {stage = userInputStage;}

}
