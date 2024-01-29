public class Dreepy extends Pokemon {
    public Dreepy() {
        setHp(60);
        setStage("Basic");
        setWeakness("Darkness");
        setResistance("Fighting");
        setType("Psychic");
    }

    public void quickAttack(Pokemon target) {
        AttackSequence atk = new AttackSequence();
        atk.moveBark("Dreepy", "Quick Attack");
        int damage = 10;
        //Coin flip to determine additional damage
        CoinFlip coin = new CoinFlip();
        if (coin.flip() == 1) {
            System.out.println("+10 Damage");
            damage = damage + 10;
        }
        //Determining target weakness
        atk.damageCalculation(damage, "Psychic", target);
    }
}
