package Parent;

//Card Class, with the activate method
public class Card implements Attackable {
    private String name;

    public void setName(String userInput){
        name = userInput;
    }

    public String getName(){
        return name;
    }
    //private String type;
    public void activate(Player player){}
    public String stage(){
        return null;
    };

    @Override
    public void attackOne(Pokemon target) {

    }

    @Override
    public void attackTwo(Pokemon target) {

    }

}

//this is natalie, adding a comment for github!
