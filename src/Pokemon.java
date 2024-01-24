public class Pokemon extends Card {
    private int hp;
    private String type1;
    private String type2;
    private String stage;
    private String weakness;
    private String resistance;

    public int getHp(){
        return hp;
    }
    public void setHp(int userInputHp){
        hp = userInputHp;
    }

    public String getType1() {return type1;}
    public void setType1(String userInputType1) {type1 = userInputType1;}

    public String getType2() {return type2;}
    public void setType2(String userInputType2) {type2 = userInputType2;}

    public String getStage() {return stage;}
    public void setStage(String userInputStage) {stage = userInputStage;}

    public String getWeakness(){return weakness;}
    public void setWeakness(String userInputWeakness) {weakness = userInputWeakness;}

    public String getResistance(){return resistance;}
    public void setResistance(String userInputResistance){resistance = userInputResistance;}

}
