package Tests;

import Energy.FireEnergy;
import Parent.Card;
import Parent.Energy;
import Parent.Pokemon;
import Pokemon.Dreepy;
import TrainerCards.Potion;
import TrainerCards.RareCandy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

//Unwound the Logic for the Monte Carlo tests as it was interfering with the Pokemon Game itself, easier to view
//Many of the same methods but without any arguments passed to them
public class MonteCarloEngine {
    private ArrayList<Card> deck;
    private ArrayList<Card> hand;
    private ArrayList<Card> prizePile;

    public MonteCarloEngine(int rareCandy) {
        this.deck = new ArrayList<>();
        this.hand = new ArrayList<>();
        this.prizePile = new ArrayList<>();

        for(int i = 0; i < 15; i++){
            deck.add(new Dreepy());
        }
        for(int i = 15; i < 25; i++){
            deck.add(new FireEnergy());
        }
        for(int i = 25; i < (25 + rareCandy); i++){
            deck.add(new RareCandy());
        }
        for(int i = (25+rareCandy); i<60; i++){
            deck.add(new Potion());
        }
    }

    public MonteCarloEngine(int pCards, int one) {
        System.out.println("Number of Pokemon Cards in deck: " + pCards);
        this.deck = new ArrayList<>();
        this.hand = new ArrayList<>();

        for(int i = 0; i < pCards; ++i) {
            this.deck.add(new Pokemon());
        }

        int deckSize = 60;

        for(int i = pCards; i < deckSize; ++i) {
            this.deck.add(new Energy());
        }

    }

    public Card drawCard() {
        Random rng = new Random();
        int cardIndex = rng.nextInt(deck.size()); //Find random card
        Card drawnCard = deck.get(cardIndex);
        deck.remove(cardIndex);
        return drawnCard;
    }

    public void drawPrizePile(){
        for (int i = 0; i < 6; i++) {
            prizePile.add(drawCard());
        }
    }

    public ArrayList<Card> getPrizePile(){
        return this.prizePile;
    }

    public ArrayList<Card> getHand(){
        return this.hand;
    }


    public void drawHand() {
        for (int i = 0; i < 7; i++) {
            hand.add(drawCard());
        }
    }

    public boolean evaluateOpeningHand() {
        for (int i = 0; i < hand.size(); i++) {
            Card currentCard = hand.get(i);
            if (currentCard instanceof Pokemon) {
                return true;
            }
        }
        return false;
    }

    public void shuffleDeck() {
        Collections.shuffle(deck);
    }

    public void returnHand() {
        for (int i = 0; i < hand.size(); i++) {
            deck.add(hand.get(i));
        }
        hand.clear();
    }

    public void returnPrizePile(){
        for (int i=0; i < prizePile.size(); i++){
            deck.add(prizePile.get(i));
        }
        prizePile.clear();
    }

}
