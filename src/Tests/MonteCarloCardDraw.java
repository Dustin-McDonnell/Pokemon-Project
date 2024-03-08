package Tests;

import Parent.PokemonCardGame;

//Monte Carlo for the percent chance of drawing a Pokemon in the intial card draw depending on how
//many pokemon cards are in the deck
public class MonteCarloCardDraw {

    public void handPercentChance(int pCards, int one) {
        MonteCarloEngine test = new MonteCarloEngine(pCards, one);
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
        System.out.println("Number of pokemon cards: " + pCards);
        System.out.println("Percent chance of drawing a pokemon card: " + hasCard / 1000);
        //checking if the githhub repo is working
    }
}
