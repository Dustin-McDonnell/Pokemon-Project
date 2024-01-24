public class Bulbasaur extends Pokemon{

    public Bulbasaur(){
        setHp(70);
    }

    public void leechSeed(Pokemon target){
        //deal 20 heal 20
        int currentHp = target.getHp();
        int resultingHp = currentHp - 20;
        //We're missing a line of code to make sure that this pokemon can heal
        int thisCurrentHp = this.getHp();
        if(thisCurrentHp <= 50){
        this.setHp(thisCurrentHp + 20);
        }
        target.setHp(resultingHp);
    }

}
