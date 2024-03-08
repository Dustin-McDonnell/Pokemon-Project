package Tests;

import Parent.PokemonCardGame;

public class MonteCarloCardDraw {

    public void handPercentChance(int pCards) {
        PokemonCardGame test = new PokemonCardGame(pCards);
        double hasCard = 0;
        for (int i = 0; i < 1000; i++) {
            test.drawHand();
            boolean result = test.evaluateOpeningHand();
            test.returnHand();
            test.shuffleDeck();
            if (result == true) {
                hasCard++;
            }
        }
        System.out.println("Percent chance of drawing a pokemon card: " + hasCard / 1000);
        //checking if the githhub repo is working
    }
}
