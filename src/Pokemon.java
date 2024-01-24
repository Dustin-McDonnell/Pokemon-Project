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

    private String getType() {return type;}
    private void setType(String userInputType) {type = userInputType;}

    private String getStage() {return stage;}
    private void setStage(String userInputStage) {stage = userInputStage;}

}
