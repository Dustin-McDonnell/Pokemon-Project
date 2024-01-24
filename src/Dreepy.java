public class Dreepy extends Pokemon {
    public Dreepy() {
        setHp(60);
        setType("Psychic");
        setStage("Basic");
    }

    public void quickAttack(Pokemon target) {
        System.out.println("Dreepy use quick attack!");
        int targetHp = target.getHp();
        CoinFlip coin = new CoinFlip();
        if (coin.flip() == 1) {
            target.setHp(targetHp - 20);
        } else {
            target.setHp(targetHp - 10);
        }
        System.out.println("The enemy is weak! They only have " + target.getHp() + " hp left.");
    }
}
