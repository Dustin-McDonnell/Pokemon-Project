public class Dreepy extends Pokemon implements Attackable{
    public Dreepy() {
        setHp(60);
        setStage("Basic");
        setWeakness("Darkness");
        setResistance("Fighting");
        setType("Psychic");
    }

    @Override
    public void activate(Player player) {
        super.activate(player);
        if (player.getActive() != null){
            player.setActive(this);
        }
        else{
            if (player.getBench().size() < 5){
                player.getBench().add(this);
            }
            else{
                System.out.println("You already have an active pokemon and a full bench.");
            }
        }
    }

    @Override
    //Quick Attack
    public void attackOne(Pokemon target) {
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
        atk.damageCalculation(damage, getType() , target);
    }

    @Override
    public void attackTwo(Pokemon target) {

    }
}
