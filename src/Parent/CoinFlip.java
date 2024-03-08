package Parent;

import java.util.Random;

//Coin Flip with added flavor text for attacks that utilize a coin toss ie: Dreepy
public class CoinFlip {
    public int flip() {
        Random random = new Random();
        int coinFlip = random.nextInt(2);
        if (coinFlip == 1) {
            System.out.println("Coin flip: Heads!");
        } else {
            System.out.println("Coin flip: Tails!");
        }
        return coinFlip;
    }
}
