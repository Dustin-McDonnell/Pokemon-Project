package Pokemon;

import Parent.Pokemon;

//Bulbasaur, wrote this and then forgot about it, never used, but I thought leech seed was cool.
public class Bulbasaur extends Pokemon{

    public Bulbasaur(){
        setHp(70);
    }

    public void leechSeed(Pokemon target){
        //deal 20 heal 20
        int currentHp = target.getHp();
        int resultingHp = currentHp - 20;
        //Heal
        int thisCurrentHp = this.getHp();
        if(thisCurrentHp <= 50){
        this.setHp(thisCurrentHp + 20);
        }
        target.setHp(resultingHp);
    }

}
