package Tests;
import Parent.*;
import TrainerCards.RareCandy;

public class MonteCarloCharizardBrick {
    public void brickChance(int rareCandy){
        Player player1 = new Player();
        Player player2 = new Player();

        double bricked = 0;
        int rareCandyCount = 0;

            for(int i = 0; i < 1000; i++) {
                PokemonCardGame test = new PokemonCardGame(rareCandy);
                test.setUpGame(player1, player2);

                if (test.evaluateHandContainsBasic(player1)) {
                    for (int j = 0; j < player1.getPrizePile().size(); j++) {
                        Card card = player1.getPrizePile().get(j);
                        if (card instanceof RareCandy){
                            rareCandyCount ++;
                        }
                    }
                }
                if (rareCandyCount == rareCandy) {
                    bricked = bricked + 1;
                }
                System.out.println(rareCandyCount);
                rareCandyCount = 0;
            }

        //double brickChance = bricked/1000000;
        //System.out.println("Number of Rare Candy in Deck: " + (rareCandy + 1));
        //System.out.println("Brick chance: " + brickChance);
    }
}
