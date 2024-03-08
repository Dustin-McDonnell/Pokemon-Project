package TrainerCards;

import Parent.*;

//Heals the active Pokemon up to 30 hp, returns that the Pokemon did not need healing otherwise
//Lets you know if you do not currently have an active Pokemon

public class Potion extends Trainer {
    public Potion(){
        setName("Potion");
    }

    @Override
    public void activate(Player player) {
        if(!player.getActive().isEmpty()) {
            Pokemon pokemon = (Pokemon) player.getActive().getFirst();

                if (pokemon.getHp() < pokemon.getMaxHp()) {
                    if((pokemon.getHp() + 30) > pokemon.getMaxHp()){
                        pokemon.setHp(pokemon.getMaxHp());
                    }
                    else{
                        pokemon.setHp(pokemon.getHp() + 30);
                    }
                    System.out.println("Your Parent.Pokemon was healed!");
                }
                else {
                System.out.println("Your Parent.Pokemon didn't need healing!");
            }
        }
        else{
            System.out.println("You don't have an active pokemon!");
        }
    }
}
