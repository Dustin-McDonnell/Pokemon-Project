public class Dreepy extends Pokemon {
    public Dreepy() {
        setHp(60);
        setType1("Psychic");
        setStage("Basic");
        setWeakness("Darkness");
        setResistance("Fighting");
    }

    public void quickAttack(Pokemon target) {
        System.out.println("Dreepy use quick attack!");
        int targetHp = target.getHp();
        int damage = 10;
        //Coin flip to determine additional damage
        CoinFlip coin = new CoinFlip();
        if (coin.flip() == 1) {
            damage = damage + 10;
        }
        //Determining target weakness
        if (target.getWeakness() == "Psychic"){
            System.out.println("The enemy is weak to Psychic attacks! It's Super Effective!");
            damage = damage * 2;
        }
        //final damage step
        target.setHp(targetHp - damage);

        System.out.println("The enemy is weak! They only have " + target.getHp() + " hp left.");
    }
}
