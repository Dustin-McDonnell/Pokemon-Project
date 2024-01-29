import java.util.Random;

public class AttackSequence {
    public void damageCalculation(int damage, String attackType, Pokemon target){
        if (target.getWeakness().contains(attackType)){
            System.out.println("The enemy is weak to " + attackType +" attacks! It's Super Effective!");
            damage = damage * 2;
        }
        if (target.getResistance().contains(attackType)){
            System.out.println("The enemy is resistant to " + attackType + " Attacks! -30 Damage!");
            damage = damage - 30;
        }

        if(damage > 0) {
            target.setHp(target.getHp() - damage);
        }
        System.out.println("The enemy is weak! They only have " + target.getHp() + " hp left.");
    }

    public void moveBark(String pokemon, String move){
        Random rand = new Random();
        int rng = rand.nextInt(3);
        if (rng == 0){
            System.out.println(pokemon + " use " + move + "!" );
        }

        if (rng == 1){
            System.out.println(pokemon + " now! " + move + "!" );
        }

        if (rng == 2){
            System.out.println(pokemon + " go for it! Use " + move + "!" );
        }
    }

}
