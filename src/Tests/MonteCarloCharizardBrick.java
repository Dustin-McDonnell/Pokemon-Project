package Tests;
import Parent.*;
import TrainerCards.RareCandy;
import java.util.ArrayList;


//Monte Carlo to check for the amount of rare candies needed in a deck to not 'brick'
public class MonteCarloCharizardBrick {
    public void brickChance(int rareCandy){
        MonteCarloEngine test = new MonteCarloEngine(rareCandy);

        double bricked = 0;
        double hasCandy = 0;
        double hasPokemon = 0;
        ArrayList<Card> hand = test.getHand();
        ArrayList<Card> prizePile = test.getPrizePile();
        int rareCandyCount = 0;

        for(int j = 0; j <1000000; j++) {
            test.drawHand();
            test.drawPrizePile();
            if (test.evaluateOpeningHand()) {
                //P(B)=A hand containing a pokemon
                hasPokemon ++;
                for (int i = 0; i < prizePile.size(); i++) {
                    if (prizePile.get(i) instanceof RareCandy) {
                        rareCandyCount++;
                    }
                }
                if (rareCandyCount == rareCandy) {
                    //P(A intersect B)= All rare Candies in prize pile and has a pokemon in opening hand
                    bricked++;
                }
            }
            test.returnHand();
            test.returnPrizePile();
            test.shuffleDeck();
            rareCandyCount = 0;
        }

        System.out.println("Rare Candy in Deck: " + rareCandy);
        System.out.println("Percent chance of being bricked:" + bricked/hasPokemon);
    }
}
