package Pokemon;

import Parent.AttackSequence;
import Parent.Attackable;
import Parent.Player;
import Parent.Pokemon;

public class PunchingBag extends Pokemon implements Attackable {
    public PunchingBag(){
        setHp(10);
        setMaxHp(100);
        setName("Punching Bag");
        setType("Fire");
        setType("Water");
        setType("Darkness");
        setType("Psychic");
        setType("Fighting");
        setType("Grass");
        setType("Colorless");
        setType("Lightning");
        setType("Metal");
        setType("Dragon");

        setWeakness("Fire");
        setWeakness("Water");
        setWeakness("Darkness");
        setWeakness("Psychic");
        setWeakness("Fighting");
        setWeakness("Grass");
        setWeakness("Colorless");
        setWeakness("Lightning");
        setWeakness("Metal");
        setWeakness("Dragon");

        setResistance("Fire");
        setResistance("Water");
        setResistance("Darkness");
        setResistance("Psychic");
        setResistance("Fighting");
        setResistance("Grass");
        setResistance("Colorless");
        setResistance("Lightning");
        setResistance("Metal");
        setResistance("Dragon");
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
        atk.moveBark("Punching Bad", "Gnaw");
        int damage = 15;

        atk.damageCalculation(damage, getType(), target);
    }
}
