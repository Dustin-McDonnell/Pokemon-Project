package Pokemon;

import Parent.Pokemon;

//Pikachu Pokemon, unimplemented
public class Pikachu extends Pokemon {

    public Pikachu(){
        setHp(70);
        setWeakness("Psychic");
    }

    public void quickAttack(Pokemon unfortunatePokemon){
        //deal ten damage
        int currentHp = unfortunatePokemon.getHp();
        int resultingHp = currentHp - 10;
        unfortunatePokemon.setHp(resultingHp);
    }
    
    public void electroBall(){
        //deal 60 damage
    }

}
