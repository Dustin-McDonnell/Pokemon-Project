public class Pokemon extends Card {
    private int hp;
    private String type;
    private String stage;

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

}
