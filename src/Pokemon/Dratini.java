package Pokemon;

import Parent.AttackSequence;
import Parent.Attackable;
import Parent.Player;
import Parent.Pokemon;

//Dratini with its attributes, contains the activate method like all Pokemon and the Pound Attack
//HP set to 10 for easy testing
public class Dratini extends Pokemon implements Attackable {
    public Dratini(){
        setName("Dratini");
        setResistance("Psychic");
        setHp(10);
        setMaxHp(40);
    }

    public void activate(Player player) {
        super.activate(player);
        if (player.getActive().size() == 0) {
            player.getActive().add(this);
        } else {
            if (player.getBench().size() < 5) {
                player.getBench().add(this);
            } else {
                System.out.println("You already have an active pokemon and a full bench.");
            }
        }
    }

    @Override
    public void attackOne(Pokemon target) {
        AttackSequence atk = new AttackSequence();
        atk.moveBark("Dratini", "Pound");
        int damage = 10;

        atk.damageCalculation(damage, getType(), target);
    }
}
