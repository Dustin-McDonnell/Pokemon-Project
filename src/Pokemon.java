public class Pokemon extends Card {
    private int hp;
    private String type;
    private String stage;
    private String weakness;
    private String resistance;

    public int getHp(){
        return hp;
    }
    public void setHp(int userInputHp){
        hp = userInputHp;
    }

    public String getType() {return type;}
    public void setType(String userInputType) {type = userInputType;}

    public String getStage() {return stage;}
    public void setStage(String userInputStage) {stage = userInputStage;}

    public String getWeakness(){return weakness;}
    public void setWeakness(String userInputWeakness) {weakness = userInputWeakness;}

    public String getResistance(){return resistance;}
    public void setResistance(String userInputResistance){resistance = userInputResistance;}

}
