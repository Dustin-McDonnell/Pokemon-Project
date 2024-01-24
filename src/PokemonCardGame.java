import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
//60 card deck, in order to take a turn you need to have a basic pokemon in your hand
//monte carlo simulation?
//Let's write a monte carlo simulation. That means, using raw brute force, try to figure out
//something interesting
//What if your deck had exactly 1 pokemon. How many times would you expect to have to mulligan in order to
//have your only pokemon
//What if your deck had 2? Etc.
//Write a simulation that shows the expected mulligans at 1-60 pokemon in your deck.
public class PokemonCardGame {
    //A deck of cards
    private ArrayList<Card> deck;//This is the constructors job = new Card[];
    private ArrayList<Card> hand;

    public PokemonCardGame(int pCards){
        System.out.println("Number of Pokemon Cards in deck: " + pCards);
        deck = new ArrayList<Card>();
        hand = new ArrayList<Card>();
        for (int i = 0; i < pCards; i++){
            deck.add(new Pokemon());
        }
        int deckSize = 60;
        for(int i = pCards; i < deckSize; i++){
            deck.add(new Energy());
        }
    }

    public Card drawCard(){
        Random rng = new Random();
        int cardIndex = rng.nextInt(deck.size()); //Find random card
        Card drawnCard = deck.get(cardIndex);
        deck.remove(cardIndex);
        return drawnCard;
    }

    public void drawHand(){
        for (int i = 0; i < 7; i ++){
            hand.add(drawCard());
        }
    }

    public void returnHand(){
        for (int i = 0; i < hand.size(); i++){
            deck.add(hand.get(i));
        }
        hand.clear();
    }

    public void shuffleDeck(){
        Collections.shuffle(deck);
    }
    
    public boolean evaluateOpeningHand(){
        for (int i = 0; i < hand.size(); i++){
            Card currentCard = hand.get(i);
            if(currentCard instanceof Pokemon){
                return true;
            }
        }
        return false;
    }


//Make engine for program
public void averageHandDraw(){
    int counter = 0;
    int hasCard = 0;
    for (int i = 0; i < 1000; i++){
    boolean result = false;
    do{
        counter ++;
        drawHand();
        result = evaluateOpeningHand();
        returnHand();
        shuffleDeck();
    }
    while(result == false);
}
    System.out.println("Average amount of hands to draw for a pokemon after a thousand tests: " + counter/1000);
}

public void handPercentChance() {
        double hasCard = 0;
        for (int i = 0; i < 1000; i++){
            drawHand();
            boolean result = evaluateOpeningHand();
            returnHand();
            shuffleDeck();
            if(result == true){
                hasCard ++;
            }
        }
    System.out.println("Percent chance of drawing a pokemon card: " + hasCard/1000);
        //checking if the githhub repo is working
}
}

